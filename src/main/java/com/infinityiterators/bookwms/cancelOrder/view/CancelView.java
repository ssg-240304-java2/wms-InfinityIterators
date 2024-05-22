package com.infinityiterators.bookwms.cancelOrder.view;

import com.infinityiterators.bookwms.account.User;
import com.infinityiterators.bookwms.cancelOrder.controller.CancelController;
import com.infinityiterators.bookwms.cancelOrder.model.dto.OrderDTO;

import java.util.List;
import java.util.Scanner;

import static com.infinityiterators.bookwms.utils.interaction.Input.requestInt;
import static com.infinityiterators.bookwms.utils.interaction.Menu.displayMenuHeader;
import static com.infinityiterators.bookwms.utils.interaction.Menu.displaySelectionMenu;

public class CancelView {
    private static PrintResult printResult;
    private static CancelController cancelController = new CancelController();
    private static Scanner sc = new Scanner(System.in); // Scanner 객체를 클래스 레벨에서 한 번만 생성

    public static void main(String[] args) {
//        while (true) {
////            displayMainMenu(user);
//        }
    }

    private static void displayMainMenu(User user) {
        displayMenuHeader("주문 관리 시스템");
        displaySelectionMenu("주문 하기", "주문 목록 조회 및 주문 취소 메뉴");

        int no = requestInt("메뉴를 선택해주세요");
        switch (no) {
            case 1: // 주문 하기 기능
                // orderBooks();
                break;
            case 2:
                UserOrderSearch(user);
                break;
            default:
                printResult.printErrorMessage("unselectError");
                break;
        }
    }

    public static void UserOrderSearch(User user) {
        boolean ordering = true; // 주문을 계속할지 여부를 나타내는 변수

        while (ordering) {
            displayMenuHeader("주문 목록 조회 메뉴");
            displaySelectionMenu("메인 메뉴로 돌아가기", "주문조회", "주문취소");

            int searchOption = requestInt("검색 옵션을 선택해주세요");
            switch (searchOption) {
                case 1:
                    ordering = false; // 메인 메뉴로 돌아가기
                    break;
                case 2:
                    System.out.println("주문 조회를 시작합니다."); // 디버깅 메시지 추가
                    searchOrder(user); // 주문조회
                    break;
                case 3:
                    updateCancelOrder(); // 주문취소
                    break;
                default:
                    System.out.println("잘못된 옵션을 선택하셨습니다.");
                    continue;
            }
        }
    }

    private static void updateCancelOrder() {
        cancelController.updateCancelOrder(cancelOrderCode());
    }

    private static OrderDTO cancelOrderCode() {
        System.out.print("주문취소: 취소할 코드를 입력하세요 : ");
        int order_id = sc.nextInt();
        sc.nextLine();

        OrderDTO order = new OrderDTO();
        order.setOrderId(order_id); // 이전 코드에서 주석 처리된 부분 수정

        return order;
    }

    private static void searchOrder(User user) {
        List<OrderDTO> orderList = cancelController.selectAllOrder();
//        System.out.println("주문 목록 조회 결과: " + orderList); // 디버깅 메시지 추가

        if (orderList == null || orderList.isEmpty()) {
            System.out.println("주문이 없습니다."); // 디버깅 메시지 추가
        } else {
            for (OrderDTO order : orderList) {
                // if (order.getUserCode() == testUser.getCode()) { // 이전 코드
                if (order.getUserCode() == user.getCode()) { // 테스트 사용자 코드 대신 실제 사용자 코드 사용
                    System.out.println(order.toString());
                }
            }
        }
    }
}

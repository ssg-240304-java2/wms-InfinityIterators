package com.infinityiterators.bookwms.order.view;

import com.infinityiterators.bookwms.order.controller.OrderController;
import com.infinityiterators.bookwms.order.dto.CartItemDTO;
import com.infinityiterators.bookwms.order.dto.OrderDTO;
import com.infinityiterators.bookwms.order.dto.OrderItemDTO;
import com.infinityiterators.bookwms.order.model.Cart;
import com.infinityiterators.bookwms.order.model.CartItem;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import static com.infinityiterators.bookwms.utils.interaction.Input.*;
import static com.infinityiterators.bookwms.utils.interaction.Menu.displayMenuHeader;
import static com.infinityiterators.bookwms.utils.interaction.Menu.displaySelectionMenu;

public class OrderMainMenu {
    private static PrintResult printResult;
    private static OrderController orderController = new OrderController();
    private static Cart cart = new Cart(1, 1); // 임시로 cartId와 userCode를 1로 설정

    public static void main(String[] args) {
/*추가 시작 라인*/
        Scanner sc = new Scanner(System.in);
        OrderController orderController = new OrderController();
/*추가 끝 라인*/
        // Scanner sc = new Scanner(System.in);
        // OrderController orderController = new OrderController();
        //
        // do {
        // System.out.println("===== 주문 관리 시스템 =====");
        // System.out.println("1. 주문 하기");
        // System.out.println("2. 주문 목록 조회");
        // System.out.println("==========================");
        // System.out.print("메뉴를 선택해주세요 : ");
        // int no = sc.nextInt();
        //
        // switch (no) {
        // case 1:
        // // todo : 주문하기 메뉴로 이동.
        // break;
        // case 2:
        // // todo: 주문 목록 조회 메뉴로 이동. 조회 메뉴 안에는 전체 주문 조회와 주문 삭제 기능이 필요 -> 채웅님
        // break;
        // default:
        // System.out.println("잘못된 메뉴를 선택하셨습니다.");
        // break;
        // }
        // } while (true);

        // scanner 대신의 utils의 Input 클래스를 사용하여 사용자 입력을 받기 시도

        displayMenuHeader("주문 관리 시스템");
        displaySelectionMenu("주문 하기", "주문 목록 조회");

        int no = requestInt("메뉴를 선택해주세요");
        switch (no) {
            case 1:
                orderBooks();

                break;

            case 2:
                // todo: 주문 목록 조회 메뉴로 이동. 조회 메뉴 안에는 전체 주문 조회와 주문 삭제 기능이 필요 -> 채웅님
                orderController.selectAllOrder(); break;
      //          break;
            default:
/*변경 전*/
//                System.out.println("잘못된 메뉴를 선택하셨습니다.");
/*변경 후*/
                printResult.printErrorMessage("unselectError");
                break;
        }
    }

    private static void orderBooks() {
        // TODO Auto-generated method stub
        boolean ordering = true; // 주문을 계속할지 여부를 나타내는 변수
        // Scanner scanner = new Scanner(System.in);

        while (ordering) {
            displayMenuHeader("도서 주문 메뉴");
            displaySelectionMenu("1. 전체 도서 목록 조회", "2. 도서 코드로 검색");

            int searchOption = requestInt("검색 옵션을 선택해주세요");
            switch (searchOption) {
                case 1:
                    // 임시로 전체 도서 목록을 출력하는 기능
                    System.out.println("전체 도서 목록을 출력합니다. (임시)");
                    break;

                case 2:
                    String bookCode = requestString("도서 코드를 입력해주세요");
                    // 임시로 도서 코드를 검색하는 기능
                    System.out.println("도서 코드 " + bookCode + "로 검색한 결과를 출력합니다. (임시)");
                    break;

                default:
                    System.out.println("잘못된 옵션을 선택하셨습니다.");
                    continue;
            }

            int bookId = requestInt("장바구니에 담을 도서 ID를 입력해주세요");
            int quantity = requestInt("수량을 입력해주세요");

            CartItemDTO cartItem = new CartItemDTO(0, cart.getCartId(), bookId, quantity);
            cart.addCartItem(cartItem);

            String more = requestString("더 담으시겠습니까? (y/n)");
            if (more.equalsIgnoreCase("n")) {
                ordering = false;
            }
        }

        checkout();
    }

    private static void checkout() {
        List<OrderItemDTO> orderItems = new ArrayList<>();
        for (CartItemDTO cartItem : cart.getItems()) {
            OrderItemDTO orderItem = new OrderItemDTO(0, 0, cartItem.getBookId(), cartItem.getQuantity());
            orderItems.add(orderItem);
        }

        OrderDTO order = new OrderDTO(0, cart.getUserCode(), new Date(), "대기");
        boolean isOrderCreated = orderController.createOrder(order, orderItems);

        if (isOrderCreated) {
            System.out.println("주문이 성공적으로 완료되었습니다.");
        } else {
            System.out.println("주문에 실패하였습니다.");
        }
    }
}

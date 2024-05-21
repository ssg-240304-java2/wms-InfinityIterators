/**
 * 주문 관리 시스템의 메인 메뉴를 제공하는 클래스입니다.
 * 이 클래스에는 주문 하기, 주문 목록 조회, 프로그램 종료 등의 기능이 포함되어 있습니다.
 * 사용자는 이 메인 메뉴를 통해 주문 관련 작업을 수행할 수 있습니다.
 */
package com.infinityiterators.bookwms.order.view;

import com.infinityiterators.bookwms.account.User;
import com.infinityiterators.bookwms.order.controller.OrderController;
import com.infinityiterators.bookwms.order.dao.OrderDAO;
import com.infinityiterators.bookwms.order.dto.CartItemDTO;
import com.infinityiterators.bookwms.order.dto.OrderDTO;
import com.infinityiterators.bookwms.order.dto.OrderItemDTO;
import com.infinityiterators.bookwms.order.model.Cart;
import com.infinityiterators.bookwms.receipt.Controller.ReceiptController;
import com.infinityiterators.bookwms.utils.interaction.*;

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
    private static ReceiptController receiptController = new ReceiptController();

    public static void displayMainMenu(User user) {
        displayMenuHeader("주문 관리 시스템");
        displaySelectionMenu("주문 하기", "주문 목록 조회", "프로그램 종료");

        int no = requestInt("메뉴를 선택해주세요");
        switch (no) {
            case 1: // 주문 하기 기능
                orderBooks();
                break;
            case 2:
                // todo: 주문 목록 조회 메뉴로 이동. 조회 메뉴 안에는 전체 주문 조회와 주문 삭제 기능이 필요 -> 채웅님
                orderController.selectAllOrder();
                break;
            case 3:
                // 프로그램 종료
                System.exit(0);
            default:
                printResult.printErrorMessage("unselectError");
                break;
        }
    }

    private static void orderBooks() {
        // 주문 메뉴에서 도서 주문을 처리하는 기능
        boolean ordering = true; // 주문을 계속할지 여부를 나타내는 변수
        Console.clear(); // 화면을 초기화

        while (ordering) {
            displayMenuHeader("도서 주문 메뉴");
            displaySelectionMenu("전체 도서 목록 조회 및 주문", "프로그램 종료");

            int searchOption = requestInt("검색 옵션을 선택해주세요");
            switch (searchOption) {
                case 1:
                    // 전체 도서 목록을 출력하는 기능. 입출고의 도서 담당 파트의 전체 도서 출력 기능을 활용해야 함.
                    receiptController.selectAllBook();
                    break;

                case 2:
                    // 프로그램 종료. 종료 하고 난 후 화면을 지우고 로고 출력
                    ordering = false;
                    Console.clear();
                    Menu.displayLogo();

                    // String bookCode = requestString("도서 코드를 입력해주세요");
                    // // 도서 코드를 검색하여 해당 도서 정보를 출력하는 기능
                    // orderController.searchBookByCode(bookCode);
                    break;

                default:
                    Console.print("잘못된 메뉴를 선택하셨습니다.", DisplayType.ERROR, true);
                    continue;
            }

            int bookId = requestInt("장바구니에 담을 도서 ID를 입력해주세요"); // 장바구니에 담을 도서 ID를 입력받음
            int quantity = requestInt("수량을 입력해주세요");

            CartItemDTO cartItem = new CartItemDTO(0, cart.getCartId(), bookId, quantity);
            cart.addCartItem(cartItem);

            while (true) {
                String more = requestString("더 담으시겠습니까? (y/n)").trim().toLowerCase();
                if (more.equals("n")) {
                    ordering = false;
                    break;
                } else if (more.equals("y")) {
                    break;
                } else {
                    Console.print("잘못된 입력입니다. y 또는 n을 입력해주세요.", DisplayType.ERROR, true);
                }
            }
        }

        checkout();
        Console.clear();
    }

    private static void checkout() {
        List<OrderItemDTO> orderItems = new ArrayList<>();
        for (CartItemDTO cartItem : cart.getItems()) {
            OrderItemDTO orderItem = new OrderItemDTO(0, 0, cartItem.getBookId(), cartItem.getQuantity());
            orderItems.add(orderItem);
//             System.out.println("OrderItemDTO: " + orderItem); // 디버깅 로그 추가
        }

        OrderDTO order = new OrderDTO(0, cart.getUserCode(), new Date(), "대기");
        boolean isOrderCreated = orderController.createOrder(order, orderItems);

        if (isOrderCreated) {
            // 생성된 주문 ID를 가져와서 설정
            int orderId = order.getOrderId();
//             System.out.println("생성된 주문 ID: " + orderId); // 디버깅 로그 추가
//             System.out.println("OrderDTO 상태: " + order); // 디버깅 로그 추가

            Console.print("주문이 성공적으로 생성되었습니다.", DisplayType.SYSTEM, true);

            String purchaseDecision = requestString("구매를 하시겠습니까? (y/n)");
            if (purchaseDecision.equalsIgnoreCase("y")) {
                // 주문 ID를 이용하여 주문 상태를 완료로 변경
//                order.setStatus("완료");
                boolean isOrderCompleted = orderController.completeOrder(order);
                if (isOrderCompleted) {
                    Console.print("구매가 성공적으로 완료되었습니다.", DisplayType.SYSTEM, true);
                    printReceipt(order, orderItems); // 영수증 출력 메서드 호출
                } else {
                    Console.print("구매 완료에 실패하였습니다.", DisplayType.ERROR, true);
                }
            } else {
                Console.print("구매가 취소되었습니다.", DisplayType.SYSTEM, true);
            }
        } else {
            Console.print("주문 생성에 실패하였습니다.", DisplayType.ERROR, true);
        }
    }

    private static void printReceipt(OrderDTO order, List<OrderItemDTO> orderItems) {
        // DAO에서 주문서 데이터를 조회하는 기능 추가
        OrderDAO orderDAO = new OrderDAO();
        OrderDTO fetchedOrder = orderDAO.selectOrderById(order.getOrderId());
        List<OrderItemDTO> fetchedOrderItems = orderDAO.getOrderItemsByOrderId(order.getOrderId());

        if (fetchedOrder != null) {
            // System.out.println("Fetched OrderDTO: " + fetchedOrder); // 디버깅 로그 추가
            // order = fetchedOrder;
        } else {
            Console.print("주문을 찾을 수 없습니다.", DisplayType.ERROR, true);
            return;
        }

        if (fetchedOrderItems != null) {
            orderItems.clear();
            orderItems.addAll(fetchedOrderItems);
        } else {
            Console.print("주문 항목을 찾을 수 없습니다.", DisplayType.ERROR, true);
            return;
        }

        Console.clear();
        Console.print("=============== 주문서 정보 ================", DisplayType.MENU_HEADER, true);
        Console.print("주문 ID: " + order.getOrderId(), DisplayType.SYSTEM, true);
        Console.print("사용자 코드: " + order.getUserCode(), DisplayType.SYSTEM, true);
        Console.print("주문 날짜: " + order.getOrderDate(), DisplayType.SYSTEM, true);
        Console.print("주문 상태: " + order.getStatus(), DisplayType.SYSTEM, true);
        for (OrderItemDTO orderItem : orderItems) {
            Console.print("책 ID: " + orderItem.getBookID() + ", 수량: " + orderItem.getQuantity(), DisplayType.SYSTEM,
                    true);
        }
    }

}

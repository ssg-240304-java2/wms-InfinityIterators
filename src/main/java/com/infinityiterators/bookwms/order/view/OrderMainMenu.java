package com.infinityiterators.bookwms.order.view;

import com.infinityiterators.bookwms.order.controller.OrderController;
import com.infinityiterators.bookwms.order.dao.OrderDAO;
import com.infinityiterators.bookwms.order.dto.CartItemDTO;
import com.infinityiterators.bookwms.order.dto.OrderDTO;
import com.infinityiterators.bookwms.order.dto.OrderItemDTO;
import com.infinityiterators.bookwms.order.model.Cart;
import com.infinityiterators.bookwms.order.model.CartItem;
import com.infinityiterators.receipt.Controller.ReceiptController;
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

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        OrderController orderController = new OrderController();

        while (true) {
            displayMainMenu();
        }
    }

    private static void displayMainMenu() {
        displayMenuHeader("주문 관리 시스템");
        displaySelectionMenu("주문 하기", "주문 목록 조회");

        int no = requestInt("메뉴를 선택해주세요");
        switch (no) {
            case 1: // 주문 하기 기능
                orderBooks();
                break;
            case 2:
                // todo: 주문 목록 조회 메뉴로 이동. 조회 메뉴 안에는 전체 주문 조회와 주문 삭제 기능이 필요 -> 채웅님
                orderController.selectAllOrder();
                break;
            default:
                printResult.printErrorMessage("unselectError");
                break;
        }
    }

    private static void orderBooks() {
        // 주문 메뉴에서 도서 주문을 처리하는 기능
        boolean ordering = true; // 주문을 계속할지 여부를 나타내는 변수

        while (ordering) {
            displayMenuHeader("도서 주문 메뉴");
            displaySelectionMenu("전체 도서 목록 조회", "도서 코드로 검색");

            int searchOption = requestInt("검색 옵션을 선택해주세요");
            switch (searchOption) {
                case 1:
                    // 전체 도서 목록을 출력하는 기능. 입출고의 도서 담당 파트의 전체 도서 출력 기능을 활용해야 함.
                    receiptController.selectAllStock();
                    break;

                case 2:
                    String bookCode = requestString("도서 코드를 입력해주세요");
                    // 도서 코드를 검색하여 해당 도서 정보를 출력하는 기능
                    orderController.searchBookByCode(bookCode);
                    break;

                default:
                    Console.print("잘못된 메뉴를 선택하셨습니다.", DisplayType.ERROR, true);
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
            Console.print("주문이 성공적으로 생성되었습니다.", DisplayType.SYSTEM, true);

            String purchaseDecision = requestString("구매를 하시겠습니까? (Y/N)");
            if (purchaseDecision.equalsIgnoreCase("Y")) {
                boolean isOrderCompleted = orderController.completeOrder(order.getOrderId());
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
        order = orderDAO.selectOrderById(order.getOrderId());
        orderItems = orderDAO.getOrderItemsByOrderId(order.getOrderId());

        Console.clear();
        Console.print("주문서 정보:", DisplayType.MENU_HEADER, true);
        Console.print("주문 ID: " + order.getOrderId(), DisplayType.SYSTEM, true);
        Console.print("사용자 코드: " + order.getUser_code(), DisplayType.SYSTEM, true);
        Console.print("주문 날짜: " + order.getOrderDate(), DisplayType.SYSTEM, true);
        Console.print("주문 상태: " + order.getStatus(), DisplayType.SYSTEM, true);
        for (OrderItemDTO orderItem : orderItems) {
            System.out.println("책 ID: " + orderItem.getBookId() + ", 수량: " + orderItem.getQuantity());
        }
    }
}

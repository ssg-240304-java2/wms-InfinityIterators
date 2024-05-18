package com.infinityiterators.bookwms.order.view;

import com.infinityiterators.bookwms.order.controller.OrderController;
import com.infinityiterators.bookwms.order.model.dto.OrderDTO;

import java.util.Date;
import java.util.Scanner;

import static com.infinityiterators.bookwms.utils.interaction.Input.requestInt;
import static com.infinityiterators.bookwms.utils.interaction.Menu.displayMenuHeader;
import static com.infinityiterators.bookwms.utils.interaction.Menu.displaySelectionMenu;

public class OrderView {

    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        OrderController orderController = new OrderController();
//
//        do {
//            System.out.println("===== 주문 관리 시스템 =====");
//            System.out.println("1. 주문 하기");
//            System.out.println("2. 주문 목록 조회");
//            System.out.println("==========================");
//            System.out.print("메뉴를 선택해주세요 : ");
//            int no = sc.nextInt();
//
//            switch (no) {
//                case 1:
//                    // todo : 주문하기 메뉴로 이동.
//                    break;
//                case 2:
//                    // todo: 주문 목록 조회 메뉴로 이동. 조회 메뉴 안에는 전체 주문 조회와 주문 삭제 기능이 필요 -> 채웅님
//                    break;
//                default:
//                    System.out.println("잘못된 메뉴를 선택하셨습니다.");
//                    break;
//            }
//        } while (true);

        // scanner 대신의 utils의 Input 클래스를 사용하여 사용자 입력을 받기 시도
        displayMenuHeader("주문 관리 시스템");
        displaySelectionMenu("주문 하기", "주문 목록 조회");

        int no = requestInt("메뉴를 선택해주세요");
        switch (no) {
            case 1:
                // todo : 주문하기 메뉴로 이동.
                break;

            case 2:
                // todo: 주문 목록 조회 메뉴로 이동. 조회 메뉴 안에는 전체 주문 조회와 주문 삭제 기능이 필요 -> 채웅님
                break;
            default:
                System.out.println("잘못된 메뉴를 선택하셨습니다.");
                break;
        }
    }
}

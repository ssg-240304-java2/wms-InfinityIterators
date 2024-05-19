package com.infinityiterators.shipment.view;

import com.infinityiterators.shipment.controller.ShipmentController;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ShipmentView {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ShipmentController shipmentController = new ShipmentController();

        while (true) {
            System.out.println("=== 출고 관리 ===");
            System.out.println("1. 주문서 출력");        // 처음 시작이 주문서와 출고 2가지로 나옴
            System.out.println("2. 출고하기");      // 여기서는 문자로 입력을 받고싶음
            System.out.println("3. 품절처리하기");
            System.out.print("동작할 번호를 입력하시오 : ");


            int no = sc.nextInt();
            sc.nextLine(); // 버퍼 비우기

            switch (no) {
                case 1:
                    shipmentController.selectAllShipmentDate();
                    break;
                case 2:
                    shipmentController.selectShipmentPlay(shipmentPlay());
                    break;
                case 3:
                    shipmentController.selectSoldOut(soldOut());
                default:
                    System.out.println("잘못된 메뉴 선택");
                    break;
            }
        }
    }

    private static Map<String, String> soldOut() {

        Scanner sc = new Scanner(System.in);
        System.out.println("품절처리할 도서 코드를 입력하시오 : ");
        String bookID = sc.nextLine();

        Map<String, String> parameter = new HashMap<>();
        parameter.put("bookID", bookID);

        return parameter;
    }


    private static Map<String, String> shipmentPlay() {

        Scanner sc = new Scanner(System.in);
        System.out.print("출고할 도서 코드를 입력하세요 : ");
        String bookID = sc.nextLine();
        System.out.print("출고할 도서 수량을 입력하세요 : ");
        String outAmount = sc.nextLine();


        Map<String, String> parameter = new HashMap<>();
        parameter.put("bookID", bookID);
        parameter.put("outAmount", outAmount);

        return parameter;
    }
}



package com.infinityiterators.shipment.view;

import com.infinityiterators.shipment.controller.ShipmentController;
import com.infinityiterators.shipment.model.dto.ShipmentDTO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class ShipmentView {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ShipmentController shipmentController = new ShipmentController();

        while (true) {
            System.out.println("=== 출고 관리 ===");
            System.out.println("1. 주문서 출력");        // 처음 시작이 주문서와 출고 2가지로 나옴
            System.out.println("2. 출고파트로 넘어가기");      // 여기서는 문자로 입력을 받고싶음
            System.out.print("동작할 번호를 입력하시오 : ");
            System.out.println("===============");

            int no = sc.nextInt();
            sc.nextLine(); // 버퍼 비우기

            switch (no) {
                case 1:
                    shipmentController.selectAllShipmentDate();
                    break;
                case 2:
                    shipmentController.selectShipmentPlay();
                    break;
                default:
                    System.out.println("잘못된 메뉴 선택");
                    break;
            }
        }
    }
    }

    // ==========================================
//    private static Map<String, String> inputShipmentDate() {
//        // 도서 출고 테이블 받아오기
//        return null;
//    }
//
//    private static Map<String, String> inputShipmentPlay() {
//        Scanner sc = new Scanner(System.in);
//        System.out.println("출고하시겠습니까(Y/N)");
//        String shipmentPlay = sc.nextLine();
//
//        if ("N".equals(shipmentPlay)){
//            System.out.println("품절처리할 도서 코드를 입력하시오");
//            String bookId = sc.nextLine();
//            System.out.println("품절처리할 도서 수량을 입력하시오");
//            String quantity = sc.nextLine();
//        } else if ("Y".equals(shipmentPlay)) {
//            System.out.println("출고할 도서 코드를 입력하시오");
//            String bookId = sc.nextLine();
//            System.out.println("출고할 도서 수량을 입력하시오");
//            String quantity = sc.nextLine();
//
//            System.out.println("추가로 출고하시겠습니까(Y/N)");
//            String additionalShipment = sc.nextLine().trim().toUpperCase();
//            if ("N".equals(additionalShipment)) {
//                System.out.println("출고 내역을 조회하시겠습니까(Y/N)");
//                String viewHistory = sc.nextLine().trim().toUpperCase();
//                if ("Y".equals(viewHistory)) {
//                    Map<Integer, ShipmentDTO> history = shipmentService.getShipmentHistory();
//                    for (Map.Entry<Integer, ShipmentDTO> entry : history.entrySet()) {
//                        System.out.println(entry.getValue());
//                    }
//                }
//                boolean continueLoop = false;
//            }
//
//        } else {
//            result.put("message","Invalid input. Please enter 'Y' or 'N'.");
//        }
//
//        Map<String, String> parameter = new HashMap<>();
//        parameter.put("shipmentPlay", shipmentPlay);
//
//    }




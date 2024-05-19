package com.infinityiterators.shipment.controller;

import com.infinityiterators.shipment.model.dto.ShipmentDTO;
import com.infinityiterators.shipment.service.ShipmentService;

import java.util.List;
import java.util.Map;
import java.util.Scanner;


public class ShipmentController {

    private final PrintResult printResult;
    private final ShipmentService shipmentService;

    public ShipmentController() {
        printResult = new PrintResult();
        shipmentService = new ShipmentService();
    }

    public void selectAllShipmentDate() {

        List<ShipmentDTO> shipmentList = shipmentService.selectAllShipmentDate();

        if (shipmentList != null) {
            printResult.printShipmentList(shipmentList);
        } else {
            printResult.printErrorMessage("selectList");
        }

    }

    public void selectShipmentPlay() {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("출고하시겠습니까(Y/N)");
            String shipmentPlay = sc.nextLine().trim().toUpperCase();

            if ("N".equals(shipmentPlay)) {
                System.out.println("품절처리할 도서 코드를 입력하시오");
                String bookID = sc.nextLine();
                System.out.println("품절처리할 도서 수량을 입력하시오");
                String quantity = sc.nextLine();
//                String message = shipmentService.processOutOfStock(Integer.parseInt(bookID));
//                System.out.println(message);
                break;  // 품절 처리 후 루프 종료
            } else if ("Y".equals(shipmentPlay)) {
                System.out.println("출고할 도서 코드를 입력하시오");
                String bookID = sc.nextLine();
                System.out.println("출고할 도서 수량을 입력하시오");
                int quantity = Integer.parseInt(sc.nextLine());
//                String message = shipmentService.processShipment(Integer.parseInt(bookID), quantity);
//                System.out.println(message);

                System.out.println("추가로 출고하시겠습니까(Y/N)");
                String additionalShipment = sc.nextLine().trim().toUpperCase();
                if ("N".equals(additionalShipment)) {
                    System.out.println("출고 내역을 조회하시겠습니까(Y/N)");
                    String viewHistory = sc.nextLine().trim().toUpperCase();
                    if ("Y".equals(viewHistory)) {
//                        Map<Integer, ShipmentDTO> history = shipmentService.getShipmentHistory();
//                        for (Map.Entry<Integer, ShipmentDTO> entry : history.entrySet()) {
//                            System.out.println(entry.getValue());
                        }
                    }
                    break;  // 추가 출고를 하지 않을 경우 루프 종료
                }
//            } else {
//                System.out.println("Invalid input. Please enter 'Y' or 'N'.");
            }
        }
    }



//    public void SelectShipmentByCode(Map<String, String> parameter) {
//
//        int code = Integer.parseInt(parameter.get("code"));
//
//        ShipmentDTO shipment = shipmentService.selectShipmentByCode(code);
//
//        if (shipment != null) {
//            printResult.printshipment(shipment);
//        } else {
//            printResult.printErrorMessage("selectOne");
//        }
//    }





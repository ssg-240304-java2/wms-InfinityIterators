package com.infinityiterators.shipment.controller;

import com.infinityiterators.shipment.model.OutRecordDTO;
import com.infinityiterators.shipment.service.ShipmentService;

import java.util.*;

public class ShipmentController {
    private final PrintResult printResult;
    private final ShipmentService shipmentService;

    public ShipmentController() {
        printResult = new PrintResult();
        shipmentService = new ShipmentService();
    }

    public void selectAllShipmentDate() {

        List<OutRecordDTO> shipmentList = shipmentService.selectAllShipmentDate();

        if (shipmentList != null) {
            printResult.printShipmentList(shipmentList);
        } else {
            printResult.printErrorMessage("selectList");
        }

    }

    public void selectShipmentPlay(Map<String, String> parameter) {

        Scanner sc = new Scanner(System.in);
        boolean continueLoop = true;

        while (continueLoop) {
        String bookID = parameter.get("bookID");
        int amount = Integer.parseInt(parameter.get("amount"));

        OutRecordDTO out = new OutRecordDTO();
        out.setBookID(bookID);
        out.setOutAmount(amount);

        if (shipmentService.selectShipmentPlay(out)){
            printResult.printSuccessMessage("update");
        } else {
            printResult.printErrorMessage("update");
        }
            System.out.println("추가로 출고하시겠습니까?(Y/N)");
        String continueInput = sc.next().trim().toUpperCase();
        if ("N".equals(continueInput)) {
            System.out.println("출고 내역을 조회하시겠습니까? (Y/N)");
            String viewHistory = sc.nextLine().trim().toUpperCase();
            if ("Y".equals(viewHistory)) {
                getShipmentHistory();
            }
            continueLoop = false;
        }else {
            System.out.println("출고할 도서 코드를 입력하시오.");
            bookID = sc.nextLine();
            System.out.print("출고할 도서 수량을 입력하세요 : ");
            String outAmount = sc.nextLine();
            parameter.put("bookID", bookID);
            parameter.put("outAmount", outAmount);
        }
    }
        }
    public void selectSoldOut(Map<String, String> parameter) {
        String bookID = parameter.get("bookID");

        OutRecordDTO out = new OutRecordDTO();
        out.setBookID(bookID);

        if (shipmentService.selectShipmentSoldOut(out)){
            printResult.printSuccessMessage("update");
        } else {
            printResult.printErrorMessage("update");
        }
        System.out.print("다시 출고하시겠습니까? (Y/N): ");
        Scanner sc = new Scanner(System.in);
        String continueInput = sc.nextLine().trim().toUpperCase();
        if ("Y".equals(continueInput)) {
            selectShipmentPlay(new HashMap<>());
        }
    }

    public void getShipmentHistory() {
        Map<Integer, OutRecordDTO> history = shipmentService.getShipmentHistory();
        if (history != null) {
            for (Map.Entry<Integer, OutRecordDTO> entry : history.entrySet()) {
                System.out.println(entry.getValue());
            }
        } else {
            System.out.println("출고 내역 조회에 실패했습니다.");
        }
    }

    }







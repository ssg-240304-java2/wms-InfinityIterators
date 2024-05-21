package com.infinityiterators.bookwms.shipment.controller;

import com.infinityiterators.bookwms.shipment.model.OrderDTO;
import com.infinityiterators.bookwms.shipment.model.OutRecordDTO;
import com.infinityiterators.bookwms.shipment.service.ShipmentService;
import com.infinityiterators.bookwms.shipment.model.StockOutDTO;

import java.util.*;



public class ShipmentController {
    private final PrintResult printResult;
    private final ShipmentService shipmentService;

    public ShipmentController() {

        printResult = new PrintResult();
        shipmentService = new ShipmentService();
    }

    public void selectAllShipmentDate() {       // 주문서 출력

        List<OrderDTO> order = shipmentService.selectAllShipmentDate();

        if (order != null) {
            printResult.printShipmentList(order);
        } else {
            printResult.printErrorMessage("selectList");
        }
    }




        public void selectShipmentPlay(StockOutDTO parameter) {         // 출고하기
//        Scanner sc = new Scanner(System.in);

        String bookId = parameter.getBookID();
        int bookAmount = parameter.getBookAmount();

        StockOutDTO out = new StockOutDTO();
        out.setBookID(bookId);
        out.setBookAmount(bookAmount);

        if (shipmentService.selectShipmentPlay(out)) {
            printResult.printSuccessMessage("update");
        } else {
            printResult.printErrorMessage("update");
        }
//        sc.close();
    }

    public void selectSoldOut(StockOutDTO parameter) {          // 품절처리

        String bookId = parameter.getBookID();

        StockOutDTO out = new StockOutDTO();
        out.setBookID(bookId);

        if (shipmentService.soldOut(out)) {
            printResult.printSuccessMessage("soldOut");
        } else {
            printResult.printErrorMessage("soldOut");
        }
    }

    public void selectShipmentDetails(OutRecordDTO details) {       // 출고내역 조회
        List<OutRecordDTO> outRecordDTO = shipmentService.selectShipmentDetails(details);
        if (outRecordDTO != null) {
            printResult.printOutRecordList(outRecordDTO);
        } else {
            printResult.printErrorMessage("outRecordDTO");
        }
    }
}








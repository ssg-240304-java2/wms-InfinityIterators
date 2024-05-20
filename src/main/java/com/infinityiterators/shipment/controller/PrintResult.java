package com.infinityiterators.shipment.controller;

import com.infinityiterators.shipment.model.OutRecordDTO;

import java.util.List;

public class PrintResult {

    public void printShipmentList(List<OutRecordDTO> shipmentList) {
        System.out.println("=== 주문서 목록 ===");
        for (OutRecordDTO shipment : shipmentList) {
            System.out.println(shipment);
        }
        System.out.println("=================");
        // 내일 테이블에서 목록 받아오기
    }

    public void printErrorMessage(String errorCode) {
        String errorMessage = "";
        switch (errorCode) {
            case "update":
                errorMessage = "출고를 실패하였습니다.";
                break;
            case "soldOut":
                errorMessage = "품절처리에 실패했습니다.";
                break;
        }
        System.out.println(errorMessage);
    }

    public void printSuccessMessage(String successCode) {
        String successMessage = "";
        switch (successCode) {
            case "update":
                successMessage = "출고에 성공하였습니다.";
                break;
            case "soldOut":
                successMessage = "품절처리되었습니다.";
                break;
        }
        System.out.println(successMessage);
    }
}

package com.infinityiterators.bookwms.order.view;

import com.infinityiterators.bookwms.order.dto.OrderDTO;

import java.util.List;

public class PrintResult {

    public void printMenuList(List<OrderDTO> orderList){

        for(OrderDTO order : orderList) {
            System.out.println(order);
        }

    }


    public void printOrder(OrderDTO order){
        System.out.println(order);
    }

    public void printErrorMessage(String errorId) {

        String errorMessage = "";
        switch(errorId) {
            case "selectList"   : errorMessage = "주문 목록 조회를 실패하였습니다.";     break;
            case "selectDetail" : errorMessage = "주문 상세보기를 실패하였습니다.";      break;
            case "selectCancel" : errorMessage = "주문 취소 목록 조회를 실패하였습니다."; break;
            case "insert"       : errorMessage = "주문 등록를 실패하였습니다.";          break;
            case "update"       : errorMessage = "주문 수정을 실패하였습니다.";          break;
            case "delete"       : errorMessage = "주문 취소를 실패하였습니다.";          break;
        }

        System.out.println(errorMessage);
    }

    public void printSuccessMessage(String successId) {
        String successMessage = "";
        switch(successId) {
            case "insert"       : successMessage = "주문 등록를 성공하였습니다.";       break;
            case "update"       : successMessage = "주문 수정을 성공하였습니다.";       break;
            case "delete"       : successMessage = "주문 취소를 성공하였습니다.";       break;
        }

        System.out.println(successMessage);
    }
}

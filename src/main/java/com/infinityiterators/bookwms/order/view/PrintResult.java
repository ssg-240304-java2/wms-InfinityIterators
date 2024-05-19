package com.infinityiterators.bookwms.order.view;

import com.infinityiterators.bookwms.order.dto.OrderDTO;
import com.infinityiterators.bookwms.order.model.service.OrderService;

import java.util.List;

public class PrintResult {


    public void printOrderList(List<OrderDTO> orderList){

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
            case "selectListError"   : errorMessage = "주문 목록 조회를 실패하였습니다.";     break;
            case "selectDetailError" : errorMessage = "주문 상세보기를 실패하였습니다.";      break;
            case "selectCancelError" : errorMessage = "주문 취소 목록 조회를 실패하였습니다."; break;
            case "insertError"       : errorMessage = "주문 등록를 실패하였습니다.";          break;
            case "updateError"       : errorMessage = "주문 수정을 실패하였습니다.";          break;
            case "deleteError"       : errorMessage = "주문 취소를 실패하였습니다.";          break;
            case "unselectError"     : errorMessage = "잘못된 메뉴를 선택하셨습니다";          break;
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

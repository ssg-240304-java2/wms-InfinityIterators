package com.infinityiterators.receipt.Controller;

import com.infinityiterators.receipt.model.dto.BookDTO;
import com.infinityiterators.receipt.model.service.ReceiptService;

import java.util.List;

public class ReceiptController {

    private final ReceiptService receiptService;

    public ReceiptController() {

        receiptService = new ReceiptService();
    }

    public void selectAllStock() {

        List<BookDTO> bookList = receiptService.selectAllStock();

        if(bookList != null){
            printResultList(bookList);
        } else{
            printErrorMessage("selectList");
        }
    }

    public void selectStockIn() {
    }

    public void selectOutOfStock() {
    }

    public void printResultList(List<BookDTO> bookList){

        for(BookDTO book : bookList){
            System.out.println(book);
        }
    }

    public void printErrorMessage(String errorCode) {

        String errorMessage = "";
        switch (errorCode){
            case "selectList" : errorMessage = "재고 현황 조회를 실패하였습니다."; break;
        }
        System.out.println(errorMessage);
    }
}

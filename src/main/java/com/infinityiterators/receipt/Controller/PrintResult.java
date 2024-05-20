package com.infinityiterators.receipt.Controller;

import com.infinityiterators.receipt.model.dto.BookDTO;

import java.awt.print.Book;
import java.util.List;

public class PrintResult {
    public void printResultList(List<BookDTO> bookList) {

        for(BookDTO book : bookList){
            System.out.println(book);
        }
    }

    public void printErrorMessage(String errorCode) {

        String errorMessage = "";
        switch (errorCode){
            case "selectList" : errorMessage = "재고 현황 조회를 실패하였습니다."; break;
            case "insert" : errorMessage = "신규 도서 입고를 실패하였습니다."; break;
        }
        System.out.println(errorMessage);
    }

    public void printSuccessMessage(String successCode) {

        String successMessage = "";
        switch(successCode){
            case "insert" : successMessage = "신규 도서 입고를 성공하였습니다."; break;
        }
        System.out.println(successMessage);
    }
}

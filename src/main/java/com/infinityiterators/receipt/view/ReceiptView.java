package com.infinityiterators.receipt.view;

import com.infinityiterators.receipt.Controller.ReceiptController;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ReceiptView {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ReceiptController receiptController = new ReceiptController();

        do{         // Main Menu
            System.out.println("===== 서점 재고 관리 시스템 =====");
            System.out.println("1. 전체 재고 현황 조회");
            System.out.println("2. 입고하기");
            System.out.println("3. 출고하기");
            System.out.println("===============================");
            System.out.print("메뉴를 선택해주세요 : ");
            int no = sc.nextInt();

            switch(no){
                case 1: receiptController.selectAllBook(); break;
                case 2: receiptController.selectStockIn(inputBook()); break;
                case 3: receiptController.selectOutOfStock();break;
                default:
                    System.out.println("잘못된 메뉴를 선택하셨습니다."); break;
            }

            // 추가입고 여부 확인
            System.out.print("추가 입고하시겠습니까? (Y/N) : ");
            String answer = sc.nextLine();
            if(!answer.equalsIgnoreCase("Y")){
                break;
            }
        } while (true);
    }

    private static Map<String, String> inputBook() {

        Scanner sc = new Scanner(System.in);
        System.out.print("도서 코드를 입력하세요 : ");
        String bookID = sc.nextLine();
        System.out.print("입고량을 입력하세요 : ");
        String inAmount = sc.nextLine();

        Map<String, String> parameter = new HashMap<>();
        parameter.put("", bookID);
        parameter.put("inAmount", inAmount);

        return parameter;

    }
}

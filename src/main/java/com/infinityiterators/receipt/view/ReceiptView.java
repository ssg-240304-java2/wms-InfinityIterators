package com.infinityiterators.receipt.view;

import com.infinityiterators.receipt.Controller.ReceiptController;

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
                case 1: receiptController.selectAllStock(); break;
                case 2: receiptController.selectStockIn(); break;
                case 3: receiptController.selectOutOfStock();break;
                default:
                    System.out.println("잘못된 메뉴를 선택하셨습니다."); break;
            }
        } while (true);
    }
}

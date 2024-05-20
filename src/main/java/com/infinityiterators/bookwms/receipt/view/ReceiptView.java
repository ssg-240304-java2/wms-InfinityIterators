package com.infinityiterators.bookwms.receipt.view;

import com.infinityiterators.bookwms.receipt.model.dto.StockDTO;
import com.infinityiterators.bookwms.receipt.Controller.ReceiptController;
import com.infinityiterators.bookwms.receipt.model.dto.BookDTO;

import java.util.Scanner;

public class ReceiptView {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ReceiptController receiptController = new ReceiptController();

        do {         // Main Menu
            System.out.println("===== 서점 재고 관리 시스템 =====");
            System.out.println("1. 전체 재고 현황 조회");
            System.out.println("2. 입고하기");
            System.out.println("3. 출고하기");
            System.out.println("===============================");
            System.out.print("메뉴를 선택해주세요 : ");
            int no = sc.nextInt();

            switch (no) {
                case 1:
                    receiptController.selectAllBook();
                    break;
                case 2:
                    receiptSubMenu();
                    break;
//                case 2: receiptController.selectStockIn(inputBook()); break;
                case 3:
                    receiptController.selectOutOfStock();
                    break;
                default:
                    System.out.println("잘못된 메뉴를 선택하셨습니다.");
                    break;
            }

            // 추가입고 여부 확인
            System.out.print("추가 입고하시겠습니까? (Y/N) : ");
            String answer = sc.nextLine();
            if (!answer.equalsIgnoreCase("Y")) {
                break;
            }
        } while (true);
    }


    public static void receiptSubMenu() {

        Scanner sc = new Scanner(System.in);
        ReceiptController receiptController = new ReceiptController();

        do {         // Main Menu
            System.out.println("===== 입고 시스템 =====");
            System.out.println("1. 신규 도서등록");
            System.out.println("2. 기존 도서입고");
            System.out.println("===============================");
            System.out.print("메뉴를 선택해주세요 : ");
            int no = sc.nextInt();

            switch (no) {
                case 1:
                    receiptController.addNewBook(inputBook());
                    break;
                case 2:
                    receiptController.updateBook(inputModifyMenu());
                    break;

                default:
                    System.out.println("잘못된 메뉴를 선택하셨습니다.");
                    break;
            }
        } while (true);
    }

    private static BookDTO inputBook() {        // 신규 도서 입력. 수량 빼고 도서 정보만 입력.

        Scanner sc = new Scanner(System.in);
//        System.out.print("도서 코드를 입력하세요 : ");      // auto increment 처리하기
//        String bookID = sc.nextLine();
        System.out.print("도서 제목을 입력하세요 : ");
        String title = sc.nextLine();
        System.out.print("저자를 입력하세요 : ");
        String author = sc.nextLine();
        System.out.print("출판사를 입력하세요 : ");
        String publisher = sc.nextLine();


        BookDTO parameter = new BookDTO();
        parameter.setTitle(title);
        parameter.setAuthor(author);
        parameter.setPublisher(publisher);

        return parameter;

    }

    private static StockDTO inputModifyMenu() {

        Scanner sc = new Scanner(System.in);
        System.out.print("입고할 도서 코드를 입력하세요 : ");
        String bookID = sc.nextLine();
        System.out.print("입고량을 입력하세요 : ");
        int inAmount = sc.nextInt();
        sc.nextLine();

        StockDTO parameter = new StockDTO();
        parameter.setBookID(bookID);
        parameter.setInAmount(inAmount);

        return parameter;
    }
}


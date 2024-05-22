package com.infinityiterators.bookwms.receipt.view;

import com.infinityiterators.bookwms.receipt.model.dto.StockDTO;
import com.infinityiterators.bookwms.receipt.Controller.ReceiptController;
import com.infinityiterators.bookwms.receipt.model.dto.BookDTO;
import com.infinityiterators.bookwms.shipment.view.ShipmentView;

import java.util.Scanner;

public class ReceiptView {

    public static void receiptMain() {

        Scanner sc = new Scanner(System.in);
        ReceiptController receiptController = new ReceiptController();

        do {         // Main Menu
            System.out.println("===== 서점 재고 관리 시스템 =====");
            System.out.println("1. 전체 도서 정보 조회");
            System.out.println("2. 재고 조회");
            System.out.println("3. 입고 메뉴로 이동");
            System.out.println("4. 출고메뉴로 이동");
            System.out.println("5. 메인으로 돌아가기");
            System.out.println("=============================");
            System.out.print("메뉴를 선택해주세요 : ");
            int no = sc.nextInt();

            switch (no) {
                case 1:
                    receiptController.selectAllBook();
                    break;
                case 2:
                    receiptController.selectInStock();
                    break;
                case 3:
                    receiptSubMenu();
                    break;
//                case 2: receiptController.selectStockIn(inputBook()); break;
                case 4:
                    ShipmentView.main(null);
                    break;
                case 5:
                    return;
                default:
                    System.out.println("잘못된 메뉴를 선택하셨습니다.");
                    break;
            }

        } while (true);
    }

    public static void receiptSubMenu() {

        Scanner sc = new Scanner(System.in);
        ReceiptController receiptController = new ReceiptController();

        do {         // Sub Menu
            System.out.println("===== 입고 시스템 =====");
            System.out.println("1. 신규 도서등록");
            System.out.println("2. 기존 도서입고");
            System.out.println("3. 입고내역 조회");
            System.out.println("4. 뒤로 가기");
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
                case 3:
                    receiptController.selectInRecord();
                    break;
                case 4:
                    return;

                default:
                    System.out.println("잘못된 메뉴를 선택하셨습니다.");
                    break;
            }
        } while (true);
    }

    private static BookDTO inputBook() {        // 신규 도서 입력. 수량 빼고 도서 정보만 입력.

        Scanner sc = new Scanner(System.in);
//        System.out.print("도서 코드를 입력하세요 : ");      // auto-increment 처리
//        String bookID = sc.nextLine();
        System.out.print("도서 제목을 입력하세요 : ");
        String title = sc.nextLine();
        System.out.print("저자를 입력하세요 : ");
        String author = sc.nextLine();
        System.out.print("출판사를 입력하세요 : ");
        String publisher = sc.nextLine();
        System.out.print("국가 코드를 입력하세요 : ");
        String nationCode = sc.nextLine();
        System.out.print("장르 코드를 입력하세요 : ");
        String genreCode = sc.nextLine();


        BookDTO parameter = new BookDTO();
        parameter.setTitle(title);
        parameter.setAuthor(author);
        parameter.setPublisher(publisher);
        parameter.setNationCode(nationCode);
        parameter.setGenreCode(genreCode);

        return parameter;

    }

    private static StockDTO inputModifyMenu() {     // 기존 도서 수량 변경

        Scanner sc = new Scanner(System.in);
        System.out.print("입고할 도서 코드를 입력하세요 : ");
        String bookID = sc.nextLine();
        System.out.print("입고량을 입력하세요 : ");
        int bookAmount = sc.nextInt();
        sc.nextLine();

        StockDTO parameter = new StockDTO();
        parameter.setBookID(bookID);
        parameter.setBookAmount(bookAmount);

        return parameter;
    }
}


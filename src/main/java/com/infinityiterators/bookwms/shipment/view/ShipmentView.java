package com.infinityiterators.bookwms.shipment.view;

import com.infinityiterators.bookwms.shipment.controller.ShipmentController;
import com.infinityiterators.bookwms.shipment.model.OutRecordDTO;
import com.infinityiterators.bookwms.shipment.model.StockOutDTO;

import java.util.Date;
import java.util.Scanner;

public class ShipmentView {

    private static String shipmentId;
    private static int outAmount;
    private static Date shipmentDate;
    private static String bookId;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ShipmentController shipmentController = new ShipmentController();

        while (true) {
            System.out.println("=== 출고 관리 ===");
            System.out.println("1. 주문서 출력");        // 주문서 출력부분은 주문쪽에서 잘 받아오면 문제 없어보입니다
            System.out.println("2. 출고하기");      // 출고는 문제가 없어 보이지만 출고내역에 남는지 의문
            System.out.println("3. 품절처리하기");    // 품절할 도서코드입력,품절 메세지 출력까진 문제가 없어 보이지만 테이블에서 삭제가 되는지 의문
            System.out.println("4. 출고내역 조회하기");     // 주문서를 출력하면서 주문서에 있는 내용을 품절시켜야할지 아님 테이블을 삭제시킬지
            System.out.println("5. 뒤로 가기");
            System.out.print("동작할 번호를 입력하시오 : ");   // 출고시킨 출고내역을 조회하면 됩니다 하지만 출고내용이 테이블에 남을 수 있을지 의문이네요
                                                        // xml 에서 작업을 해야 할 듯 보입니다

            int no = sc.nextInt();
            sc.nextLine(); // 버퍼 비우기

            switch (no) {
                case 1: // 해결
                    shipmentController.selectAllShipmentDate();
                    break;
                case 2:
                    shipmentController.selectShipmentPlay(shipmentPlay());
                    break;
                case 3:
                    shipmentController.selectSoldOut(soldOut());
                    break;
                case 4:
                    shipmentController.selectShipmentDetails(details());
                    break;
                case 5:
                    return;
                default:
                    System.out.println("잘못된 메뉴 선택");
                    break;
            }
        }
    }

    private static OutRecordDTO details() {

        OutRecordDTO parameter = new OutRecordDTO();
        parameter.setShipmentID(shipmentId);
        parameter.setOutAmount(outAmount);
        parameter.setShipmentDate(shipmentDate);
        parameter.setBookID(bookId);

        return parameter;
    }

    private static StockOutDTO soldOut() {

        Scanner sc = new Scanner(System.in);
        System.out.println("품절처리할 도서 코드를 입력하시오 : ");
        String bookId = sc.nextLine();

        StockOutDTO parameter = new StockOutDTO();
        parameter.setBookID(bookId);

        return parameter;
    }


    private static StockOutDTO shipmentPlay() {

        Scanner sc = new Scanner(System.in);
        System.out.print("출고할 도서 코드를 입력하세요 : ");
        String bookId = sc.nextLine();
        System.out.print("출고할 도서 수량을 입력하세요 : ");
        int outAmount = sc.nextInt();
        sc.nextLine();


        StockOutDTO parameter = new StockOutDTO();
        parameter.setBookID(bookId);
        parameter.setBookAmount(outAmount);

        return parameter;
    }
}



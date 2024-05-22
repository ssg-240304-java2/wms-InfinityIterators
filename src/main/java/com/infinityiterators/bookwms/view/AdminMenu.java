package com.infinityiterators.bookwms.view;

import com.infinityiterators.bookwms.account.view.AdminAccountMainMenu;
import com.infinityiterators.bookwms.receipt.view.ReceiptView;
import com.infinityiterators.bookwms.utils.interaction.*;

public class AdminMenu {
    public void displayMenu() {
        while(true) {
            Console.clear();
            Menu.displayLogo();

            Menu.displayMenuHeader("관리자 메뉴");
            Menu.displaySelectionMenu("입출고 관리", "메인 메뉴");

            switch(Input.requestInt("메뉴를 선택하세요")) {
                case 1:
                    ReceiptView.receiptMain();
                    break;
                case 2:
                    return;
                default:
                    Console.printError("잘못된 입력입니다.");
                    break;
            }
        }
    }
}

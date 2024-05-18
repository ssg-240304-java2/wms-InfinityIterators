package com.infinityiterators.bookwms.view;

import com.infinityiterators.bookwms.utils.interaction.*;

public class MainMenu {
    public void displayMenu() {
        while(true) {
            Console.clear();
            Menu.displayLogo();

            Menu.displayMenuHeader("메인 메뉴");
            Menu.displaySelectionMenu("고객 메뉴", "관리자 메뉴", "종료");

            switch(Input.requestInt("메뉴를 선택하세요")) {
                case 1:
                    new CustomerLoginMenu().displayMenu();
                    break;
                case 2:
                    new AdminMenu().displayMenu();
                    break;
                case 3:
                    return;
                default:
                    Console.printError("잘못된 입력입니다.");
                    break;
            }
        }
    }
}

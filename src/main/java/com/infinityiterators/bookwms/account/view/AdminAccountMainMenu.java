package com.infinityiterators.bookwms.account.view;

import com.infinityiterators.bookwms.account.*;
import com.infinityiterators.bookwms.utils.interaction.*;

import java.util.List;

public class AdminAccountMainMenu {
    public void displayMenu() {
        while(true) {
            Console.clear();
            Menu.displayMenuHeader("관리자 계정 관리 메뉴");

            List<User> users = new AccountController().selectAllAccounts();
            for (User user : users) {
                Console.print(user.toString(), DisplayType.DESCRIPTION, true);
            }
        }
    }
}

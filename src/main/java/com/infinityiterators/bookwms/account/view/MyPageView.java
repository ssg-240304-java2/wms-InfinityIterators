package com.infinityiterators.bookwms.account.view;

import com.infinityiterators.bookwms.account.*;
import com.infinityiterators.bookwms.utils.interaction.*;

public class MyPageView {
    /**
     * target actor
     * : Customer(User)
     * @param user
     */
    public void displayMenu(User user) {
        while(true) {
            Console.clear();
            Menu.displayLogo();

            Menu.displayMenuHeader("마이페이지");

            Console.print(user.toString(), DisplayType.DESCRIPTION, true);

            Console.print("", DisplayType.DESCRIPTION, true);
            Menu.displaySelectionMenu("비밀번호 수정", "뒤로 가기");

            switch(Input.requestInt("메뉴를 선택하세요")) {
                case 1:
                    updatePassword(user);
                    break;
                case 3:
                    return;
                default:
                    Console.printError("잘못된 입력입니다.");
                    break;
            }

        }
    }

    private void updatePassword(User user) {
        Console.clear();
        Menu.displayMenuHeader("비밀번호 변경");

        String currentPassword = Input.requestString("현재 비밀번호를 입력하세요");
        String newPassword = Input.requestString("새로운 비밀번호를 입력하세요");
        String newPasswordConfirm = Input.requestString("새로운 비밀번호를 다시 입력하세요");

        if(!newPassword.equals(newPasswordConfirm)) {
            Console.printError("비밀번호가 일치하지 않습니다. 다시 시도해주세요.");
            return;
        }

        // todo. update user info
        new AccountController().changePassword(user, newPassword);
    }
}

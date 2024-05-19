package com.infinityiterators.bookwms.account.view;

import com.infinityiterators.bookwms.account.User;
import com.infinityiterators.bookwms.utils.interaction.*;

public class MyPageView {
    public void displayMenu(User user) {
        while(true) {
            Console.clear();
            Menu.displayLogo();

            Menu.displayMenuHeader("마이페이지");

            Console.print(user.toString(), DisplayType.DESCRIPTION, true);

            Console.print("", DisplayType.DESCRIPTION, true);
            Menu.displaySelectionMenu("내 정보 수정", "회원 탈퇴", "뒤로 가기");

            switch(Input.requestInt("메뉴를 선택하세요")) {
                case 1:
                    updateInfo(user);
                    break;
                case 2:
                    withdraw(user);
                    return;
                case 3:
                    return;
                default:
                    Console.printError("잘못된 입력입니다.");
                    break;
            }

        }
    }

    private void updateInfo(User user) {
        Console.clear();
        Menu.displayMenuHeader("내 정보 수정");

        String name = Input.requestString("이름을 입력하세요");
        String phone = Input.requestString("전화번호를 입력하세요");
        String address = Input.requestString("주소를 입력하세요");

        // todo. update user info
    }

    private void withdraw(User user) {
        Console.clear();
        Menu.displayMenuHeader("회원 탈퇴");

        if(Input.requestString("정말로 탈퇴하시겠습니까? (y/n)").equals("y")) {
            // todo. withdraw user
        }
    }
}

package com.infinityiterators.bookwms.view;

import com.infinityiterators.bookwms.account.*;
import com.infinityiterators.bookwms.utils.interaction.*;

import java.sql.Date;
import java.time.LocalDate;
import java.time.format.*;

public class CustomerLoginMenu {
    public void displayMenu() {

        while(true) {
            Console.clear();
            Menu.displayMenuHeader("로그인");
            Menu.displaySelectionMenu("로그인", "회원가입", "메인 메뉴");

            switch(Input.requestInt("메뉴를 선택하세요")) {
                case 1:
                    User login = login();
                    if(login == null) {
                        Console.printError("로그인에 실패했습니다.");
                        break;
                    }

//                    Console.print(login.getName() + "님 환영합니다.", DisplayType.SYSTEM, true);
                    new CustomerMenu().displayMenu(login);
                    break;
                case 2:
                    signUp();
                    break;
                case 3:
                    return;
                default:
                    Console.printError("잘못된 입력입니다.");
                    break;
            }
        }
    }

    private User login() {
        Console.clear();
        Menu.displayMenuHeader("로그인");

        String id = Input.requestString("아이디를 입력하세요");
        String password = Input.requestHiddenInput("비밀번호를 입력하세요");

        try {
            return new AccountController().login(id, password);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void signUp() {
        Console.clear();
        Menu.displayMenuHeader("회원가입");

        String id = "";
        boolean isIdDuplicated;
        do {
            id = Input.requestString("아이디를 입력하세요");
            isIdDuplicated = new AccountController().isDuplicatedId(id);

            if(isIdDuplicated) Console.printError("이미 사용중인 아이디입니다.");
        } while(isIdDuplicated);

        String password = Input.requestHiddenInput("비밀번호를 입력하세요");

        final int PASSWORD_CHECK_LIMIT = 5;
        int passwordCheckCount = 0;
        while(true) {
            String passwordCheck = Input.requestHiddenInput("비밀번호를 다시 입력하세요" + (passwordCheckCount > 0 ? " (" + passwordCheckCount + "/" + PASSWORD_CHECK_LIMIT + "회)" : ""));
            if(password.equals(passwordCheck)) break;
            else {
                Console.printError("비밀번호가 일치하지 않습니다.");
                passwordCheckCount++;
                if(passwordCheckCount >= PASSWORD_CHECK_LIMIT) {
                    Console.printError("비밀번호 확인 횟수 초과 : " + passwordCheckCount + "/" + PASSWORD_CHECK_LIMIT + "회");
                    Console.print("회원가입을 종료합니다.", DisplayType.SYSTEM, true);
                    return;
                }
            }
        }

        String name = Input.requestString("이름을 입력하세요");
        String phoneNumber = Input.requestString("전화번호를 입력하세요");
        String address = Input.requestString("주소를 입력하세요");
        String email = Input.requestString("이메일을 입력하세요");
        String dateOfBirth = Input.requestString("생년월일을 입력하세요 (yyyy-mm-dd)");
        // yyyy-mm-dd 서식에 맞게 입력되었는지 검사
        // Date.valueOf(Input.requestString("생년월일을 입력하세요 (yyyy-mm-dd)"));
        while(!isValidDate(dateOfBirth)) {
            Console.printError("날짜 형식이 올바르지 않습니다.");
            dateOfBirth = Input.requestString("생년월일을 입력하세요 (yyyy-mm-dd)");
        }

        User user = new User();
        user.setName(name);
        user.setPhone(phoneNumber);
        user.setAddress(address);
        user.setEmail(email);
        user.setDateOfBirth(Date.valueOf(LocalDate.parse(dateOfBirth, DateTimeFormatter.ofPattern("yyyy-MM-dd"))));

        Account account = new Account();
        account.setId(id);
        user.setAccount(account);

        new AccountController().registerAccount(user, password);
    }

    private boolean isValidDate(String date) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate.parse(date, formatter);
            return true;
        } catch(DateTimeParseException e) {
            return false;
        }
    }
}

package com.infinityiterators.bookwms.account;

import org.junit.jupiter.api.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.assertj.core.api.Assertions.assertThat;

class AccountControllerTest {
    /**
     * public void registerAccount(User user, String pw) {
     *         try {
     *             // todo. pw에 대한 해싱 및 솔트 처리
     *             String salt = EncryptionEngine.generateSalt();
     *             String pwHash = EncryptionEngine.hashPassword(pw, salt);
     *
     *             user.getAccount().setPwHash(pwHash);
     *             user.getAccount().setPwSalt(salt);
     *
     *             // todo. DB에 회원 정보 저장
     *             new AccountService().registerUser(user);
     *         } catch(NoSuchAlgorithmException e) {
     *             e.printStackTrace();
     *         }
     *     }
     */

    @Test
    @DisplayName("회원가입 테스트")
    void registerAccountTest() {
        // given
        User user = new User();
        user.setName("테스트 Name");
        user.setPhone("010-1234-5678");
        user.setEmail("abc@abc.com");
        user.setAddress("서울시 강남구");

        LocalDate dateOfBirth = LocalDate.parse("1990-01-01", DateTimeFormatter.ISO_DATE);
        user.setDateOfBirth(java.sql.Date.valueOf(dateOfBirth));

        Account account = new Account();
        account.setId("testId");

        user.setAccount(account);

        String pw = "1234";

        // when
        new AccountController().registerAccount(user, pw);

        // then
    }

    @Test
    @DisplayName("중복 아이디 체크 테스트")
    void isDuplicatedIdTest() {
        // given
        String id = "testId";

        // when
        boolean result = new AccountController().isDuplicatedId(id);

        // then
        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("login 테스트 - success")
    void loginTest1() {
        // given
        String id = "testId";
        String pw = "1234";

        // when
        User user = null;
        try {
            user = new AccountController().login(id, pw);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // then
        assertThat(user).isNotNull();
    }

    @Test
    @DisplayName("login 테스트 - fail")
    void loginTest2() {
        // given
        String id = "testId";
        String pw = "12345";

        // when
        User user = null;
        try {
            user = new AccountController().login(id, pw);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // then
        assertThat(user).isNull();
    }
}
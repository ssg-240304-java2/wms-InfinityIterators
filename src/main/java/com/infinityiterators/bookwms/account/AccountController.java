package com.infinityiterators.bookwms.account;

import java.security.NoSuchAlgorithmException;

public class AccountController {

    // 중복 아이디 체크
    public boolean isDuplicatedId(String id) {
        User usr = new AccountService().selectUserById(id);
        if(usr == null) return false;
        else return true;
    }

    /**
     * 회원가입
     * @param user 회원 정보
     */
    public void registerAccount(User user, String pw) {
        try {
            // todo. pw에 대한 해싱 및 솔트 처리
            String salt = EncryptionEngine.generateSalt();
            String pwHash = EncryptionEngine.hashPassword(pw, salt);

            user.getAccount().setPwHash(pwHash);
            user.getAccount().setPwSalt(salt);

            new AccountService().registerUser(user);
            new AccountTaskLoggerService().insertCreateAccountTaskLog(user);
        } catch(NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    public User login(String id, String pw) throws Exception {
        try {
            User user = new AccountService().selectUserById(id);
            if(user == null) throw new Exception("No such user");

            boolean b = EncryptionEngine.verifyPassword(pw, user.getAccount().getPwHash(), user.getAccount().getPwSalt());
            if(b) {
                new AccountTaskLoggerService().insertLoginTaskLog(user);
                return user;
            }
            else throw new Exception("Password is incorrect");
        } catch(NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }
}

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

            // todo. DB에 회원 정보 저장
            new AccountService().registerUser(user);
        } catch(NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    public User login(String id, String pw) throws Exception {
        try {
            User user = new User(); // todo. DB에서 id에 해당하는 회원 정보 조회
            if(user == null) throw new Exception("No such user");

            boolean b = EncryptionEngine.verifyPassword(pw, user.getAccount().getPwHash(), user.getAccount().getPwSalt());
            if(b) return user;
            else throw new Exception("Password is incorrect");
        } catch(NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }
}

package com.infinityiterators.bookwms.account;

import org.apache.ibatis.session.SqlSession;

import static com.infinityiterators.bookwms.utils.database.MyBatisTemplate.getSqlSession;

public class AccountService {
    public User selectUserById(String id) {
        SqlSession sqlSession = getSqlSession();
        AccountMapper accountMapper = sqlSession.getMapper(AccountMapper.class);
        User user = accountMapper.selectUserById(id);
        sqlSession.close();
        return user;
    }

    public void registerUser(User user) {
        Account account = user.getAccount();
        SqlSession sqlSession = getSqlSession();
        AccountMapper accountMapper = sqlSession.getMapper(AccountMapper.class);

        try {

            int acResult = accountMapper.insertAccount(account);
            int usResult = accountMapper.insertUser(user);

            sqlSession.commit();

            if(acResult != usResult)
                throw new RuntimeException("회원 가입 실패");
        } catch(Exception e) {
            sqlSession.rollback();
            throw new RuntimeException(e);
        } finally {
            sqlSession.close();
        }
    }
}

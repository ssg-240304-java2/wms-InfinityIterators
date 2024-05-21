package com.infinityiterators.bookwms.account;

import org.apache.ibatis.session.SqlSession;

import java.util.List;

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

            if(acResult != usResult)
                throw new RuntimeException("회원 가입 실패");

            sqlSession.commit();
        } catch(Exception e) {
            sqlSession.rollback();
            throw new RuntimeException(e);
        } finally {
            sqlSession.close();
        }
    }

    public int updateUser(User usr) {
        SqlSession sqlSession = getSqlSession();
        AccountMapper accountMapper = sqlSession.getMapper(AccountMapper.class);

        int result = 0;
        try {
            result = accountMapper.updatePassword(usr);
            sqlSession.commit();
        } catch(Exception e) {
            sqlSession.rollback();
            throw new RuntimeException(e);
        } finally {
            sqlSession.close();
        }
        return result;
    }

    public List<User> selectAllUsers() {
        SqlSession sqlSession = getSqlSession();
        AccountMapper accountMapper = sqlSession.getMapper(AccountMapper.class);
        List<User> users = accountMapper.selectAllUsers();
        sqlSession.close();
        return users;
    }
}

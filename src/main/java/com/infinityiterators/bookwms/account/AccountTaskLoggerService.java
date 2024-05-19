package com.infinityiterators.bookwms.account;

import org.apache.ibatis.session.SqlSession;

import static com.infinityiterators.bookwms.utils.database.MyBatisTemplate.getSqlSession;

public class AccountTaskLoggerService {
    /**
     * insert into account_task_type (desc) values ('계정 생성');
     * insert into account_task_type (desc) values ('계정 삭제(탈퇴)');
     * insert into account_task_type (desc) values ('계정 비밀번호 변경');
     * insert into account_task_type (desc) values ('계정 정보 변경');
     * insert into account_task_type (desc) values ('계정 로그인');
     */

    /**
     * 계정 생성 로그를 남긴다.
     * @param user 계정 생성을 요청한 사용자
     * @return 생성된 로그의 id
     */
    public int insertCreateAccountTaskLog(User user) {
        SqlSession sqlSession = getSqlSession();
        AccountLogMapper accountLogMapper = sqlSession.getMapper(AccountLogMapper.class);

        int result = 0;
        try {
            result = accountLogMapper.insertCreateAccountTaskLog(user);

            sqlSession.commit();
            return result;
        } catch(Exception e) {
            sqlSession.rollback();
            throw new RuntimeException(e);
        } finally {
            sqlSession.close();
        }
    }

    public void insertLoginTaskLog(User user) {
        SqlSession sqlSession = getSqlSession();
        AccountLogMapper accountLogMapper = sqlSession.getMapper(AccountLogMapper.class);

        try {
            accountLogMapper.insertLoginTaskLog(user);

            sqlSession.commit();
        } catch(Exception e) {
            sqlSession.rollback();
            throw new RuntimeException(e);
        } finally {
            sqlSession.close();
        }
    }
}
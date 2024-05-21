package com.infinityiterators.bookwms.utils.database;

import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;

import static com.infinityiterators.bookwms.utils.database.MyBatisTemplate.getSqlSession;
import static org.assertj.core.api.Assertions.assertThat;

class MyBatisTemplateTest {
    @Test
    void getSqlSessionTest() {
        SqlSession sqlSession = getSqlSession();
        assertThat(sqlSession).isNotNull();
    }
}
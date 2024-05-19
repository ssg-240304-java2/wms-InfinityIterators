package com.infinityiterators.bookwms.utils.database;

import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.assertThat;

public class TemplateTest {

    @DisplayName("sqlSession 객체가 정상적으로 생성되는지 테스트")
    @Test
    void test() {
        SqlSession sqlSession = MyBatisTemplate.getSqlSession();
        assertThat(sqlSession).isNotNull();
    }
}

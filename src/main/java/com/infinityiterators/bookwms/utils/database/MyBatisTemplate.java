package com.infinityiterators.bookwms.utils.database;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.*;

import java.io.InputStream;

public class MyBatisTemplate {
    private static class SqlSessionFactoryHolder {
        private static final SqlSessionFactory INSTANCE;

        static {
            String resource = "config/mybatis-config.xml";
            try {
                InputStream inputStream = Resources.getResourceAsStream(resource);
                INSTANCE = new SqlSessionFactoryBuilder().build(inputStream);
            } catch (Exception e) {
                throw new RuntimeException("Error initializing SqlSessionFactory", e);
            }
        }
    }

    public static SqlSession getSqlSession() {
        return SqlSessionFactoryHolder.INSTANCE.openSession(false);
    }
}

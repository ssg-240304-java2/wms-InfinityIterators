package com.infinityiterators.shipment.template;

import com.infinityiterators.shipment.mapper.ShipmentMapper;
import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

public class ShipmentTemplate {

    private static final String DRIVER = "com.myslq.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost/infinitydb";
    private static String USER = "infinity";
    private static String PASSWORD = "iterators";
    private static SqlSessionFactory sqlSessionFactory;

    public static SqlSession getSqlSession() {

        if (sqlSessionFactory == null) {
            Environment environment =
                    new Environment("dev",
                            new JdbcTransactionFactory(),
                            new PooledDataSource(DRIVER, URL, USER, PASSWORD));
            Configuration configuration = new Configuration(environment);

            configuration.addMapper(ShipmentMapper.class);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);
        }

        return sqlSessionFactory.openSession(false);
    }


}

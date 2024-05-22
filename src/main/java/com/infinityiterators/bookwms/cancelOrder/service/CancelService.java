package com.infinityiterators.bookwms.cancelOrder.service;

import com.infinityiterators.bookwms.cancelOrder.mapper.CancelMapper;
import com.infinityiterators.bookwms.cancelOrder.model.dto.OrderDTO;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

import static com.infinityiterators.bookwms.utils.database.MyBatisTemplate.getSqlSession;

public class CancelService {

    private CancelMapper cancelMapper;

    public List<OrderDTO> selectAllOrder() {
        SqlSession sqlSession = getSqlSession();
        cancelMapper = sqlSession.getMapper(CancelMapper.class);
        List<OrderDTO> orderList = cancelMapper.selectAllOrder();
        // System.out.println("CancelService - selectAllOrder 결과: " + orderList); // 디버깅
        // 메시지 추가
        sqlSession.close();
        return orderList;
    }

    public boolean updateCancelOrder(OrderDTO order) {

        boolean sqlStatus = true;

        SqlSession sqlSession = getSqlSession();

        cancelMapper = (sqlSession).getMapper(CancelMapper.class);
        int result = cancelMapper.updateOrderStatusToCancelled(order);

        if (result > 0) {
            // sqlSession.commit();
            result = cancelMapper.cancelledOrder(order);

            if (result > 0) {

            } else {
                sqlStatus = false;
            }
        } else {
            // sqlSession.rollback();
            sqlStatus = false;
        }

        if (sqlStatus) {
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }

        sqlSession.close();
        return sqlStatus;
        // return result;
    }
}

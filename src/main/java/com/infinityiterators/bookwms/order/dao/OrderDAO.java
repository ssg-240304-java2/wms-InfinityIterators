package com.infinityiterators.bookwms.order.dao;

import com.infinityiterators.bookwms.order.dto.OrderDTO;
import com.infinityiterators.bookwms.order.dto.OrderItemDTO;
import com.infinityiterators.bookwms.order.mapper.OrderMapper;

import org.apache.ibatis.session.SqlSession;

import java.util.List;

import static com.infinityiterators.bookwms.utils.database.MyBatisTemplate.getSqlSession;

public class OrderDAO {

    public int insertOrder(OrderDTO order) { // 주문 생성
        try (SqlSession sqlSession = getSqlSession()) {
            OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);
            int result = orderMapper.insertOrder(order);
            sqlSession.commit();
            return result;
        }
    }

    public OrderDTO selectOrderById(int orderId) { // 주문 조회
        try (SqlSession sqlSession = getSqlSession()) {
            OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);
            return orderMapper.selectOrderById(orderId);
        }
    }

    public List<OrderDTO> selectAllOrders() { // 전체 주문 조회
        try (SqlSession sqlSession = getSqlSession()) {
            OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);
            return orderMapper.selectAllOrders();
        }
    }

    public List<OrderDTO> selectAllOrder() { // 취소용 조회
        try (SqlSession sqlSession = getSqlSession()) {
            OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);
            return orderMapper.selectAllOrder();
        }
    }

    public int updateOrder(OrderDTO order) { // 주문 수정
        try (SqlSession sqlSession = getSqlSession()) {
            OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);
            int result = orderMapper.updateOrder(order);
            sqlSession.commit();
            return result;
        }
    }

    public int deleteOrder(int orderId) { // 주문 삭제
        try (SqlSession sqlSession = getSqlSession()) {
            OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);
            int result = orderMapper.deleteOrder(orderId);
            sqlSession.commit();
            return result;
        }
    }

    public int insertOrderItem(OrderItemDTO orderItem) { // 주문 항목 생성
        try (SqlSession sqlSession = getSqlSession()) {
            OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);
            int result = orderMapper.insertOrderItem(orderItem);
            sqlSession.commit();
            return result;
        }
    }

    public List<OrderItemDTO> getOrderItemsByOrderId(int orderId) { // 주문 항목 조회
        try (SqlSession sqlSession = getSqlSession()) {
            OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);
            return orderMapper.selectOrderItemsByOrderId(orderId);
        }
    }
}

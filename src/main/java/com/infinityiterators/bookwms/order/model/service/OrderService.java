package com.infinityiterators.bookwms.order.model.service;

import com.infinityiterators.bookwms.order.mapper.OrderMapper;
import com.infinityiterators.bookwms.order.model.dto.OrderDTO;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

import static com.infinityiterators.bookwms.utils.database.MyBatisTemplate.getSqlSession;

public class OrderService {

    private OrderMapper orderMapper;

    public boolean createOrder(OrderDTO order) {
        SqlSession sqlSession = getSqlSession();
        orderMapper = sqlSession.getMapper(OrderMapper.class);
        int result = orderMapper.insertOrder(order);
        sqlSession.close();
        return result > 0;
    }

    public OrderDTO getOrderById(int orderId) {
        SqlSession sqlSession = getSqlSession();
        orderMapper = sqlSession.getMapper(OrderMapper.class);
        OrderDTO order = orderMapper.selectOrderById(orderId);
        sqlSession.close();
        return order;
    }

    public List<OrderDTO> getAllOrders() {
        SqlSession sqlSession = getSqlSession();
        orderMapper = sqlSession.getMapper(OrderMapper.class);
        List<OrderDTO> orderList = orderMapper.selectAllOrders();
        sqlSession.close();
        return orderList;
    }

    public boolean updateOrder(OrderDTO order) {
        SqlSession sqlSession = getSqlSession();
        orderMapper = sqlSession.getMapper(OrderMapper.class);
        int result = orderMapper.updateOrder(order);
        sqlSession.close();
        return result > 0;
    }

    public boolean deleteOrder(int orderId) {
        SqlSession sqlSession = getSqlSession();
        orderMapper = sqlSession.getMapper(OrderMapper.class);
        int result = orderMapper.deleteOrder(orderId);
        sqlSession.close();
        return result > 0;
    }
}

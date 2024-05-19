package com.infinityiterators.bookwms.order.model.service;

import com.infinityiterators.bookwms.order.dao.OrderDAO;
import com.infinityiterators.bookwms.order.dto.OrderDTO;
import com.infinityiterators.bookwms.order.mapper.OrderMapper;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

import static com.infinityiterators.bookwms.utils.database.MyBatisTemplate.getSqlSession;

public class OrderService {

    private OrderMapper orderMapper;
    private final OrderDAO orderDAO = new OrderDAO();

    public OrderDTO getOrderById(int orderId) {
        return orderDAO.selectOrderById(orderId);
    }

    public List<OrderDTO> getAllOrders() {
        return orderDAO.selectAllOrders();
    }

    public boolean updateOrder(OrderDTO order) {
        return orderDAO.updateOrder(order) > 0;
    }

    public boolean deleteOrder(int orderId) {
        return orderDAO.deleteOrder(orderId) > 0;
    }

    public List<OrderDTO> selectAllOrder() {
        SqlSession sqlSession = getSqlSession();
        orderMapper = sqlSession.getMapper(OrderMapper.class);
        List<OrderDTO> orderList = orderMapper.selectAllOrder();
        sqlSession.close();
        return orderList;
    }
}

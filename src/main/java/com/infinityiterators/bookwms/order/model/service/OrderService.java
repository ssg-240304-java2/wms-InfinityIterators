package com.infinityiterators.bookwms.order.model.service;

import com.infinityiterators.bookwms.order.dao.OrderDAO;
import com.infinityiterators.bookwms.order.dto.OrderDTO;
import com.infinityiterators.bookwms.order.dto.OrderItemDTO;
import com.infinityiterators.bookwms.order.mapper.OrderMapper;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

import static com.infinityiterators.bookwms.utils.database.MyBatisTemplate.getSqlSession;

public class OrderService {

    private OrderMapper orderMapper;
    private final OrderDAO orderDAO = new OrderDAO();

    public boolean createOrder(OrderDTO order, List<OrderItemDTO> orderItems) {
        int result = orderDAO.insertOrder(order);
        if (result > 0) {
            int orderId = order.getOrderId();
            for (OrderItemDTO item : orderItems) {
                item.setOrderId(orderId);
                orderDAO.insertOrderItem(item);
            }
            return true;
        }
        return false;
    }

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

    public List<OrderDTO> selectAllOrder() { // 채웅님 주문 전체 조회 메서드
        SqlSession sqlSession = getSqlSession();

        orderMapper = sqlSession.getMapper(OrderMapper.class);
        List<OrderDTO> orderList = orderMapper.selectAllOrder();

        sqlSession.close();
        return orderList;
    }

    public boolean completeOrder(int orderId) {
        SqlSession sqlSession = getSqlSession();
        orderMapper = sqlSession.getMapper(OrderMapper.class);
        OrderDTO order = orderMapper.selectOrderById(orderId);
        if (order != null) {
            order.setStatus("완료");
            int result = orderMapper.updateOrder(order);
            sqlSession.close();
            return result > 0;
        }
        sqlSession.close();
        return false;
    }

}

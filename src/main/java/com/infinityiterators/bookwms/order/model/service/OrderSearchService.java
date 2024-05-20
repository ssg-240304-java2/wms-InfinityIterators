package com.infinityiterators.bookwms.order.model.service;

import com.infinityiterators.bookwms.order.dao.OrderDAO;
import com.infinityiterators.bookwms.order.dto.OrderDTO;
import com.infinityiterators.bookwms.order.dto.OrderItemDTO;
import com.infinityiterators.bookwms.order.mapper.OrderMapper;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

import static com.infinityiterators.bookwms.utils.database.MyBatisTemplate.getSqlSession;

public class OrderSearchService {

    private OrderMapper orderMapper;
    private final OrderSearchService orderSearchService = new OrderSearchService();

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


    private final OrderDAO orderDAO = new OrderDAO();
/* 시작 추가 라인*/
    public List<OrderDTO> selectAllOrder() {
        SqlSession sqlSession = getSqlSession();

        orderMapper = ((SqlSession) sqlSession).getMapper(OrderMapper.class);
        List<OrderDTO> orderList = orderMapper.selectAllOrder();

        sqlSession.close();
        return orderList;
    }
/* 끝 추가 라인*/


}

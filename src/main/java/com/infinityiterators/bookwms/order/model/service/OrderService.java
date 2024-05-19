package com.infinityiterators.bookwms.order.model.service;

import com.infinityiterators.bookwms.order.dao.OrderDAO;
import com.infinityiterators.bookwms.order.dto.OrderDTO;

import java.util.List;

public class OrderService {

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
}

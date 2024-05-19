package com.infinityiterators.bookwms.order.model.service;

import com.infinityiterators.bookwms.order.dao.OrderDAO;
import com.infinityiterators.bookwms.order.dto.OrderDTO;
import com.infinityiterators.bookwms.order.dto.OrderItemDTO;

import java.util.List;

public class OrderService {

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
}

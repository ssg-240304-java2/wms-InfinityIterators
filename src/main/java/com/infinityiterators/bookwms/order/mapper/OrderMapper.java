package com.infinityiterators.bookwms.order.mapper;

import com.infinityiterators.bookwms.order.model.dto.OrderDTO;

import java.util.List;

public interface OrderMapper {
    int insertOrder(OrderDTO order);
    OrderDTO selectOrderById(int orderId);
    List<OrderDTO> selectAllOrders();
    int updateOrder(OrderDTO order);
    int deleteOrder(int orderId);
}

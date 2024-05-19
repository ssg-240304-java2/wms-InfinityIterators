package com.infinityiterators.bookwms.order.mapper;

import java.util.List;

import com.infinityiterators.bookwms.order.dto.OrderDTO;
import com.infinityiterators.bookwms.order.dto.OrderItemDTO;

public interface OrderMapper {
    int insertOrder(OrderDTO order);

    int insertOrderItem(OrderItemDTO orderItem);

    int updateOrder(OrderDTO order);

    int deleteOrder(int orderId);

    OrderDTO selectOrderById(int orderId);

    List<OrderDTO> selectAllOrders();

    List<OrderItemDTO> selectOrderItemsByOrderId(int orderId);
}

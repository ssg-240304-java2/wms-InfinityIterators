package com.infinityiterators.bookwms.order.mapper;

import java.util.List;

import com.infinityiterators.bookwms.order.dto.OrderDTO;
import com.infinityiterators.bookwms.order.dto.OrderItemDTO;

public interface OrderMapper {
    int insertOrder(OrderDTO order);

    OrderDTO selectOrderById(int orderId);

    List<OrderDTO> selectAllOrders();

    int updateOrder(OrderDTO order);

    int deleteOrder(int orderId);

    int insertOrderItem(OrderItemDTO orderItem);

    /*시작 라인 (취소용 조회)*/
    List<OrderDTO> selectAllOrder();
    /*끝 라인 */

    List<OrderItemDTO> selectOrderItemsByOrderId(int orderId);

}

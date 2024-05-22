package com.infinityiterators.bookwms.cancelOrder.mapper;
import com.infinityiterators.bookwms.cancelOrder.model.dto.OrderDTO;

import java.util.List;

public interface CancelMapper {
    List<OrderDTO> selectAllOrder();

    int updateOrderStatusToCancelled(OrderDTO order);


    int cancelledOrder(OrderDTO order);
}

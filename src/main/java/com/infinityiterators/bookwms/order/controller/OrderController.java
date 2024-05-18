package com.infinityiterators.bookwms.order.controller;

import com.infinityiterators.bookwms.order.model.dto.OrderDTO;
import com.infinityiterators.bookwms.order.model.service.OrderService;

import java.util.List;

public class OrderController {

    private final OrderService orderService;

    public OrderController() {
        orderService = new OrderService();
    }

    public void createOrder(OrderDTO order) {
        boolean isCreated = orderService.createOrder(order);
        if (isCreated) {
            System.out.println("주문이 성공적으로 생성되었습니다.");
        } else {
            System.out.println("주문 생성에 실패하였습니다.");
        }
    }

    public void getOrderById(int orderId) {
        OrderDTO order = orderService.getOrderById(orderId);
        if (order != null) {
            System.out.println(order);
        } else {
            System.out.println("주문을 찾을 수 없습니다.");
        }
    }

    public void getAllOrders() {
        List<OrderDTO> orderList = orderService.getAllOrders();
        if (orderList != null && !orderList.isEmpty()) {
            for (OrderDTO order : orderList) {
                System.out.println(order);
            }
        } else {
            System.out.println("주문 목록이 비어 있습니다.");
        }
    }

    public void updateOrder(OrderDTO order) {
        boolean isUpdated = orderService.updateOrder(order);
        if (isUpdated) {
            System.out.println("주문이 성공적으로 업데이트되었습니다.");
        } else {
            System.out.println("주문 업데이트에 실패하였습니다.");
        }
    }

    public void deleteOrder(int orderId) {
        boolean isDeleted = orderService.deleteOrder(orderId);
        if (isDeleted) {
            System.out.println("주문이 성공적으로 삭제되었습니다.");
        } else {
            System.out.println("주문 삭제에 실패하였습니다.");
        }
    }
}

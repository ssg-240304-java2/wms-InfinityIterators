package com.infinityiterators.bookwms.order.controller;

import com.infinityiterators.bookwms.order.dto.OrderDTO;
import com.infinityiterators.bookwms.order.dto.OrderItemDTO;
import com.infinityiterators.bookwms.order.mapper.OrderMapper;
import com.infinityiterators.bookwms.order.model.service.OrderService;
import com.infinityiterators.bookwms.order.view.PrintResult;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

import static com.infinityiterators.bookwms.utils.database.MyBatisTemplate.getSqlSession;

public class OrderController {
    private final PrintResult printResult;
    private final OrderService orderService;

    public OrderController() {
        orderService = new OrderService();
        /* 추가 시작 라인 */
        printResult = new PrintResult();
        /* 추가 끝 라인 */
    }

    public boolean createOrder(OrderDTO order, List<OrderItemDTO> orderItems) {
        SqlSession sqlSession = getSqlSession();
        OrderMapper orderMapper = null;
        try {
            orderMapper = sqlSession.getMapper(OrderMapper.class);
            int result = orderMapper.insertOrder(order);
            if (result > 0) {
                int orderId = order.getOrderId(); // 데이터베이스에서 생성된 orderId 가져오기
//                System.out.println("생성된 주문 ID: " + orderId); // 디버깅 로그 추가
//                System.out.println("OrderDTO 상태: " + order); // 디버깅 로그 추가

                // 주문 항목 생성
                for (OrderItemDTO item : orderItems) {
                    item.setOrderId(orderId); // 각 주문 항목에 orderId 설정
                    orderMapper.insertOrderItem(item);
                }
                sqlSession.commit();
                return true;
            } else {
                sqlSession.rollback();
                return false;
            }
        } catch (Exception e) {
            sqlSession.rollback();
            e.printStackTrace();
            return false;
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
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

    public void selectAllOrder() {

        List<OrderDTO> orderList = orderService.selectAllOrder();

        if (orderList != null && !orderList.isEmpty()) {
            printResult.printOrderList(orderList);
        } else {
            printResult.printErrorMessage("selectListError");
        }

    }

    public boolean completeOrder(OrderDTO order) {
        return orderService.completeOrder(order);
    }

}

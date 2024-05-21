package com.infinityiterators.bookwms.order.model.service;

import com.infinityiterators.bookwms.order.dao.OrderDAO;
import com.infinityiterators.bookwms.order.dto.OrderDTO;
import com.infinityiterators.bookwms.order.dto.OrderItemDTO;
import com.infinityiterators.bookwms.order.mapper.OrderMapper;
import com.infinityiterators.bookwms.utils.interaction.Console;
import com.infinityiterators.bookwms.utils.interaction.DisplayType;
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

    // public boolean completeOrder(int orderId) {
    // SqlSession sqlSession = getSqlSession();
    // OrderMapper orderMapper = null;
    // try {
    // orderMapper = sqlSession.getMapper(OrderMapper.class);
    // OrderDTO order = orderMapper.selectOrderById(orderId);
    // if (order != null) {
    // order.setStatus("완료");
    // System.out.println("Updating order: " + order); // 디버깅 로그
    // int result = orderMapper.updateOrder(order);
    // if (result > 0) {
    // sqlSession.commit();
    // System.out.println("구매가 성공적으로 완료되었습니다."); // 디버깅 로그
    // return true;
    // } else {
    // sqlSession.rollback();
    // System.out.println("구매 완료에 실패하였습니다. (updateOrder 실패)"); // 디버깅 로그
    // return false;
    // }
    // } else {
    // System.out.println("구매 완료에 실패하였습니다. (주문을 찾을 수 없음)"); // 디버깅 로그
    // return false;
    // }
    // } catch (Exception e) {
    // sqlSession.rollback();
    // e.printStackTrace();
    // System.out.println("구매 완료에 실패하였습니다. (예외 발생)"); // 디버깅 로그
    // return false;
    // } finally {
    // if (sqlSession != null) {
    // sqlSession.close();
    // }
    // }
    // }

    public boolean completeOrder(OrderDTO order) {
        SqlSession sqlSession = getSqlSession();
        OrderMapper orderMapper = null;
        try {
            orderMapper = sqlSession.getMapper(OrderMapper.class);
            if (order != null) {
                order.setStatus("완료");
                System.out.println("Updating order: " + order); // 디버깅 로그
                int result = orderMapper.updateOrder(order);
                if (result > 0) {
                    sqlSession.commit();
                    System.out.println("구매가 성공적으로 완료되었습니다."); // 디버깅 로그
                    return true;
                } else {
                    sqlSession.rollback();
                    System.out.println("구매 완료에 실패하였습니다. (updateOrder 실패)"); // 디버깅 로그
                    return false;
                }
            } else {
                System.out.println("구매 완료에 실패하였습니다. (주문을 찾을 수 없음)"); // 디버깅 로그
                return false;
            }
        } catch (Exception e) {
            sqlSession.rollback();
            e.printStackTrace();
            System.out.println("구매 완료에 실패하였습니다. (예외 발생)"); // 디버깅 로그
            return false;
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }

}

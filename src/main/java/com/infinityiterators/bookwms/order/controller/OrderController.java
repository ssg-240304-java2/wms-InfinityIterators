package com.infinityiterators.bookwms.order.controller;

import com.infinityiterators.bookwms.order.dto.OrderDTO;
import com.infinityiterators.bookwms.order.dto.OrderItemDTO;
import com.infinityiterators.bookwms.order.mapper.OrderMapper;
import com.infinityiterators.bookwms.order.model.service.OrderService;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

import static com.infinityiterators.bookwms.utils.database.MyBatisTemplate.getSqlSession;

public class OrderController {

    public boolean createOrder(OrderDTO order, List<OrderItemDTO> orderItems) {
        SqlSession sqlSession = getSqlSession();
        OrderMapper orderMapper = null;
        try {
            orderMapper = sqlSession.getMapper(OrderMapper.class);

            // 주문 생성
            int result = orderMapper.insertOrder(order);
            if (result > 0) {
                int orderId = order.getOrderId();

                // 주문 항목 생성
                for (OrderItemDTO item : orderItems) {
                    item.setOrderId(orderId);
                    orderMapper.insertOrderItem(item);
                }
                sqlSession.commit();
                System.out.println("주문이 성공적으로 생성되었습니다.");
            } else {
                sqlSession.rollback();
                System.out.println("주문 생성에 실패하였습니다.");
            }
        } catch (Exception e) {
            sqlSession.rollback();
            e.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
        return false;
    }

    public boolean completeOrder(int orderId) {
        SqlSession sqlSession = getSqlSession();
        OrderMapper orderMapper = null;
        try {
            orderMapper = sqlSession.getMapper(OrderMapper.class);
            OrderDTO order = orderMapper.selectOrderById(orderId);
            if (order != null) {
                order.setStatus("완료");
                int result = orderMapper.updateOrder(order);
                if (result > 0) {
                    sqlSession.commit();
                    return true;
                } else {
                    sqlSession.rollback();
                    return false;
                }
            } else {
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

    public void searchBookByCode(String bookCode) {
        // todo: 도서 코드로 도서 정보 조회하는 기능 구현
    }

}

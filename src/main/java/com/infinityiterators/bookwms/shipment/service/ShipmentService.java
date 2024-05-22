package com.infinityiterators.bookwms.shipment.service;

import com.infinityiterators.bookwms.order.dto.OrderItemDTO;
import com.infinityiterators.bookwms.shipment.mapper.ShipmentMapper;
import com.infinityiterators.bookwms.shipment.model.OrderDTO;
import com.infinityiterators.bookwms.shipment.model.OutRecordDTO;
import com.infinityiterators.bookwms.shipment.model.StockOutDTO;
import org.apache.ibatis.session.SqlSession;

import static com.infinityiterators.bookwms.utils.database.MyBatisTemplate.getSqlSession;


import java.util.List;

public class ShipmentService {

    private ShipmentMapper ShipmentMapper;


    // 주문서 출력
    public List<OrderDTO> selectAllShipmentDate() {

        SqlSession sqlSession = getSqlSession();
        ShipmentMapper = sqlSession.getMapper(ShipmentMapper.class);
        List<OrderDTO> orders = ShipmentMapper.selectAllShipmentDate();
        sqlSession.close();
        return orders;
        // 주문서를 받아로는 로직입니다
    }


    // 출고하기
    public boolean selectShipmentPlay(int orderId) {

        boolean sqlStatus = true;

        // sql세션 설정 (+)
        SqlSession sqlSession = getSqlSession();
        ShipmentMapper = sqlSession.getMapper(ShipmentMapper.class);
        // sql세션 설정 (-)

        List<OrderItemDTO> orderItemList = ShipmentMapper.selectOrderItem(orderId);

        if (orderItemList == null) {
            sqlStatus = false;
        }
        int result = 0;

        result = ShipmentMapper.selectShipmentPlay(orderId);

        if (result <= 0) {
            sqlStatus = false;
        }

        if(sqlStatus) {
            result = ShipmentMapper.insertOutRecord(orderId);

            if (result <= 0) {
                sqlStatus = false;
            }
        }

        if(sqlStatus){
            result = ShipmentMapper.updateStatus(orderId);

            if (result <= 0) {
                sqlStatus = false;
            }
        }

        if (sqlStatus) {
            result = ShipmentMapper.verifAmount();

            if (result != 0) {
                System.out.println("재고가 충분하지 않습니다 !!");
                sqlStatus = false;
            }
        }

        if (sqlStatus) {
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }

        sqlSession.close();
        return sqlStatus;
    }


    // 품절처리
    public boolean soldOut(StockOutDTO book) {

        SqlSession sqlSession = getSqlSession();

        ShipmentMapper = sqlSession.getMapper(ShipmentMapper.class);
        int result = ShipmentMapper.soldOut(book);

        if (result > 0) {
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }

        sqlSession.close();
        return result > 0 ? true : false;
    }


    // 출고내역 출력
    public List<OutRecordDTO> selectShipmentDetails(OutRecordDTO details) {

        SqlSession sqlSession = getSqlSession();

        ShipmentMapper = sqlSession.getMapper(ShipmentMapper.class);
        List<OutRecordDTO> result = ShipmentMapper.selectShipmentDetails(details);


        return result;
    }

}


package com.infinityiterators.bookwms.shipment.service;

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
    public boolean selectShipmentPlay(StockOutDTO out) {

        SqlSession sqlSession = getSqlSession();

        ShipmentMapper = sqlSession.getMapper(ShipmentMapper.class);
        int result = ShipmentMapper.selectShipmentPlay(out);

        if (result > 0) {
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }

        sqlSession.close();
        return result > 0 ? true : false;
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


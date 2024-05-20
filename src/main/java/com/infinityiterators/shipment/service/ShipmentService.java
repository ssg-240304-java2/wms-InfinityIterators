package com.infinityiterators.shipment.service;

import com.infinityiterators.shipment.mapper.ShipmentMapper;
import com.infinityiterators.shipment.model.OutRecordDTO;
import org.apache.ibatis.session.SqlSession;

import static com.infinityiterators.bookwms.utils.database.MyBatisTemplate.getSqlSession;


import java.util.List;
import java.util.Map;

public class ShipmentService {

    private ShipmentMapper shipmentMapper;


    public List<OutRecordDTO> selectAllShipmentDate() {
        System.out.println("주문서 출력");
        // 주문서 출력 로직 구현
        return null;
    }

    public Map<Integer, OutRecordDTO> getShipmentHistory() {
        System.out.println("출고내역 조회하기");
        // 출구내역조회 출력 로직 구현
        return null;
    }

   // public String processOutOfStock(int i) {
//        Book book = bookRepository.findBookById(bookID);
//        if (book != null) {
//            book.setStock(0); // 품절 처리
//            bookRepository.updateBook(book);
//            return "도서 코드 " + bookID + " (" + book.getTitle() + ")가 품절 처리되었습니다.";
//        } else {
//            return "도서 코드 " + bookID + "를 찾을 수 없습니다.";
//        }

 //   }



    public boolean selectShipmentPlay(OutRecordDTO out) {

        SqlSession sqlSession = getSqlSession();

        shipmentMapper = sqlSession.getMapper(ShipmentMapper.class);
        int result = shipmentMapper.modifyMenu(out);

        if(result > 0) {
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }

        sqlSession.close();
        return result > 0 ? true: false ;
    }

    public boolean selectShipmentSoldOut(OutRecordDTO out) {

        SqlSession sqlSession = getSqlSession();

        shipmentMapper = sqlSession.getMapper(ShipmentMapper.class);
        int result = shipmentMapper.soldOutMenu(out);

        if (result > 0 ) {
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }

        sqlSession.close();
        return result > 0 ? true: false ;
    }
}


package com.infinityiterators.receipt.model.service;

import com.infinityiterators.receipt.mapper.ReceiptMapper;
import com.infinityiterators.receipt.model.dto.BookDTO;
import com.infinityiterators.receipt.model.dto.InRecordDTO;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

import static com.infinityiterators.bookwms.utils.database.MyBatisTemplate.getSqlSession;

public class ReceiptService {

    private ReceiptMapper receiptMapper;

    public List<BookDTO> selectAllBook() {

        SqlSession sqlSession = getSqlSession();

        receiptMapper = sqlSession.getMapper(ReceiptMapper.class);
        List<BookDTO> bookList = receiptMapper.selectAllBook();

        sqlSession.close();
        return bookList;
    }

    public boolean selectStockIn(InRecordDTO receipt) {

        SqlSession sqlSession = getSqlSession();

        receiptMapper = sqlSession.getMapper(ReceiptMapper.class);
        int result = receiptMapper.insertMenu(receipt);

        if(result > 0){
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }

        sqlSession.close();
        return result > 0 ? true : false;
    }
}

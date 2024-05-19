package com.infinityiterators.receipt.model.service;

import com.infinityiterators.receipt.mapper.ReceiptMapper;
import com.infinityiterators.receipt.model.dto.BookDTO;
import com.infinityiterators.receipt.model.dto.StockDTO;
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

    public boolean addNewBook(BookDTO receipt) {

        SqlSession sqlSession = getSqlSession();

        receiptMapper = sqlSession.getMapper(ReceiptMapper.class);
        int result = receiptMapper.addNewBook(receipt);

        if(result > 0){
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }

        sqlSession.close();
        return result > 0 ? true : false;
    }

    public boolean updateBook(StockDTO stock) {

        SqlSession sqlSession = getSqlSession();

        receiptMapper = sqlSession.getMapper(ReceiptMapper.class);
        int result = receiptMapper.updateBook(stock);

        if(result > 0){
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }

        sqlSession.close();
        return result > 0 ? true : false;
    }
}

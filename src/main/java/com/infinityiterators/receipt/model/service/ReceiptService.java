package com.infinityiterators.receipt.model.service;

import com.infinityiterators.receipt.mapper.ReceiptMapper;
import com.infinityiterators.receipt.model.dto.BookDTO;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

import static com.infinityiterators.bookwms.utils.database.MyBatisTemplate.getSqlSession;

public class ReceiptService {

    private ReceiptMapper receiptMapper;

    public List<BookDTO> selectAllStock() {

        SqlSession sqlSession = getSqlSession();

        receiptMapper = sqlSession.getMapper(ReceiptMapper.class);
        List<BookDTO> bookList = receiptMapper.selectAllStock();

        sqlSession.close();
        return bookList;
    }
}

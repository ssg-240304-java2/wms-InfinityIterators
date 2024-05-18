package com.infinityiterators.receipt.mapper;

import com.infinityiterators.receipt.model.dto.BookDTO;
import com.infinityiterators.receipt.model.dto.InRecordDTO;
import lombok.Setter;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;

import org.apache.ibatis.annotations.*;

import java.util.List;

public interface ReceiptMapper {
    @Results(id="BookResultMap", value = {
            @Result(id=true, property = "bookId", column = "BOOK_ID"),
            @Result(property = "title", column = "TITLE"),
            @Result(property = "author", column = "AUTHOR"),
            @Result(property = "publisher", column = "PUBLISHER"),
            @Result(property = "isbn", column = "ISBN")
    })
    @Select("SELECT " +
            "bookId\n" +
            ", title\n" +
            ", author\n" +
            ", publisher\n" +
            ", isbn\n" +
            "FROM\n" +
            "tbl_book\n"
            )
    List<BookDTO> selectAllBook();


    @Insert("INSERT INTO InRecord" +
            "(BookID, InAmount)" +
            "VALUES (#{bookID}, #{inAmount})")
    int insertMenu(InRecordDTO receipt);
}

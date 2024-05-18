package com.infinityiterators.receipt.mapper;

import com.infinityiterators.receipt.model.dto.BookDTO;

import java.util.List;

public interface ReceiptMapper {
    List<BookDTO> selectAllStock();
}

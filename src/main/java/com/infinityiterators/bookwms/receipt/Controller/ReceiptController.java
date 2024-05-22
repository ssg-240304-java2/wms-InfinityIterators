package com.infinityiterators.bookwms.receipt.Controller;

import com.infinityiterators.bookwms.receipt.model.dto.InRecordDTO;
import com.infinityiterators.bookwms.receipt.model.dto.StockDTO;
import com.infinityiterators.bookwms.receipt.model.service.ReceiptService;
import com.infinityiterators.bookwms.receipt.model.dto.BookDTO;

import java.util.List;

public class ReceiptController {


    private final PrintResult printResult;
    private final ReceiptService receiptService;

    public ReceiptController() {

        printResult = new PrintResult();
        receiptService = new ReceiptService();
    }

    public void selectAllBook() {       // 전체 재고 조회

        List<BookDTO> bookList = receiptService.selectAllBook();

        if(bookList != null){
            printResult.printResultList(bookList);
        } else{
            printResult.printErrorMessage("selectList");
        }
    }

    public void printResultList(List<BookDTO> bookList){

        for(BookDTO book : bookList){
            System.out.println(book);
        }
    }


    public void addNewBook(BookDTO parameter) {     // 신규도서 입력

        String title = parameter.getTitle();
        String author = parameter.getAuthor();
        String publisher = parameter.getPublisher();
        String nationCode = parameter.getNationCode();
        String genreCode = parameter.getGenreCode();

        BookDTO receipt = new BookDTO();
        receipt.setTitle(title);
        receipt.setAuthor(author);
        receipt.setPublisher(publisher);
        receipt.setNationCode(nationCode);
        receipt.setGenreCode(genreCode);

        if(receiptService.addNewBook(receipt)){
            printResult.printSuccessMessage("insert");
        } else{
            printResult.printErrorMessage("insert");
        }
    }

    public void updateBook(StockDTO parameter){     // 기존 도서 수량 변경

        String bookId = parameter.getBookID();
        int bookAmount = parameter.getBookAmount();

        StockDTO stock = new StockDTO();
        stock.setBookID(bookId);
        stock.setBookAmount(bookAmount);

        if(receiptService.updateBook(stock)){
            printResult.printSuccessMessage("update");
        } else{
            printResult.printErrorMessage("update");
        }

    }

    public void selectInRecord() {

        List<InRecordDTO> inRecordList = receiptService.selectInRecord();

        if(inRecordList != null){
            printResult.printInRecord(inRecordList);
        } else{
            printResult.printErrorMessage("selectList");
        }
    }

    public void selectInStock() {

        List<StockDTO> stockList = receiptService.selectInStock();

        if(stockList != null){
            printResult.printStockList(stockList);
        } else{
            printResult.printErrorMessage("selectList");
        }
    }
}

package com.infinityiterators.receipt.Controller;

import com.infinityiterators.receipt.model.dto.BookDTO;
import com.infinityiterators.receipt.model.dto.InRecordDTO;
import com.infinityiterators.receipt.model.dto.StockDTO;
import com.infinityiterators.receipt.model.service.ReceiptService;

import javax.xml.namespace.QName;
import java.awt.print.Book;
import java.util.List;
import java.util.Map;

public class ReceiptController {


    private final PrintResult printResult;
    private final ReceiptService receiptService;

    public ReceiptController() {

        printResult = new PrintResult();
        receiptService = new ReceiptService();
    }

    public void selectAllBook() {

        List<BookDTO> bookList = receiptService.selectAllBook();

        if(bookList != null){
            printResult.printResultList(bookList);
        } else{
            printResult.printErrorMessage("selectList");
        }
    }


    public void selectOutOfStock() {
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

        BookDTO receipt = new BookDTO();
        receipt.setTitle(title);
        receipt.setAuthor(author);
        receipt.setPublisher(publisher);

        if(receiptService.addNewBook(receipt)){
            printResult.printSuccessMessage("insert");
        } else{
            printResult.printErrorMessage("insert");
        }
    }

    public void updateBook(StockDTO parameter){

        String bookId = parameter.getBookID();
        int inAmount = parameter.getAmount();

        StockDTO stock = new StockDTO();
        stock.setBookID(bookId);
        stock.setAmount(inAmount);

        if(receiptService.updateBook(stock)){
            printResult.printSuccessMessage("update");
        } else{
            printResult.printErrorMessage("update");
        }

    }
}

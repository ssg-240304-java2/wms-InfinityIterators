package com.infinityiterators.receipt.Controller;

import com.infinityiterators.receipt.model.dto.BookDTO;
import com.infinityiterators.receipt.model.dto.InRecordDTO;
import com.infinityiterators.receipt.model.service.ReceiptService;

import javax.xml.namespace.QName;
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

    public void selectStockIn(Map<String ,String> parameter) {

        String bookID = parameter.get("bookID");
        int amount = Integer.parseInt(parameter.get("amount"));

        InRecordDTO receipt = new InRecordDTO();
        receipt.setBookID(bookID);
        receipt.setInAmount(amount);

        if(receiptService.selectStockIn(receipt)){
            printResult.printSuccessMessage("insert");
        } else{
            printResult.printErrorMessage("insert");
        }

    }

    public void selectOutOfStock() {
    }

    public void printResultList(List<InRecordDTO> bookList){

        for(InRecordDTO book : bookList){
            System.out.println(book);
        }
    }


}

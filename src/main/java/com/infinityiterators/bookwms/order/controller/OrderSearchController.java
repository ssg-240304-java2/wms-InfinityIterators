package com.infinityiterators.bookwms.order.controller;


import com.infinityiterators.bookwms.order.dto.OrderDTO;
import com.infinityiterators.bookwms.order.view.PrintResult;

import java.util.List;


public class OrderSearchController {
    private final PrintResult printResult;
    private final OrderSearchController orderSearchService;


    public OrderSearchController() {

        orderSearchService = new OrderSearchController();
        printResult = new PrintResult();

    }



    public List<OrderDTO> selectAllOrder() {

        List<OrderDTO> orderList = orderSearchService.selectAllOrder();

        if(orderList != null && !orderList.isEmpty()) {
            printResult.printOrderList(orderList);
        } else {
            printResult.printErrorMessage("selectListError");
        }

        return orderList;
    }


}

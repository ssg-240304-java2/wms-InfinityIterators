package com.infinityiterators.bookwms.cancelOrder.controller;

import com.infinityiterators.bookwms.cancelOrder.model.dto.OrderDTO;
import com.infinityiterators.bookwms.cancelOrder.service.CancelService;
import com.infinityiterators.bookwms.cancelOrder.view.PrintResult;

import java.util.List;

public class CancelController {
    private final PrintResult printResult;
    private final CancelService cancelService;

    public CancelController() {

        printResult = new PrintResult();
        cancelService = new CancelService();

    }

    public List<OrderDTO> selectAllOrder() {

        List<OrderDTO> orderList = cancelService.selectAllOrder();

        if (orderList != null && !orderList.isEmpty()) {
            // printResult.printOrderList(orderList);
        } else {
            printResult.printErrorMessage("selectListError");
        }

        return orderList;
    }

    public void updateCancelOrder(OrderDTO order) {

        if (cancelService.updateCancelOrder(order)) {
            printResult.printSuccessMessage("update");
        } else {
            printResult.printErrorMessage("update");
        }

    }
}

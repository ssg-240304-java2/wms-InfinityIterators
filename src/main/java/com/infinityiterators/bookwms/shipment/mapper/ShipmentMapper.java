package com.infinityiterators.bookwms.shipment.mapper;

import com.infinityiterators.bookwms.order.dto.OrderItemDTO;
import com.infinityiterators.bookwms.shipment.model.OrderDTO;
import com.infinityiterators.bookwms.shipment.model.OutRecordDTO;
import com.infinityiterators.bookwms.shipment.model.StockOutDTO;

import java.util.List;

public interface ShipmentMapper {
//    List<OutRecordDTO> selectAllMenu();

    List<OrderDTO> selectAllShipmentDate();  // 주문서 출력

//    OutRecordDTO selectShipmentByCode(int code);

//    @Update("UPDATE OutRecord" +
//            " SET SHIPMENTID = #{ shipmentId }" +
//            ", OUTAMOUNT = #{ amount }" +
//            ", SHIPMENTDATE = #{ date }" +
//            ", BOOKID = #{ bookId}")
    int AllShipmentDate (OrderDTO out);


//    @Update("UPDATE OutRecord" +
//            " SET SHIPMENTID = #{ shipmentId }" +
//            ", OUTAMOUNT = #{ amount }" +
//            ", SHIPMENTDATE = #{ date }" +
//            ", BOOKID = #{ bookId }")
//    int soldOutMenu(OutRecordDTO out);

//    @Update("UPDATE Book" +
//            " SET BookID = #{ bookId}")
    int soldOut(StockOutDTO book);

    int selectShipmentPlay(int orderId);

    List<OutRecordDTO> selectShipmentDetails(OutRecordDTO details);



    int insertOutRecord(int orderId);

    List<OrderItemDTO> selectOrderItem(int orderId);

    int updateStatus(int orderId);

    int verifAmount();
}

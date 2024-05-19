package com.infinityiterators.shipment.mapper;

import com.infinityiterators.shipment.model.OutRecordDTO;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface ShipmentMapper {
    List<OutRecordDTO> selectAllMenu();

    List<OutRecordDTO> selectAllShipmentDate();

    OutRecordDTO selectShipmentByCode(int code);

    @Update("UPDATE OutRecord" +
            " SET SHIPMENTID = #{ shipmentId }" +
            ", OUTAMOUNT = #{ amount }" +
            ", SHIPMENTDATE = #{ date }" +
            ", BOOKID = #{ bookId}")
    int modifyMenu(OutRecordDTO out);


    @Update("UPDATE OutRecord" +
            " SET SHIPMENTID = #{ shipmentId }" +
            ", OUTAMOUNT = #{ amount }" +
            ", SHIPMENTDATE = #{ date }" +
            ", BOOKID = #{ bookId }")
    int soldOutMenu(OutRecordDTO out);
}

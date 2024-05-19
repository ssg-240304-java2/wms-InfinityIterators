package com.infinityiterators.shipment.mapper;

import com.infinityiterators.shipment.model.dto.ShipmentDTO;

import java.util.List;

public interface ShipmentMapper {
    List<ShipmentDTO> selectAllMenu();

    List<ShipmentDTO> selectAllShipmentDate();

    ShipmentDTO selectShipmentByCode(int code);
}

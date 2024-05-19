package com.infinityiterators.shipment.model.dto;

import lombok.*;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class ShipmentDTO {

    private int BookID;
    private int quantity;
    private String Title;
    private String Author;
    private int Stock;
    private int Price;
    private String Publisher;
    private int ISBN;
    private int NationCode;
    private int GenreCode;
    private Date ReceiptDate;
    private Date ShipmentDate;
    private int ReceiptID;
    private int ShipmentID;


}



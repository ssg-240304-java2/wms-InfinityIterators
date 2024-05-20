package com.infinityiterators.shipment.model;


import lombok.*;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class OutRecordDTO {

    private String ShipmentID;
    private int OutAmount;
    private Date ShipmentDate;
    private String BookID;




}

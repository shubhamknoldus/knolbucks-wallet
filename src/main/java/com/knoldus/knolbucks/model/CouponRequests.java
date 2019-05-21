package com.knoldus.knolbucks.model;

import lombok.Builder;
import lombok.Getter;
import org.davidmoten.rx.jdbc.annotations.Column;

import java.sql.Date;
import java.sql.Timestamp;

//@Builder
//@Getter
public interface CouponRequests {
    @Column
    String id();

    @Column("requesterID")
    String requesterID();

    @Column("issuerID")
    String issuerID();

    @Column("requestedON")
    Timestamp requestedON();

    //    Date approvedON;
    @Column
    Integer quantity();

    @Column
    Boolean approved();
}

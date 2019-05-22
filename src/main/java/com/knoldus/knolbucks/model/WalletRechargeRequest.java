package com.knoldus.knolbucks.model;

import org.davidmoten.rx.jdbc.annotations.Column;

import java.sql.Timestamp;

public interface WalletRechargeRequest {

    @Column
    String id();

    @Column
    String walletID();

    @Column
    String requesterID();

    @Column
    String issuerID();

    @Column
    Timestamp requestedOn();

    @Column
    Timestamp approvedOn();

    @Column
    Integer quantity();

    @Column
    String status();
}

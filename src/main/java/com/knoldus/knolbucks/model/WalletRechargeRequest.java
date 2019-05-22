package com.knoldus.knolbucks.model;

import org.davidmoten.rx.jdbc.annotations.Column;

import java.sql.Timestamp;

public interface WalletRechargeRequest {

    @Column("id")
    String id();

    @Column("wallet_id")
    String walletID();

    @Column("requester_id")
    String requesterID();

    @Column("issuer_id")
    String issuerID();

    @Column("requested_on")
    Timestamp requestedOn();

    @Column("approved_on")
    Timestamp approvedOn();

    @Column("quantity")
    Integer quantity();

    @Column("status")
    String status();
}

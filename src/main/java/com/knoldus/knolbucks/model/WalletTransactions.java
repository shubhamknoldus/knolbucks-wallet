package com.knoldus.knolbucks.model;

import org.davidmoten.rx.jdbc.annotations.Column;

import java.sql.Timestamp;

public interface WalletTransactions {

    @Column
    String id();

    @Column
    String userID();

    @Column
    String walletID();

    @Column
    Timestamp createdOn();

    @Column
    String description();

    @Column
    String amount();
}

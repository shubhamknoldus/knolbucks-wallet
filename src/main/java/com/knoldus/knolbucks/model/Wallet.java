package com.knoldus.knolbucks.model;

import org.davidmoten.rx.jdbc.annotations.Column;

public interface Wallet {

    @Column
    String id();

    @Column
    String userID();

    @Column
    String amount();
}

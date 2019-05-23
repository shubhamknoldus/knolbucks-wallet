package com.knoldus.knolbucks.model;

import lombok.Builder;
import lombok.Getter;
import org.davidmoten.rx.jdbc.annotations.Column;

import java.sql.Date;
import java.sql.Timestamp;

@Builder
@Getter
public class WalletRechargeRequest {

    String id;

    String walletId;

    String requesterId;

    String issuerId;

    Timestamp requestedOn;

    Timestamp approvedOn;

    int quantity;

    String status;
}

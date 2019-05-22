package com.knoldus.knolbucks.repository.impl;

import com.knoldus.knolbucks.model.WalletRechargeRequest;
import com.knoldus.knolbucks.repository.WalletRechargeRequestRepository;
import com.knoldus.knolbucks.repository.utils.DBObject;
import reactor.core.publisher.Flux;

import java.sql.Timestamp;
import java.util.Date;

public class WalletRechargeRequestRepositoryImpl implements WalletRechargeRequestRepository {

    final String tableName = "wallet_recharge_request";

    public Boolean save(WalletRechargeRequest walletRechargeRequest) {

        String insertQuery = "insert into " + tableName + " values(?, ?, ?, ?, ?, ?, ?, ?)";
        return DBObject.getDBObject().update(insertQuery)
                .parameters(walletRechargeRequest.id(), walletRechargeRequest.walletID(), walletRechargeRequest.requesterID(), walletRechargeRequest.issuerID(), walletRechargeRequest.requestedOn(),
                        walletRechargeRequest.approvedOn(), walletRechargeRequest.quantity(), walletRechargeRequest.status()).counts().blockingFirst() > 0;
    }

    Flux<WalletRechargeRequest> findAll() {
        return Flux.fromIterable(DBObject.getDBObject().select("select * from " + tableName ).autoMap(WalletRechargeRequest.class).blockingIterable());
    }

    public static void main(String args[]) {
        WalletRechargeRequest w = new WalletRechargeRequest() {
            @Override
            public String id() {
                return "id111";
            }

            @Override
            public String walletID() {
                return "walletID11";
            }

            @Override
            public String requesterID() {
                return "requesterID11";
            }

            @Override
            public String issuerID() {
                return "issuerID11";
            }

            @Override
            public Timestamp requestedOn() {
                return new Timestamp(new Date().getTime());
            }

            @Override
            public Timestamp approvedOn() {
                return null;
            }

            @Override
            public Integer quantity() {
                return 10;
            }

            @Override
            public String status() {
                return "Pending";
            }
        };
//        System.out.println(new WalletRechargeRequestRepositoryImpl().save(w));
        new WalletRechargeRequestRepositoryImpl().findAll().toStream().forEach(System.out::println);
    }

}

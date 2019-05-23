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

    Flux<WalletRechargeRequest> findByID(String id) {
        return Flux.fromIterable(DBObject.getDBObject().select("select * from " + tableName + " where id = '"+ id +"'").autoMap(WalletRechargeRequest.class).blockingIterable());
    }

    Flux<WalletRechargeRequest> findAll() {
        return Flux.fromIterable(DBObject.getDBObject().select("select * from " + tableName).autoMap(WalletRechargeRequest.class).blockingIterable());
    }

    Boolean updateQuantityByID(String id, String quantity) {
        String updateQuery = "update " + tableName + " set quantity = '" + quantity + "' where id = '" + id + "'";
        return DBObject.getDBObject().update(updateQuery).counts().blockingFirst() > 0;
    }

}

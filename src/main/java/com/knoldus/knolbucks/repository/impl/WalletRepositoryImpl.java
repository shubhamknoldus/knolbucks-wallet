package com.knoldus.knolbucks.repository.impl;

import com.knoldus.knolbucks.model.Wallet;
import com.knoldus.knolbucks.repository.WalletRepository;
import com.knoldus.knolbucks.repository.utils.DBObject;
import reactor.core.publisher.Flux;

public class WalletRepositoryImpl implements WalletRepository {

    String tableName = "wallet";

    public Boolean create() {
        if (DBObject.getDBObject().select("describe " + tableName).count().blockingGet() <= 0) {
            String create = "CREATE TABLE " + tableName + "( id varchar(36) primary key, user_id varchar(36), amount varchar(32))";
            return DBObject.getDBObject().update(create).counts().blockingFirst() >= 0;
        } else
            return false;
    }

    public Boolean save(Wallet wallet) {
        String insertQuery = "insert into " + tableName + " values(?, ?, ?)";
        return DBObject.getDBObject().update(insertQuery)
                .parameters(wallet.id(), wallet.userID(), wallet.amount())
                .counts().blockingFirst() > 0;
    }

    public Flux<Wallet> findAll() {
        return Flux.fromIterable(DBObject.getDBObject().select("select * from " + tableName).autoMap(Wallet.class).blockingIterable());
    }

    public Flux<Wallet> findByID(String id) {
        return Flux.fromIterable(DBObject.getDBObject().select("select * from " + tableName + " where id = '" + id + "'").autoMap(Wallet.class).blockingIterable());
    }

    public Boolean updateByID(String id, String amount) {
        String updateQuery = "update " + tableName + " set amount = '" + amount + "' where id = '" + id + "'";
        return DBObject.getDBObject().update(updateQuery).counts().blockingFirst() > 0;
    }
}

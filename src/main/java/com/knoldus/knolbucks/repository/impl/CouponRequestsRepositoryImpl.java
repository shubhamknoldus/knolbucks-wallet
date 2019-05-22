package com.knoldus.knolbucks.repository.impl;

import com.knoldus.knolbucks.model.CouponRequests;
import com.knoldus.knolbucks.repository.CouponRequestsRepository;
import org.davidmoten.rx.jdbc.Database;
import reactor.core.publisher.Flux;

import java.sql.Timestamp;
import java.util.Date;

public class CouponRequestsRepositoryImpl implements CouponRequestsRepository {

    static Database getDBObject() {
        Database db = Database.from("jdbc:mysql://localhost:3306/knolbucks?user=root&password=root", 10);
        return db;
    }

    Flux<CouponRequests> findAll() {
        return Flux.fromIterable(getDBObject().select("select * from coupon_requests").autoMap(CouponRequests.class).blockingIterable());
    }

    //NJ - This is a sample code and hence has some hard coded sample data. We can make changes accordingly whenever implementing the complete routes as per the finalized schema.
    boolean insert() {
        Timestamp time = new Timestamp(new Date().getTime());
        return getDBObject().update("insert into coupon_requests values('3', 'rid2', 'iid2', ?, 3, 2)")
        .parameter(time).counts().blockingFirst() > 0;
    }

    public static void main(String[] args) {
        CouponRequestsRepositoryImpl obj = new CouponRequestsRepositoryImpl();

        obj.findAll().toStream().forEach(System.out::println);
        String s = obj.insert() ? "Inserted" : "Failed";
        System.out.println("Status = " + s);
        obj.findAll().toStream().forEach(System.out::println);
    }
}

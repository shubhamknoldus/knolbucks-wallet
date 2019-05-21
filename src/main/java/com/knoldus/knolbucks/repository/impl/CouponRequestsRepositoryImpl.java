package com.knoldus.knolbucks.repository.impl;

import com.knoldus.knolbucks.Persons;
import com.knoldus.knolbucks.model.CouponRequests;
import com.knoldus.knolbucks.repository.CouponRequestsRepository;
import org.davidmoten.rx.jdbc.Database;
import reactor.core.publisher.Flux;

public class CouponRequestsRepositoryImpl implements CouponRequestsRepository {

    static Database getDBObject() {
        Database db = Database.from("jdbc:mysql://localhost:3306/knolbucks?user=root&password=root", 10);
        return db;
    }

    Flux<CouponRequests> findAll() {
        return Flux.fromIterable(getDBObject().select("select * from coupon_requests").autoMap(CouponRequests.class).blockingIterable());
    }

    public static void main(String[] args) {
        CouponRequestsRepositoryImpl obj = new CouponRequestsRepositoryImpl();

        obj.findAll().toStream().forEach(System.out::println);
    }
}

package com.knoldus.knolbucks.repository.impl;

import com.knoldus.knolbucks.Persons;
import com.knoldus.knolbucks.model.CouponRequests;
import com.knoldus.knolbucks.repository.CouponRequestsRepository;
import io.reactivex.Flowable;
import io.reactivex.Observable;
import org.davidmoten.rx.jdbc.Database;
import org.davidmoten.rx.jdbc.ResultSetMapper;
import reactor.core.publisher.Flux;

import java.sql.Timestamp;

public class CouponRequestsRepositoryImpl implements CouponRequestsRepository {

    static Database getDBObject() {
        Database db = Database.from("jdbc:mysql://localhost:3306/knolbucks?user=root&password=root", 10);
        return db;
    }

    void findAll() {
        getDBObject().select("select * from coupon_requests").autoMap(CouponRequests.class).blockingForEach(System.out::println);
    }

    public static void main(String[] args) {
        CouponRequestsRepositoryImpl obj = new CouponRequestsRepositoryImpl();

        obj.findAll();
    }
}

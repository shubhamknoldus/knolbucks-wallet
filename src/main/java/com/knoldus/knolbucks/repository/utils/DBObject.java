package com.knoldus.knolbucks.repository.utils;

import org.davidmoten.rx.jdbc.Database;

public class DBObject {
    public static Database getDBObject() {
        return Database.from("jdbc:mysql://localhost:3306/knolbucks?user=root&password=root", 10);
    }
}

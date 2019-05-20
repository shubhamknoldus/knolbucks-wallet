package com.knoldus.knolbucks;

import org.davidmoten.rx.jdbc.Database;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CouponsApplication {

    public static void main(String[] args)
    {
        Database db = Database.from("jdbc:mysql://localhost:3306/nancy", 10);
        db.select("select name from Persons")
                .getAs(String.class)
                .blockingForEach(System.out::println);
       // SpringApplication.run(CouponsApplication.class, args);
    }

}

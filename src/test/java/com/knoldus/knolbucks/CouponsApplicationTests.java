package com.knoldus.knolbucks;

import org.davidmoten.rx.jdbc.Database;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CouponsApplicationTests {

    @Test
    public void contextLoads() {
        /*TODO: NJ - This is just a sample code for database connection created for testing purpose so will be removed*/
        Database db = Database.from("jdbc:mysql://localhost:3306/knolbucks?user=root&password=root", 10);
        db.select("select LastName from Persons")
               .getAs(String.class).blockingForEach(System.out::println);

    }

}

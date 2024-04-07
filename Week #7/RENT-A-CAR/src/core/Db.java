package core;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.SQLOutput;

public class Db {
    private Connection connection = null;
    private final String DB_URL = "jdbc:postgresql://localhost:5432/rentacar";
    private final String DB_USERNAME = "postgres";
    private final String DB_PASS = "1234";

    private Db(){
        try {
            Connection connection = DriverManager.getConnection(DB_URL,DB_USERNAME,DB_PASS);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}

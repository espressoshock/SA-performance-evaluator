package se.hkr.grp02.da216b.DAL;

import com.mysql.cj.jdbc.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public interface IDBManager {
    public static final String CONNECTION_URL = "jdbc:mysql://den1.mysql6.gear.host:3306/sapevaluatordb";
    public static final String CONNECTION_USER = "sapevaluatordb";
    public static final String CONNECTION_PASSWORD = "Kb4N70U3mA??";

    public static Connection getConnection(){
        try {
            java.sql.DriverManager.registerDriver(new Driver());
            return DriverManager.getConnection(CONNECTION_URL, CONNECTION_USER, CONNECTION_PASSWORD);
        } catch (SQLException ex) {
            throw new RuntimeException("Error connecting to the database", ex);
        }
    };


}

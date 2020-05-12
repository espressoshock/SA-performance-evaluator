package se.hkr.grp02.da216b.DAL;

import com.mysql.cj.jdbc.Driver;
import se.hkr.grp02.da216b.HIBDB.ECAlgorithms;
import se.hkr.grp02.da216b.utilities.Algorithms;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
    /******************* ALGORITHM *******************/

    /***
     * Insert algorithm entry
     * @param algorithm to be added
     * @return transaction result
     */
    public static Boolean insertAlgorithm(ECAlgorithms algorithm){
        Connection connection = IDBManager.getConnection();
        try{
            PreparedStatement ps = connection.prepareStatement("INSERT INTO algorithms VALUES (?, ?,?,?,?,?)");
            ps.setString(1, algorithm.getName());
            ps.setString(2, algorithm.getType().toString());
            ps.setString(3, algorithm.getComplexityBestCase());
            ps.setString(4, algorithm.getComplexityAverageCase());
            ps.setString(5, algorithm.getComplexityWorstCase());
            ps.setInt(6, algorithm.getStabilityNumber());
            if(ps.executeUpdate() == 1) return true;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    };

    /******************* ALGORITHM *******************/


}

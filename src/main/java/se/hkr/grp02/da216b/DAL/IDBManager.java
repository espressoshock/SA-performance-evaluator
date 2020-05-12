package se.hkr.grp02.da216b.DAL;

import com.mysql.cj.jdbc.Driver;
import se.hkr.grp02.da216b.HIBDB.ECAlgorithm;
import se.hkr.grp02.da216b.HIBDB.ECAlgorithmType;
import se.hkr.grp02.da216b.utilities.Algorithms;
import se.hkr.grp02.da216b.utilities.Result;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public interface IDBManager {
    public static final String CONNECTION_URL = "jdbc:mysql://den1.mysql6.gear.host:3306/sapevaluatordb";
    public static final String CONNECTION_USER = "sapevaluatordb";
    public static final String CONNECTION_PASSWORD = "Kb4N70U3mA??";

    public static Connection getConnection() {
        try {
            java.sql.DriverManager.registerDriver(new Driver());
            return DriverManager.getConnection(CONNECTION_URL, CONNECTION_USER, CONNECTION_PASSWORD);
        } catch (SQLException ex) {
            throw new RuntimeException("Error connecting to the database", ex);
        }
    }

    ;
    /******************* ALGORITHM *******************/

    /***
     * Insert algorithm entry
     * @param algorithm to be added
     * @return transaction result
     */
    public static Boolean insertAlgorithm(ECAlgorithm algorithm) {
        Connection connection = IDBManager.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO algorithms VALUES (?, ?,?,?,?,?)");
            ps.setString(1, algorithm.getName());
            ps.setString(2, algorithm.getType().toString());
            ps.setString(3, algorithm.getComplexityBestCase());
            ps.setString(4, algorithm.getComplexityAverageCase());
            ps.setString(5, algorithm.getComplexityWorstCase());
            ps.setInt(6, algorithm.getStabilityNumber());
            if (ps.executeUpdate() == 1) return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    ;

    public static List<ECAlgorithm> getAllAlgorithms() {
        Connection connection = IDBManager.getConnection();
        List<ECAlgorithm> ECAlgorithms = new ArrayList<>();

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM algorithms");

            while (resultSet.next()) {
                ECAlgorithms.add(new ECAlgorithm(
                        resultSet.getString("name"),
                        ECAlgorithmType.valueOf(resultSet.getString("type")),
                        resultSet.getString("complexity_bestCase"),
                        resultSet.getString("complexity_averageCase"),
                        resultSet.getString("complexity_worstCase"),
                        resultSet.getBoolean("stability"))
                );
            }
            return ECAlgorithms;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static ECAlgorithm getAlgorithmWithName(String algorithmName) {
        Connection connection = IDBManager.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM algorithms WHERE name=?");
            ps.setString(1, algorithmName);

            ResultSet resultSet = ps.executeQuery();

            if (resultSet.next())
                return new ECAlgorithm(
                        resultSet.getString("name"),
                        ECAlgorithmType.valueOf(resultSet.getString("type")),
                        resultSet.getString("complexity_bestCase"),
                        resultSet.getString("complexity_averageCase"),
                        resultSet.getString("complexity_worstCase"),
                        resultSet.getBoolean("stability"));

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /******************* ALGORITHM *******************/


}

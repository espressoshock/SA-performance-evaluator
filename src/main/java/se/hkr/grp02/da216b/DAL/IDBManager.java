package se.hkr.grp02.da216b.DAL;

import com.mysql.cj.jdbc.Driver;
import se.hkr.grp02.da216b.HIBDB.ECAlgorithm;
import se.hkr.grp02.da216b.HIBDB.ECAlgorithmType;
import se.hkr.grp02.da216b.HIBDB.ECRTLEntry;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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

    ////////////////////// ALGORITHMs

    /***
     * [INSERT] Insert algorithm entry
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

    /***
     * [GET][MULTIPLE-ENTRY] Get all algorithms entries
     * @return all ECAlgorithm entries
     */
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

    /***
     * [GET][SINGLE-ENTRY] Get all algorithms with name
     * @param algorithmName algorithm name to filter by
     * @return All algorithms with provided name
     */
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

    /***
     * [GET][MULTIPLE-ENTRY] Get all algorithms given average case
     * @param algorithmAverageCase average case
     * @return All algorithm with provided average case
     */
    public static List<ECAlgorithm> getAllAlgorithmsWithAverageCase(String algorithmAverageCase) {
        Connection connection = IDBManager.getConnection();
        List<ECAlgorithm> ECAlgorithms = new ArrayList<>();

        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM algorithms WHERE complexity_averageCase=?");
            ps.setString(1, algorithmAverageCase);

            ResultSet resultSet = ps.executeQuery();

            while (resultSet.next())
                ECAlgorithms.add(new ECAlgorithm(
                        resultSet.getString("name"),
                        ECAlgorithmType.valueOf(resultSet.getString("type")),
                        resultSet.getString("complexity_bestCase"),
                        resultSet.getString("complexity_averageCase"),
                        resultSet.getString("complexity_worstCase"),
                        resultSet.getBoolean("stability")));

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ECAlgorithms;
    }

    /***
     * [GET][MULTIPLE-ENTRY] Get All algorithm given best case
     * @param algorithmBestCase best case
     * @return All algorithm with provided best case
     */
    public static List<ECAlgorithm> getAllAlgorithmsWithBestCase(String algorithmBestCase) {
        Connection connection = IDBManager.getConnection();
        List<ECAlgorithm> ECAlgorithms = new ArrayList<>();

        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM algorithms WHERE complexity_bestCase=?");
            ps.setString(1, algorithmBestCase);

            ResultSet resultSet = ps.executeQuery();

            while (resultSet.next())
                ECAlgorithms.add(new ECAlgorithm(
                        resultSet.getString("name"),
                        ECAlgorithmType.valueOf(resultSet.getString("type")),
                        resultSet.getString("complexity_bestCase"),
                        resultSet.getString("complexity_averageCase"),
                        resultSet.getString("complexity_worstCase"),
                        resultSet.getBoolean("stability")));

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ECAlgorithms;
    }

    /***
     * [GET][MULTIPLE-ENTRY] Get all algorithms given worst case
     * @param algorithmWorstCase worst case
     * @return All algorithms with worst case
     */
    public static List<ECAlgorithm> getAllAlgorithmsWithWorstCase(String algorithmWorstCase) {
        Connection connection = IDBManager.getConnection();
        List<ECAlgorithm> ECAlgorithms = new ArrayList<>();

        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM algorithms WHERE complexity_worstCase=?");
            ps.setString(1, algorithmWorstCase);

            ResultSet resultSet = ps.executeQuery();

            while (resultSet.next())
                ECAlgorithms.add(new ECAlgorithm(
                        resultSet.getString("name"),
                        ECAlgorithmType.valueOf(resultSet.getString("type")),
                        resultSet.getString("complexity_bestCase"),
                        resultSet.getString("complexity_averageCase"),
                        resultSet.getString("complexity_worstCase"),
                        resultSet.getBoolean("stability")));

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ECAlgorithms;
    }

    ////////////////////// ALGORITHMs


    ////////////////////// RTLENTRIES

    /***
     * [INSERT] Insert RTLEntry
     * @param rtlEntry to insert
     * @return transaction result
     */
    public static Boolean insertRTLEntry(ECRTLEntry rtlEntry) {
        Connection connection = IDBManager.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO rtlentries VALUES (NULL, NULL,?,?,?,?,?)");
            ps.setString(1, rtlEntry.getRtrResult());
            ps.setString(2, rtlEntry.getTargetlang());
            ps.setString(3, rtlEntry.getTargetOS());
            ps.setString(4, rtlEntry.getAlgorithmFK());
            ps.setString(5, rtlEntry.getWorkload());

            if (ps.executeUpdate() == 1) return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    /***
     * [GET][MULTIPLE-ENTRY] Get all RTLEntries
     * @return all RTLEntry(s)
     */
    public static List<ECRTLEntry> getAllRTLEntries() {
        Connection connection = IDBManager.getConnection();
        List<ECRTLEntry> ECRTLEntries = new ArrayList<>();

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM rtlentries");

            while (resultSet.next()) {
                ECRTLEntries.add(new ECRTLEntry(
                                resultSet.getInt("id"),
                                resultSet.getTimestamp("timestamp"),
                                resultSet.getString("RTResult"),
                                resultSet.getString("targetlang"),
                                resultSet.getString("targetOS"),
                                resultSet.getString("Algorithms_name"),
                                resultSet.getString("workload")
                        )
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ECRTLEntries;
    }

    /***
     * [GET][MULTIPLE-ENTRY] Get all RTLEntry(s) given an algorithm name
     * @param algorithmName
     * @return
     */
    public static List<ECRTLEntry> getAllRTLEntriesWithAlgorithmName(String algorithmName) {
        Connection connection = IDBManager.getConnection();
        List<ECRTLEntry> ECRTLEntries = new ArrayList<>();

        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM rtlentries where Algorithms_name=?");
            ps.setString(1, algorithmName);

            ResultSet resultSet = ps.executeQuery();

            while (resultSet.next()) {
                ECRTLEntries.add(new ECRTLEntry(
                                resultSet.getInt("id"),
                                resultSet.getTimestamp("timestamp"),
                                resultSet.getString("RTResult"),
                                resultSet.getString("targetlang"),
                                resultSet.getString("targetOS"),
                                resultSet.getString("Algorithms_name"),
                                resultSet.getString("workload")
                        )
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ECRTLEntries;
    }

    public static List<ECRTLEntry> getAllRTLEntriesWithRTResult(String rtResult) {
        Connection connection = IDBManager.getConnection();
        List<ECRTLEntry> ECRTLEntries = new ArrayList<>();

        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM rtlentries where RTResult=?");
            ps.setString(1, rtResult);

            ResultSet resultSet = ps.executeQuery();

            while (resultSet.next()) {
                ECRTLEntries.add(new ECRTLEntry(
                                resultSet.getInt("id"),
                                resultSet.getTimestamp("timestamp"),
                                resultSet.getString("RTResult"),
                                resultSet.getString("targetlang"),
                                resultSet.getString("targetOS"),
                                resultSet.getString("Algorithms_name"),
                                resultSet.getString("workload")
                        )
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ECRTLEntries;
    }


    ////////////////////// RTLENTRIES


}

package se.hkr.grp02.da216b.DAL;

import se.hkr.grp02.da216b.HIBDB.ECAlgorithmType;
import se.hkr.grp02.da216b.HIBDB.ECAlgorithm;
import se.hkr.grp02.da216b.HIBDB.ECRTLEntry;

import java.sql.Connection;
import java.util.List;

public class DBManager implements IDBManager {


    /***
     * IN-CLASS CONNECTION TEST
     * @param args
     */
    public static void main(String[] args) {
        Connection connection = IDBManager.getConnection();

        System.out.println(IDBManager.insertAlgorithm(new ECAlgorithm("DUMMY [DELETE-ME]", ECAlgorithmType.comparisonSort, "nlogn", "nlogn", "n^2", false)));

        List<ECAlgorithm> getAllAlgorithms = IDBManager.getAllAlgorithms();
        List<ECAlgorithm> getAllAlgorithmsWithWorstCase = IDBManager.getAllAlgorithmsWithWorstCase("n^2");
        List<ECRTLEntry> getAllRTLEntries = IDBManager.getAllRTLEntries();
        List<ECRTLEntry> getAllRTLEntriesWithAlgorithmName = IDBManager.getAllRTLEntriesWithAlgorithmName("MergeSort");
        List<ECRTLEntry> getAllRTLEntriesWithWorkLoad1 = IDBManager.getAllRTLEntriesWithWorkLoad(100);
        List<ECRTLEntry> getAllRTLEntriesWithWorkLoad2 = IDBManager.getAllRTLEntriesWithWorkLoad(100, 1000);


        System.out.println("end");
     
    }
}

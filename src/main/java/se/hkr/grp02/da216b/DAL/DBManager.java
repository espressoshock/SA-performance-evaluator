package se.hkr.grp02.da216b.DAL;

import java.sql.Connection;

public class DBManager implements IDBManager{

    /***
     * IN-CLASS CONNECTION TEST
     * @param args
     */
    public static void main(String[] args) {
        Connection connection = IDBManager.getConnection();
    }
}

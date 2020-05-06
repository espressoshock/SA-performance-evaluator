package se.hkr.grp02.da216b.mocks;

import se.hkr.grp02.da216b.utilities.Result;

public class DBMock implements IDBMock {
    private boolean connection;

    @Override
    public Result[] returnResults() {
        return new Result[0];
    }

    @Override
    public void pushResult(Result result) {
        System.out.println("Results will be pushed to the Database");
    }

    @Override
    public boolean connect(String address, String userName, String password) {
        System.out.println("Connecting to Database...");
        connection = true;
        return true;
    }

    @Override
    public void disconnect() {
        System.out.println("Disconnecting from Database...");
        connection = false;
    }

    @Override
    public boolean isConnected() {
        System.out.print("Is connection alive: ");
        return connection;
    }

    @Override
    public String getName(int id) {
        System.out.print("Database name: ");
        return "Database1";
    }
}

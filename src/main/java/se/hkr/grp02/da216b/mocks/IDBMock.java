package se.hkr.grp02.da216b.mocks;

import se.hkr.grp02.da216b.utilities.Result;

public interface IDBMock {
    Result[] returnResults();
    void pushResult(Result result);
    public boolean connect(String address, String userName,String password);
    public void disconnect();
    public boolean isConnected();
    public String getName(int id);

}

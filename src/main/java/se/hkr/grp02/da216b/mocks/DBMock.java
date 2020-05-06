package se.hkr.grp02.da216b.mocks;

import se.hkr.grp02.da216b.utilities.Result;

public class DBMock implements IDBMock {

    public Result[] returnResults() {
        return new Result[0];
    }
    public void pushResult(Result result) {
    }
}

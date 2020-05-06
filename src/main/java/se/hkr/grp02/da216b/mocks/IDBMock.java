package se.hkr.grp02.da216b.mocks;

import se.hkr.grp02.da216b.utilities.Result;

public interface IDBMock {
    Result[] returnResults();
    void pushResult(Result result);
}

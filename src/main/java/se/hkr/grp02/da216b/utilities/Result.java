package se.hkr.grp02.da216b.utilities;

import se.hkr.grp02.da216b.workloads.Workload;

public class Result {
    private String algorithmName;
    private Workload workload;
    private long time;

    public Result(long time, String algorithmName, Workload workload) {
        this.time = time;
        this.algorithmName = algorithmName;
        this.workload = workload;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public String getAlgorithmName() {
        return algorithmName;
    }

    public void setAlgorithmName(String algorithmName) {
        this.algorithmName = algorithmName;
    }

    public Workload getWorkload() {
        return workload;
    }

    public void setWorkload(Workload workload) {
        this.workload = workload;
    }
}

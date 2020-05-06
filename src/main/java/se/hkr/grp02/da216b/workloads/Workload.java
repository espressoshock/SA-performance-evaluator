package se.hkr.grp02.da216b.workloads;

public class Workload {
    private IntWorkload intWorkload;
    private StringWorkload stringWorkload;

    public Workload(IntWorkload intWorkload) {
        this.intWorkload = intWorkload;
    }

    public Workload(StringWorkload stringWorkload) {
        this.stringWorkload = stringWorkload;
    }

    public IntWorkload getIntWorkload() {
        return intWorkload;
    }

    public StringWorkload getStringWorkload() {
        return stringWorkload;
    }
}

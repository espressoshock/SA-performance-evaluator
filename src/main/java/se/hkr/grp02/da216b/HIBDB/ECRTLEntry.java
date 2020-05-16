package se.hkr.grp02.da216b.HIBDB;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

@Entity
@Table(name = "RTLEntries")
public class ECRTLEntry {
    @Id
    @Column(name = "id")
    int id;

    @Column(name = "timestamp")
    Timestamp timestamp;

    @Column(name = "RTRestult")
    String rtrResult;

    @Column(name = "caseType")
    String caseType;

    @Column(name = "workloadType")
    String workloadType;

    @Column(name = "Algorithms_name")
    String algorithmFK;

    @Column(name = "workload")
    String workload;

    public ECRTLEntry(int id, Timestamp timestamp, String rtrResult, String caseType, String workloadType, String algorithmFK, String workload) {
        this.id = id;
        this.timestamp = timestamp;
        this.rtrResult = rtrResult;
        this.caseType = caseType;
        this.workloadType = workloadType;
        this.algorithmFK = algorithmFK;
        this.workload = workload;
    }

    // use this one
    public ECRTLEntry(String rtrResult, String caseType, String workloadType, String algorithmFK, String workload) {
        this.rtrResult = rtrResult;
        this.caseType = caseType;
        this.workloadType = workloadType;
        this.algorithmFK = algorithmFK;
        this.workload = workload;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public String getRtrResult() {
        return rtrResult;
    }

    public void setRtrResult(String rtrResult) {
        this.rtrResult = rtrResult;
    }

    public String getCaseType() {
        return caseType;
    }

    public void setCaseType(String caseType) {
        this.caseType = caseType;
    }

    public String getWorkloadType() {
        return workloadType;
    }

    public void setWorkloadType(String workloadType) {
        this.workloadType = workloadType;
    }

    public String getWorkload() {
        return workload;
    }

    public void setWorkload(String workload) {
        this.workload = workload;
    }

    public String getAlgorithmFK() {
        return algorithmFK;
    }

    public void setAlgorithmFK(String algorithmFK) {
        this.algorithmFK = algorithmFK;
    }
}

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

    @Column(name = "targetlang")
    String targetlang;

    @Column(name = "targetOS")
    String targetOS;

    @Column(name = "Algorithms_name")
    String algorithmFK;

    @Column(name = "workload")
    String workload;

    public ECRTLEntry(int id, Timestamp timestamp, String rtrResult, String targetlang, String targetOS, String algorithmFK, String workload) {
        this.id = id;
        this.timestamp = timestamp;
        this.rtrResult = rtrResult;
        this.targetlang = targetlang;
        this.targetOS = targetOS;
        this.algorithmFK = algorithmFK;
        this.workload = workload;
    }

    // use this one
    public ECRTLEntry(String rtrResult, String targetlang, String targetOS, String algorithmFK, String workload) {
        this.rtrResult = rtrResult;
        this.targetlang = targetlang;
        this.targetOS = targetOS;
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

    public String getTargetlang() {
        return targetlang;
    }

    public void setTargetlang(String targetlang) {
        this.targetlang = targetlang;
    }

    public String getTargetOS() {
        return targetOS;
    }

    public void setTargetOS(String targetOS) {
        this.targetOS = targetOS;
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

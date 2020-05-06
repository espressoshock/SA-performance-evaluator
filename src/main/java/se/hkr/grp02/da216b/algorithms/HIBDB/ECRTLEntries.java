package se.hkr.grp02.da216b.algorithms.HIBDB;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

@Entity
@Table(name = "RTLEntries")
public class ECRTLEntries {
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


}

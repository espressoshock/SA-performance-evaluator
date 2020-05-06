package se.hkr.grp02.da216b.algorithms.HIBDB;

import javax.persistence.*;

@Entity
@Table(name = "Algorithms")
public class ECAlgorithms {
    @Id
    @Column(name = "name")
    String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    String type;

    @Column(name = "complexity_bestCase")
    String complexityBestCase;
    @Column(name = "complexity_averageCase")
    String complexityAverageCase;
    @Column(name = "complexity_worstCase")
    String complexityWorstCase;

    @Column(name = "stability", columnDefinition = "tinyint default false")
    Boolean stability;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getComplexityBestCase() {
        return complexityBestCase;
    }

    public void setComplexityBestCase(String complexityBestCase) {
        this.complexityBestCase = complexityBestCase;
    }

    public String getComplexityAverageCase() {
        return complexityAverageCase;
    }

    public void setComplexityAverageCase(String complexityAverageCase) {
        this.complexityAverageCase = complexityAverageCase;
    }

    public String getComplexityWorstCase() {
        return complexityWorstCase;
    }

    public void setComplexityWorstCase(String complexityWorstCase) {
        this.complexityWorstCase = complexityWorstCase;
    }

    public Boolean getStability() {
        return stability;
    }

    public void setStability(Boolean stability) {
        this.stability = stability;
    }
}

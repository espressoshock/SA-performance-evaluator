package to_be_merged.workloads;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IntWorkloadTest {
    IntWorkload intWorkloadAverage = new IntWorkload(1,100);
    IntWorkload intWorkloadWorst = new IntWorkload(2,100);

    @Test
    void intWorkload() {
        System.out.println("Integer workload");
        assertTrue(intWorkloadAverage.getWorkload() instanceof int[]);
    }

    @Test
    void averageCase() {
        System.out.println("Average case");
        int exchangesA = 0;
        int exchangesW = 0;
        for( int i = 0; i < intWorkloadAverage.getWorkload().length; i=i+2 ){
            if(intWorkloadAverage.getWorkload()[i]>intWorkloadAverage.getWorkload()[i+1]){
                exchangesA++;
            }
        }
        for( int i = 0; i < intWorkloadWorst.getWorkload().length; i=i+2 ){
            if(intWorkloadWorst.getWorkload()[i]>intWorkloadWorst.getWorkload()[i+1]){
                exchangesW++;
            }
        }
        assertTrue(exchangesA < exchangesW);
    }

    @Test
    void worstCase() {
        System.out.println("Worst case");
        int exchangesA = 0;
        int exchangesW = 0;
        for( int i = 0; i < intWorkloadAverage.getWorkload().length; i=i+2 ){
            if(intWorkloadAverage.getWorkload()[i]>intWorkloadAverage.getWorkload()[i+1]){
                exchangesA++;
            }
        }
        for( int i = 0; i < intWorkloadWorst.getWorkload().length; i=i+2 ){
            if(intWorkloadWorst.getWorkload()[i]>intWorkloadWorst.getWorkload()[i+1]){
                exchangesW++;
            }
        }
        assertTrue(exchangesA < exchangesW);
    }
    @Test
    void getWorkload(){
        System.out.println("Get Workload");
        IntWorkload getWorkloadTest = new IntWorkload(1, 100);
        Workload workloadTest = new Workload(getWorkloadTest);
        assertEquals(getWorkloadTest.getWorkload(),workloadTest.getIntWorkload().getWorkload());
    }
}
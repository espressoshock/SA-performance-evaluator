package to_be_merged.workloads;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringWorkloadTest {
    StringWorkload averageStringWorkload = new StringWorkload(1,100);
    StringWorkload worstStringWorkload = new StringWorkload(2,100);


    @Test
    void averageCase() {
        System.out.println("Average case");
        int exchangesA = 0;
        int exchangesW = 0;
        for( int i = 0; i < averageStringWorkload.getWorkload().length; i=i+2 ){
            if(averageStringWorkload.getWorkload()[i].compareTo(averageStringWorkload.getWorkload()[i+1]) == 1){
                exchangesA++;
            }
        }
        for( int i = 0; i < worstStringWorkload.getWorkload().length; i=i+2 ){
            if(worstStringWorkload.getWorkload()[i].compareTo(worstStringWorkload.getWorkload()[i+1]) == 1){
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
        for( int i = 0; i < averageStringWorkload.getWorkload().length; i=i+2 ){
            if(averageStringWorkload.getWorkload()[i].compareTo(averageStringWorkload.getWorkload()[i+1]) == 1){
                exchangesA++;
            }
        }
        for( int i = 0; i < worstStringWorkload.getWorkload().length; i=i+2 ){
            if(worstStringWorkload.getWorkload()[i].compareTo(worstStringWorkload.getWorkload()[i+1]) == 1){
                exchangesW++;
            }
        }
        assertTrue(exchangesA < exchangesW);
    }

    @Test
    void getWorkload(){
        System.out.println("Get Workload");
        StringWorkload getWorkloadTest = new StringWorkload(1, 100);
        Workload workloadTest = new Workload(getWorkloadTest);
        assertEquals(getWorkloadTest.getWorkload(),workloadTest.getStringWorkload().getWorkload());
    }
}
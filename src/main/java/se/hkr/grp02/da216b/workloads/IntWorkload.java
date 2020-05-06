package se.hkr.grp02.da216b.workloads;

import java.security.SecureRandom;
import java.util.Arrays;

public class IntWorkload {
    private int[] workload;

    public IntWorkload(int caseLevel, int size) {
       if (caseLevel == 1){
           averageCase(size);
       }else if(caseLevel == 2){
           worstCase(size);
       }else{
           try {
               throw new IllegalAccessException("Wrong case scenario");
           } catch (IllegalAccessException e) {
               e.printStackTrace();
           }
       }
    }
    public void averageCase(int size){
        this.workload = new int[size];
        for (int i = 0; i < size; i++){
            workload[i] = new SecureRandom().nextInt(1000);
        }
    }
    public void worstCase(int size){
        this.workload = new int[size];
        for (int i = 0; i < workload.length; i++){
           // x = new SecureRandom().nextInt(1000);
            workload[i] = --size;
        }
    }

    public int[] getWorkload() {
        return workload;
    }
}

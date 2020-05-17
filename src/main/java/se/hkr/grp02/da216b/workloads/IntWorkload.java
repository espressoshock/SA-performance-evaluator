package se.hkr.grp02.da216b.workloads;

import java.security.SecureRandom;
import java.util.Arrays;

public class IntWorkload {
    private int[] workload;
    private String caseName;

    public IntWorkload(int caseLevel, int size) {
       if (caseLevel == 1){
           caseName = "Average_Case";
           averageCase(size);
       }else if(caseLevel == 2){
           caseName = "Worst_Case";
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
            workload[i] = new SecureRandom().nextInt(size);
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

    public Integer[] getIntegerWorkload(){
        Integer[] wrapper = new Integer[this.workload.length];
        for (int i = 0; i < wrapper.length; i++){
            wrapper[i] = workload[i];
        }
        return wrapper;
    }

    public String getCaseName() {
        return caseName;
    }
}

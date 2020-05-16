package se.hkr.grp02.da216b.workloads;

import java.security.SecureRandom;

public class StringWorkload {
    private String[] workload;
    private String caseName;
    public StringWorkload(int caseLevel, int size) {
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
        this.workload = new String[size];
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 5;
        for (int j = 0; j<workload.length; j++){
            StringBuilder buffer = new StringBuilder(targetStringLength);
            for (int i = 0; i < targetStringLength; i++) {
                int randomLimitedInt = leftLimit + (int)
                        (new SecureRandom().nextFloat() * (rightLimit - leftLimit + 1));
                buffer.append((char) randomLimitedInt);
            }
            workload[j] = buffer.toString();
        }
    }
    public void worstCase(int size){
        this.workload = new String[size];
        int leftLimit = 72;
        int rightLimit = 122;
        int targetStringLength = 15;
        int firstLetter = 122;
        for (int j = 0; j<workload.length; j++){
            StringBuilder buffer = new StringBuilder(targetStringLength);
            if(firstLetter>96){
                buffer.append((char) firstLetter);
                firstLetter--;
            }else {
                firstLetter=122;
            }
            for (int i = 1; i < targetStringLength; i++) {
                int randomLimitedInt = leftLimit + (int)
                        (new SecureRandom().nextFloat() * (rightLimit - leftLimit + 1));
                buffer.append((char) randomLimitedInt);
            }
            workload[j] = buffer.toString();
        }
    }

    public String[] getWorkload() {
        return workload;
    }

    public String getCaseName() {
        return caseName;
    }
}

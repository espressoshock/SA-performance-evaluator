package se.hkr.grp02.da216b.utilities;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import se.hkr.grp02.da216b.HIBDB.ECRTLEntry;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

/**
 * Exporter class exports given ECRTLEntry list to an .xls file
 */
public class Exporter {
    String fileName = "SAevaluator"; //DefaultName

    public void exportToExcel(List<ECRTLEntry> list) {
        Workbook wb = new HSSFWorkbook();
        Sheet sheet = wb.createSheet("Average case");
        Sheet sheet2 = wb.createSheet("Worst case");
        Row row = sheet.createRow(0);
        Row row1 = sheet2.createRow(0);
        //Sheet 1 ///////////////////////////////
        Cell cell = row.createCell(0);
        cell.setCellValue("Algorithm name");
        Cell cell2 = row.createCell(1);
        cell2.setCellValue("Workload type");
        Cell cell3 = row.createCell(2);
        cell3.setCellValue("Case");
        Cell cell4 = row.createCell(3);
        cell4.setCellValue("Workload size");
        Cell cell5 = row.createCell(4);
        cell5.setCellValue("Time(nanosec)");
        //Sheet 1 ///////////////////////////////
        //Sheet 2 ///////////////////////////////
        cell = row1.createCell(0);
        cell.setCellValue("Algorithm name");
        cell2 = row1.createCell(1);
        cell2.setCellValue("Workload type");
        cell3 = row1.createCell(2);
        cell3.setCellValue("Case");
        cell4 = row1.createCell(3);
        cell4.setCellValue("Workload size");
        cell5 = row1.createCell(4);
        cell5.setCellValue("Time(nanosec)");
        //Sheet 2 ///////////////////////////////
        int avgCount = 0;
        int wrstCount = 0;
        for (ECRTLEntry x : list) {
            if (x.getTargetlang().equals("Average_Case")) {
                avgCount = getStrCount(sheet, avgCount, x);
            } else {
                wrstCount = getStrCount(sheet2, wrstCount, x);
            }
        }
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter a filename to save as excel: ");
        fileName = scanner.nextLine();
        try (FileOutputStream outputStream = new FileOutputStream("exports/"+fileName + ".xls")) {
            wb.write(outputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private int getStrCount(Sheet sheet2, int strCount, ECRTLEntry x) {
        Row row;
        Cell cell;
        Cell cell2;
        Cell cell3;
        Cell cell4;
        Cell cell5;
        row = sheet2.createRow(++strCount);
        cell = row.createCell(0);
        cell.setCellValue(x.getAlgorithmFK());
        cell2 = row.createCell(1);
        cell2.setCellValue(x.getTargetOS());
        cell3 = row.createCell(2);
        cell3.setCellValue(x.getTargetlang());
        cell4 = row.createCell(3);
        cell4.setCellValue(x.getWorkload());
        cell5 = row.createCell(4);
        cell5.setCellValue(x.getRtrResult());
        return strCount;
    }
}


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment;

/**
 *
 * @author Emil
 */
import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadFile {

    public double[][] getData(String path, int size) {
        double[][] dataset = new double[size][size];
        int i, j;
        try {

            i = 0;
            j = 0;
            File file = new File(path);   //creating a new file instance  
            FileInputStream fis = new FileInputStream(file);   //obtaining bytes from the file  
//creating Workbook instance that refers to .xlsx file  
            XSSFWorkbook wb = new XSSFWorkbook(fis);
            XSSFSheet sheet = wb.getSheetAt(0);     //creating a Sheet object to retrieve object  
            Iterator<Row> itr = sheet.iterator();    //iterating over excel file  
            while (itr.hasNext()) {
                j = 0;
                Row row = itr.next();
                Iterator<Cell> cellIterator = row.cellIterator();   //iterating over each column

                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();
                    dataset[i][j] = cell.getNumericCellValue();
                    System.out.print(dataset[i][j] + " ");
                    j++;
                }
                i++;
                System.out.println("");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dataset;
    }

    public String[][] getStringData(String path, int size) {
        String[][] dataset = new String[size][size];
        int i, j;
        try {

            i = 0;
            j = 0;
            File file = new File(path);   //creating a new file instance  
            FileInputStream fis = new FileInputStream(file);   //obtaining bytes from the file  
//creating Workbook instance that refers to .xlsx file  
            XSSFWorkbook wb = new XSSFWorkbook(fis);
            XSSFSheet sheet = wb.getSheetAt(0);     //creating a Sheet object to retrieve object  
            Iterator<Row> itr = sheet.iterator();    //iterating over excel file  
            while (itr.hasNext()) {
                j = 0;
                Row row = itr.next();
                Iterator<Cell> cellIterator = row.cellIterator();   //iterating over each column

                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();
                    dataset[i][j] = String.valueOf(cell.getNumericCellValue());
                    System.out.print(dataset[i][j] + " ");
                    j++;
                }
                i++;
                System.out.println("");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dataset;
    }

    public String[] getColumn(String path, int size) {
        String[] dataset = new String[size];
        int i, j;
        try {
            i = 0;
            j = 0;
            File file = new File(path);   //creating a new file instance  
            FileInputStream fis = new FileInputStream(file);   //obtaining bytes from the file  
//creating Workbook instance that refers to .xlsx file  
            XSSFWorkbook wb = new XSSFWorkbook(fis);
            XSSFSheet sheet = wb.getSheetAt(0);     //creating a Sheet object to retrieve object  
            Iterator<Row> itr = sheet.iterator();    //iterating over excel file  
            while (itr.hasNext()) {
                j = 0;
                Row row = itr.next();
                Iterator<Cell> cellIterator = row.cellIterator();   //iterating over each column

                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();
                    dataset[i] = cell.getStringCellValue();
                    //System.out.print(dataset[i][j] + " ");
                    j++;
                }
                i++;
//                System.out.println("");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dataset;
    }

}

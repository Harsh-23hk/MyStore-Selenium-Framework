package Utilities;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

public class ReaderDDT {

    public static XSSFWorkbook workbook;
    public static XSSFSheet excelSheet;
    public static XSSFRow row;
    public static XSSFCell cell;
    public static FileInputStream fileInputStream;

    public static int getColCount(String fileName, String sheetName) throws IOException {

        fileInputStream = new FileInputStream(fileName);
        workbook = new XSSFWorkbook(fileInputStream);
        excelSheet = workbook.getSheet(sheetName);
        row = excelSheet.getRow(0);
        int cell = row.getLastCellNum();
        workbook.close();
        return cell;


    }


    public static int getRowCount(String fileName, String sheetName) throws IOException {

        fileInputStream = new FileInputStream(fileName);
        workbook = new XSSFWorkbook(fileInputStream);
        excelSheet = workbook.getSheet(sheetName);
        int row = excelSheet.getLastRowNum() + 1;
        workbook.close();
        return row;


    }

    public static String getCellValue(String fileName, String sheetName, int rowNo, int cellNo) throws IOException {

        fileInputStream = new FileInputStream(fileName);
        workbook = new XSSFWorkbook(fileInputStream);
        excelSheet = workbook.getSheet(sheetName);
        cell = excelSheet.getRow(rowNo).getCell(cellNo);
        workbook.close();


        return cell.getStringCellValue();
    }


}

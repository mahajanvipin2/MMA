/*package com.actual.appiumapplication;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class call_excel
{
    @Test
    public String read_excel() throws IOException
    {
        FileInputStream fis = new FileInputStream("C:\\input_File_Selenium/Appium_excel.xlsx");
        XSSFWorkbook workbook=new XSSFWorkbook(fis);
        XSSFSheet sheet= workbook.getSheet("input");
        XSSFRow row=sheet.getRow(1);
        XSSFCell cell=row.getCell(0);
        String value= String.valueOf(cell.getStringCellValue());
        return value;
    }

}
*/
package com.test.base;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class TestUtils {
	
	static String basePath = System.getProperty("user.dir");
	
	XSSFWorkbook wbook;
	XSSFSheet sheet;
	
	public TestUtils() {
		
		try {
			File source = new File(basePath+"/resources/testData.xlsx");
			FileInputStream fis = new FileInputStream(source);
			wbook = new XSSFWorkbook(fis);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String readExcelFile(String sheetName, int row, int column) {
		sheet = wbook.getSheet(sheetName);
		String data = sheet.getRow(row).getCell(column).getStringCellValue();
		return data;
	}
	
	public int getRowCount(String sheetName) {
		int rowCount = sheet.getLastRowNum();
		rowCount+=1;
		return rowCount;
	}
}

package com.practice;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class XlRecap {

	@Test
	public void read() throws IOException {
		String filePath=System.getProperty("user.dir")+"/src/test/resources/testdata/HrmsTestData.xlsx";
		FileInputStream fis = new FileInputStream(filePath);
		Workbook wbook = new XSSFWorkbook(fis);
		Sheet sheet = wbook.getSheet("Login");
		String value1 = sheet.getRow(1).getCell(0).toString();
		System.out.println(value1);
		// how to find number of rows and cols?
		int rows = sheet.getPhysicalNumberOfRows();
		int cols = sheet.getRow(0).getLastCellNum();

		System.out.println(rows);
		System.out.println(cols);

		//how to read data from excel and store it inside 2D array
		//creating object to store data from 3 rows (eliminate header)
		Object[][] data=new Object[rows-1][cols];
//		data[0][0]="Hello";
//		data[0][1]="Hello1"
//		//------------------
//		data[1][0]="Bye";
//		data[1][1]="Bye1";
		//looping from 2 row of excel (eliminate header)
		for (int i = 1; i < rows; i++) {
			//looping from 1 column in excel
			for (int y = 0; y < cols; y++) {
				//retrieve value from excel by specified row and column
				String value = sheet.getRow(i).getCell(y).toString();
				System.out.println(value);
				//storing retrived data into 2D object array
				data[i-1][y]=value;
			}
		}
		
		wbook.close();
		fis.close();
		System.out.println("Values from 2d Array----------------------");
		for(Object[] rowArray :data) {
			for (Object d: rowArray) {
				System.out.println(d);
			}
		}
	}
}
package com.utility;

import java.io.File;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFName;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class readingData {
	
	public static void main(String args[]) {
	
	
//	@DataProvider(name = "getdata")
//	public void getdata() throws {
//		File xlsxfile  =  new File(System.getProperty("user.dir") + "//testData//LoginExcel.xlsx");
//		XSSFWorkbook workbook = new XSSFWorkbook(xlsxfile);
//		XSSFSheet sheet =workbook.getSheet("data");
//		int totalRow = sheet.getLastRowNum();
//		XSSFRow myHeader = sheet.getRow(0);
//		int  totalcell = myHeader.getLastCellNum();
//		System.out.println("Last Index of Row is" + totalRow);
//		System.out.println("total Number of Cols is " + totalcell);
//		String myData[][] = new String[totalRow][totalcell];
//		XSSFRow myRow;
//		XSSFCell cell;
//		for (int rowIndex = 1; rowIndex <= totalRow; rowIndex++) {
//			for (int colIndex = 0; colIndex < totalcell; colIndex++) {
//				myRow = sheet.getRow(rowIndex);
//				 cell=myRow.getCell(colIndex);
//				 myData[rowIndex - 1][colIndex] = cell.getStringCellValue();
//		
//	}
//		}
//	}
//}
}
}

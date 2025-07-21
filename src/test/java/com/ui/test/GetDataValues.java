package com.ui.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class GetDataValues {

	 @DataProvider(name = "getData")
	    public Object[][] getData() throws Exception {
	        return readExcelData1();
	    }

	
	public static String[][] readExcelData() throws Exception, IOException  {
		File xlsxfile  =  new File(System.getProperty("user.dir") + "//testData//LoginData.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(xlsxfile);
		XSSFSheet sheet =workbook.getSheet("loginTestData");
		int totalRow = sheet.getLastRowNum();
		XSSFRow myHeader = sheet.getRow(0);
		int  totalcell = myHeader.getLastCellNum();
		System.out.println("Last Index of Row is" + totalRow);
		System.out.println("total Number of Cols is " + totalcell);
		String myData[][] = new String[totalRow][totalcell];
		XSSFRow myRow;
		XSSFCell cell;
		for (int rowIndex = 1; rowIndex <= totalRow; rowIndex++) {
			for (int colIndex = 0; colIndex < totalcell; colIndex++) {
				myRow = sheet.getRow(rowIndex);
				
				 cell=myRow.getCell(colIndex);
				
				 myData[rowIndex - 1][colIndex] = cell.getStringCellValue();
		
	}
			
		}
		String data = null;
		for (String[] row : myData) {
		   data = Arrays.toString(row);
		  // System.out.println(data);
		}
		return myData;
	}
	
	
	public static Object[][] readExcelData1() throws IOException {
	    File xlsxFile = new File(System.getProperty("user.dir") + "/testData/LoginData.xlsx");
	    FileInputStream fis = new FileInputStream(xlsxFile);
	    XSSFWorkbook workbook = new XSSFWorkbook(fis);
	    XSSFSheet sheet = workbook.getSheet("loginTestData");

	    int totalRow = sheet.getLastRowNum();
	    XSSFRow headerRow = sheet.getRow(0);
	    int totalCell = headerRow.getLastCellNum();

	    // Temporary list to hold only valid rows
	    List<String[]> validData = new ArrayList<>();

	    for (int rowIndex = 1; rowIndex <= totalRow; rowIndex++) {
	        XSSFRow currentRow = sheet.getRow(rowIndex);
	        if (currentRow == null) continue;

	        String[] rowData = new String[totalCell];
	        boolean skipRow = false;
	        boolean skipcell = false;

	        for (int colIndex = 0; colIndex < totalCell; colIndex++) {
	            XSSFCell cell = currentRow.getCell(colIndex);
	            if (cell == null || cell.getCellType() == CellType.BLANK) {
	                skipRow = true; // skip if any cell is blank
	                break;
	            }

	            String cellValue = cell.getStringCellValue().trim();
	            if (cellValue.equalsIgnoreCase("N")) {
	            	skipcell = true; // skip if any cell has "N"
	                break;
	            }

	            rowData[colIndex] = cellValue;
	        }

	        if (!skipRow) {
	            validData.add(rowData);
	        }
	    }

	    workbook.close();

	    // Convert List<String[]> to String[][]
	    Object[][] finalData = new String[validData.size()][totalCell];
	    return validData.toArray(finalData);


}
}

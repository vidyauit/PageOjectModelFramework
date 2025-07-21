package com.utility;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.ui.pojo.User;

public class ExcelReaderUtility {
	public static Iterator<User> excelReader(String fileName) throws InvalidFormatException, IOException {
	   
	   File xlsxfile  =  new File(System.getProperty("user.dir") + "\\TestData\\"+fileName);
	   //  System.out.println(xlsxfile);
	   List<User>userList = new ArrayList<User>();
	   
		XSSFWorkbook workbook = new XSSFWorkbook(xlsxfile);		
	    XSSFSheet XSSFSheet = workbook.getSheet("loginTestData");
	    Iterator<Row> rowIterator = XSSFSheet.iterator();
	    Row row ;
	    Cell emailAddressCell;
	    Cell password;
	    User user;
	    rowIterator.next();
	    while(rowIterator.hasNext()) {
	    	row= rowIterator.next();
	    	 emailAddressCell = row.getCell(0);
	    	password = row.getCell(1);
	    	user= new User(emailAddressCell.toString(), password.toString());
	    	userList.add(user);
	    	
	    }
	    System.out.println(userList);
	    workbook.close();
	   return userList.iterator();
   }
	
	public static void getData(String fileName) throws InvalidFormatException, IOException {
		File xlsxfile  =  new File(System.getProperty("user.dir") + "\\TestData\\"+fileName);
		XSSFWorkbook workbook = new XSSFWorkbook(xlsxfile);		
	    XSSFSheet XSSFSheet = workbook.getSheet("loginTestData");
	    XSSFSheet.getLastRowNum();
	    
	}
}

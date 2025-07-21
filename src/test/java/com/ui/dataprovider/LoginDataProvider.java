package com.ui.dataprovider;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.DataProvider;

import com.google.gson.Gson;
import com.ui.pojo.TestData;
import com.ui.pojo.User;
import com.utility.CSVReaderUtility;
import com.utility.ExcelReaderUtility;

public class LoginDataProvider {
	   
	@DataProvider(name="loginTestDataProvider")
		public Iterator<Object[]> logiDataProvider() throws FileNotFoundException {
			Gson json = new Gson();
			File testDataFile = new File (System.getProperty("user.dir")+ "\\testData\\loginData.json");
				FileReader fileReader = new FileReader(testDataFile);
				TestData data = json.fromJson(fileReader, TestData.class);
				List<Object[]>dataToReturn = new ArrayList<Object[]>();
				for(User user:data.getData()) {
					System.out.println("?***************************");
					System.out.println(user.getEmailAddress()+"and "+user.getPassword());
					dataToReturn.add(new Object[] {user});
					
				}
				
			return dataToReturn.iterator();
			
		}
		
		@DataProvider(name="loginCSVDataprovider")
		public Iterator<User> loginCSVDataprovider() {
			return CSVReaderUtility.readCSVFile("loginData.csv");
		}
	
		@DataProvider(name="loginSSFXDataprovider")
		public Iterator<User> loginSSFXDataprovider() throws InvalidFormatException, IOException {
			return ExcelReaderUtility.excelReader("loginData.xlsx");
		}
		
		
}


package com.utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import com.ui.pojo.User;

public class CSVReaderUtility {

	public static Iterator<User> readCSVFile(String fileName) {
		// TODO Auto-generated method stub
		
		File file = new File(System.getProperty("user.dir") +"\\TestData\\"+ fileName);
		FileReader filereader=null;
		CSVReader csvReader;
		String[] data;
		List<User> userList=null;
		try {
			filereader = new FileReader(file);
			csvReader = new CSVReader(filereader);
			csvReader.readNext();//Readthe column name Row 1 
			userList = new ArrayList<User>();
			User user ;
			while((data = csvReader.readNext())!= null) {
				user= new User(data[0],data[1]);
				userList.add(user);
			}
			
			for(User userData: userList) {
				System.out.println(userData);
			}
			
			//System.out.println(Arrays.toString(data));
		} 
		catch (FileNotFoundException e) {
			// TODO: handle exception
		}
		catch (IOException | CsvValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userList.iterator();
      
     
	}

}

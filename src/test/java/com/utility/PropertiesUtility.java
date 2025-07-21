package com.utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import com.constant.ENV;

public class PropertiesUtility {
	
	public static String readProperty(ENV env,String propertyName) {
		System.out.println(System.getProperty("user.dir"));
		File file = new File(System.getProperty("user.dir")+"\\config\\"+ env + ".properties");
		System.out.println(file);
		FileReader filereader =null;
		Properties prop = new Properties();
		 try {
			filereader = new FileReader(file);
			prop.load(filereader);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 String value= prop.getProperty(propertyName);
		 System.out.println(value);
		 return value;
	}

}

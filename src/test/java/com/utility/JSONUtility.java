package com.utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import com.google.gson.Gson;
import com.ui.pojo.Config;
import com.ui.pojo.Envirnoment;

public class JSONUtility {
	
	public static void main(String[] args)  {
    	   Gson gson = new Gson();
    	   File fileJson = new File(System.getProperty("user.dir")+"\\config\\config.json");
    	   try {
			FileReader filereader = new FileReader(fileJson);
			Config config = gson.fromJson(filereader, Config.class);
			Envirnoment envirn = config.getEnvirnomnet().get("QA");
			System.out.println(envirn.getUrl());
			//System.out.println(envirn.toString());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       }
}

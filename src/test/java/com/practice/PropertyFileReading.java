package com.practice;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.Test;

public class PropertyFileReading {

	Properties prop;
	
	@Test
	public void read() {
		String filePath=System.getProperty("user.dir")+"/src/test/java/com/practice/Example.properties";
	
		try {
			FileInputStream fis=new FileInputStream(filePath);
			prop=new Properties();
			prop.load(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		String value=prop.getProperty("company");
		System.out.println(value);
	}
}
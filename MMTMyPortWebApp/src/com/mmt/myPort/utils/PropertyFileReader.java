package com.mmt.myPort.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyFileReader {
	
	private Properties prop = null;
	public String getProperty(String key){
		InputStream input = null;
		String value=null;	
		try {
			 this.prop = new Properties();
			 input = this.getClass().getResourceAsStream("/dbprops.properties");
	         prop.load(input);
			 value = prop.getProperty(key);
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return value;
	}
}

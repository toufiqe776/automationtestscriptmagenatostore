package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;



public class ReadConfig {

	Properties properties;

	String path = "D:\\AutomationMagento\\AutomationTestScriptMagenato\\Configuration\\config.properties";

	//constructor
	public ReadConfig() {
		try {
			properties = new Properties();

			FileInputStream  fis = new FileInputStream(path);
			properties.load(fis);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}
	public String getBaseUrl()
	{
		String value = properties.getProperty("baseUrl");

		if(value!=null)
			return value;
		else
			throw new RuntimeException("url not specified in config file.");

	}

	public String getBrowser()
	{
		String value = properties.getProperty("browser");

		if(value!=null)
			return value;
		else
			throw new RuntimeException("url not specified in config file.");

	}
	
	

}

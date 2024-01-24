package Factory;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;

public class BaseClass {
	public static WebDriver driver;
	static Properties p;
 
	public static Properties propertiesfile() throws IOException 
	{
		FileReader file=new FileReader(".\\src\\test\\resources\\propertyfile.properties");
		 p=new Properties();
         p.load(file);
		return p;
		
	}
	public static WebDriver getdriver()
	    {    
		 return driver;
		}
	public static String random_alphabet() {
		String randomstring=RandomStringUtils.randomAlphabetic(5);
		return randomstring;
	}
	public static String Random_number() {
		String randomnumber=RandomStringUtils.randomNumeric(10);
		return randomnumber;	
	}
	public static String Random_alphanumeric() {
		String randomAlphanumeric=RandomStringUtils.randomAlphabetic(3)+"@"+RandomStringUtils.randomNumeric(3);
		return randomAlphanumeric;
	}
	
}

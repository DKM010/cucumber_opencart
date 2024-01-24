package Test_definition_files;

import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import Factory.BaseClass;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks{
public static WebDriver driver;
Properties p;
@Before
public void setup() throws IOException 
{
	driver=BaseClass.getdriver();
	p=BaseClass.propertiesfile();
	if(p.getProperty("Execution_env").equals("remote")) 
	{
		DesiredCapabilities capability=new DesiredCapabilities();
		if(p.getProperty("os").equals("windows"))
		{
			capability.setPlatform(Platform.WIN11);
		}
		else if(p.getProperty("os").equals("mac"))
		{
			capability.setPlatform(Platform.MAC);
		}
		else
		{
		System.out.println("os not found");
		}
		
		if(p.getProperty("Browser").equals("chrome"))
		{
			capability.setBrowserName("chrome");
		}
		else if(p.getProperty("Browser").equals("firefox"))
		{
			capability.setBrowserName("firefox");
		}
		else {System.out.println("browser not matched");}
		driver=new RemoteWebDriver(capability); 
	}
	else if(p.getProperty("Execution_env").equals("local"))
{
	if(p.getProperty("Browser").equals("chrome"))
	{
		driver=new ChromeDriver();
	}
	else if(p.getProperty("Browser").equals("firefox")) {
		driver=new FirefoxDriver();
	}
	else if (p.getProperty("Browser").equals("edge"))
	{
        driver=new EdgeDriver();
	}
	else{ System.out.println("browser not matched");
	Assert.fail();
	}
}
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.get(p.getProperty("URL"));
	
}
@After
public void exit() {
driver.quit();
}

@AfterStep
public void takescreenshot(Scenario scenario) {
	if(scenario.isFailed()) {
	TakesScreenshot s_shot=(TakesScreenshot)driver;	
	byte[] screen_shot=s_shot.getScreenshotAs(OutputType.BYTES);
	scenario.attach(screen_shot,"image/png",scenario.getName());
	}
}
}

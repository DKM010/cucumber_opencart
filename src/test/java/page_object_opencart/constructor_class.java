package page_object_opencart;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class constructor_class {
	public WebDriver driver;
	
public constructor_class(WebDriver driver) {
	
	this.driver=driver;
	PageFactory.initElements(driver, this);
}
}

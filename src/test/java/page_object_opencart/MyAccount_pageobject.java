package page_object_opencart;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccount_pageobject extends constructor_class{
	public MyAccount_pageobject(WebDriver driver) {
		super(driver);
	}
	static @FindBy(xpath="//h2[text()='My Account']") WebElement myAccount;
	static @FindBy(xpath="//a[@class='list-group-item'][normalize-space()='Logout']") WebElement logout;
public boolean Myaccount() {
	try {
boolean Myaccount=myAccount.isDisplayed();
return Myaccount;
	}
	catch(Exception e)
	{
		return false;
	}
	
}
public void logout() {
	logout.click();
}
}

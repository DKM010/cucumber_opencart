package page_object_opencart;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Homepage_object extends constructor_class {
	

public Homepage_object(WebDriver driver) {
		super(driver);
		
	}
@FindBy(xpath="//span[normalize-space()='My Account']") WebElement myAccount;
@FindBy(xpath="//a[normalize-space()='Register']") WebElement register;

@FindBy(xpath="//a[@class='dropdown-item'][normalize-space()='Login']") WebElement login;

public void click_on_myaccount() {
	myAccount.click();
}
public void click_on_register() {
	register.click();
	
}
public void click_on_login() {
	login.click();
}
}

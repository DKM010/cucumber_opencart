package page_object_opencart;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class loginpage_object extends constructor_class{

	public loginpage_object(WebDriver driver) {
		super(driver);
	}
@FindBy(xpath="//input[@id='input-email']") WebElement Email;
@FindBy(xpath="//input[@id='input-password']") WebElement Password;
@FindBy(xpath="//button[normalize-space()='Login']") WebElement Login;
public void enter_emailid(String email) {
	Email.sendKeys(email);
	
}
public void enter_password(String password) {
	Password.sendKeys(password);
}
public void click_on_login() {
	Login.click();
}
}


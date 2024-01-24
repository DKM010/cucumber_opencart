package page_object_opencart;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class registration_pageobject extends constructor_class {
	JavascriptExecutor js=(JavascriptExecutor)driver;

	public registration_pageobject(WebDriver driver) {
		super(driver);	
	}

@FindBy(xpath="//input[@id='input-lastname']") WebElement lastName;
@FindBy(xpath="//input[@id='input-firstname']") WebElement firstName;
@FindBy(xpath="//input[@id='input-email']") WebElement eMail;
@FindBy(xpath="//input[@id='input-password']") WebElement password;
@FindBy(xpath="//input[@name='agree']") WebElement agree;
@FindBy(xpath="//button[normalize-space()='Continue']") WebElement submit;

public void Enter_1st_name(String firstname) {

firstName.sendKeys(firstname);

} 
public void Enter_2nd_name(String lastname ) {
	lastName.sendKeys(lastname);
}
public void Enter_email(String gmail) {
	eMail.sendKeys(gmail);
}
public void Enter_password(String Password) {

password.sendKeys(Password);

}
public void click_on_checkbox() {
js.executeScript("arguments[0].click();",agree);
}
public void click_on_submit(){
	//submit.click();
	js.executeScript("arguments[0].click();",submit);
}
}

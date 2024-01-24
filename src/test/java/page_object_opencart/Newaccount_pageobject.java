package page_object_opencart;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Newaccount_pageobject extends constructor_class{

	public Newaccount_pageobject(WebDriver driver) {
		super(driver);
	}

@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']") WebElement yourAccountHasBeenCreated;
public boolean new_account() {
	boolean newaccount=yourAccountHasBeenCreated.isDisplayed();
	return newaccount;
}
}

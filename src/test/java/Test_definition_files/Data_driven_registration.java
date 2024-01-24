package Test_definition_files;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import Factory.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import page_object_opencart.Homepage_object;
import page_object_opencart.Newaccount_pageobject;
import page_object_opencart.registration_pageobject;

public class Data_driven_registration {
	WebDriver driver;
	registration_pageobject rp;
	JavascriptExecutor js=(JavascriptExecutor)driver;
	@Given("the user on the registration page")
	public void the_user_on_the_registration_page() throws IOException {
		driver=Hooks.driver;
		Homepage_object ho=new Homepage_object(driver);
		ho.click_on_myaccount();
		ho.click_on_register();
	}

	@When("the user entered random data from Randomstringutils class")
	public void the_user_entered_random_data_from_randomstringutils_class() {
		rp=new registration_pageobject(driver); 
		rp.Enter_1st_name(BaseClass.random_alphabet().toLowerCase());
		rp.Enter_2nd_name(BaseClass.random_alphabet().toLowerCase());
		rp.Enter_email(BaseClass.random_alphabet().toLowerCase()+"@gmail.com");
		rp.Enter_password(BaseClass.Random_alphanumeric().toLowerCase());
	}

	@When("the user clicked on checkbox")
	public void the_user_clicked_on_checkbox() {
	rp.click_on_checkbox();
	}

	@When("the user clicked on submit button")
	public void the_user_clicked_on_submit_button() {
	  rp.click_on_submit();  
	}

	@Then("the user account should get created")
	public void the_user_account_should_get_created() {
		Newaccount_pageobject np=new Newaccount_pageobject(driver);  
		
	Assert.assertEquals(true,np.new_account());
	}



}

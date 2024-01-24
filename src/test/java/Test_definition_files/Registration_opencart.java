package Test_definition_files;

import java.util.Map;


import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import Factory.BaseClass;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import page_object_opencart.Homepage_object;
import page_object_opencart.Newaccount_pageobject;
import page_object_opencart.registration_pageobject;

public class Registration_opencart{
	WebDriver driver;
	registration_pageobject rpg;
@Given("the user navigates to Register Account page")
public void the_user_navigates_to_register_account_page() {
	driver=Hooks.driver;
	Homepage_object ho=new Homepage_object(driver);
	ho.click_on_myaccount();
	ho.click_on_register();
}

@When("the user enters the details from the below fields")
public void the_user_enters_the_details_from_the_below_fields(DataTable dataTable) {
	Map< String,String > datamap=dataTable.asMap(String.class,String.class);
	 rpg=new registration_pageobject(driver);
	rpg.Enter_1st_name(datamap.get("firstName"));
    rpg.Enter_2nd_name(datamap.get("lastName"));
    rpg.Enter_email(datamap.get("gmail"));
    rpg.Enter_password(datamap.get("password"));
}

@When("the user selects Privacy Policy")
public void the_user_selects_privacy_policy() {
	rpg.click_on_checkbox();
}

@When("the user clicks on Continue button")
public void the_user_clicks_on_continue_button() throws InterruptedException {
 rpg.click_on_submit();   
}

@Then("the user account should get created successfully")
public void the_user_account_should_get_created_successfully() {
	Newaccount_pageobject np=new Newaccount_pageobject(driver);   
Assert.assertEquals(true,np.new_account() );
}



}

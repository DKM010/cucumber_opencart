package Test_definition_files;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.junit.Assert;

import Utilities.DataReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import page_object_opencart.Homepage_object;
import page_object_opencart.MyAccount_pageobject;
import page_object_opencart.loginpage_object;

public class login_opencart {
	loginpage_object lio=new loginpage_object(Hooks.driver);
	MyAccount_pageobject mp=new MyAccount_pageobject(Hooks.driver);	
	Homepage_object hp=new Homepage_object(Hooks.driver); 
	 List<HashMap <String,String>>  celldata;
	 int new_index;
	@Given("the user on the login page")
	public void the_user_on_the_login_page() {
		
		hp.click_on_myaccount();
		hp.click_on_login();
	}
@When("user enters email as {string} and password as {string}")
	    public void user_enters_email_as_and_password_as(String email, String pwd) {
	    	lio.enter_emailid(email);
	    	lio.enter_password(pwd);
	
}

@When("the user clicked on the login button")
public void the_user_clicked_on_the_login_button() {
lio.click_on_login();  
}

	
	@Then("login should be successfull")
	public void login_should_be_successfull() {
		if(mp.Myaccount()==true) {
		Assert.assertTrue(true);
		}else {Assert.fail();}
		}
	
	
	                               //DATA DRIVEN TESTING USING EXCEL SHEET
	@Then("the user redirected to myaccount page by entering the data by passing the index value as  {string}")
	public void the_user_redirected_to_myaccount_page_by_entering_the_data_by_passing_the_index_value_as(String index)throws IOException 
	{
	   new_index=Integer.parseInt(index)-1;
	   String path="C:\\eclipse\\Opencart_cucumber\\Test_data\\Copy of Opencart_LoginData.xlsx";
	   celldata=DataReader.data(path,"Sheet1");
	   lio.enter_emailid(celldata.get(new_index).get("username"));
	   lio.enter_password(celldata.get(new_index).get("password"));
	   lio.click_on_login();
	
	  if(celldata.get(new_index).get("result").equalsIgnoreCase("valid")) 
	  {
		if(mp.Myaccount()==true)
			{
			Assert.assertTrue(true);
			}
		else {
			Assert.fail("due to login fail with valid data");
			 }
		
	  }
	  if(celldata.get(new_index).get("result").equalsIgnoreCase("invalid")) 
	  {
		if(mp.Myaccount()==false)
		{
			Assert.assertTrue(true);
		}
		else 
		{
			
			Assert.fail("due to login successfull with invalid data");
			
		}	  
	  }
	}
	
}




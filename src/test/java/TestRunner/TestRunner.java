package TestRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(//features={".\\Feature_files"},
                 //features= {"C:\\eclipse\\Opencart_cucumber\\Feature_files\\register.feature"},
		         features= {"C:\\eclipse\\Opencart_cucumber\\Feature_files\\DDT_login.feature"},
		         //features={"C:\\eclipse\\Opencart_cucumber\\Feature_files\\login_Opencart.feature"},
		         //features= {"target/rerun.txt"},
                  glue="Test_definition_files",
                  plugin= {"pretty", "html:reports/myreport.html","rerun:target/rerun.txt"},
                  dryRun=false,
                  monochrome=true
                  
                  
                        
		         )
public class TestRunner {

}

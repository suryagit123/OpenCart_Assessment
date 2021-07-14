package RunnerTest;
import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

	
	

	@RunWith(Cucumber.class)
	@CucumberOptions(features="src/test/java/Features",glue= {"Step_Definition"})
	public class Test_Cucumber {
		
	}




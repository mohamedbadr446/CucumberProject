package CucumberFramwork1.runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
	features = {"src/test/java/CucumberFramwork1/featureFiles/"},
	glue = {"CucumberFramwork1.stepFiles"},
	plugin = {"pretty","html:target/cucumber",
			"json:target/cucumber.json",
			"com.cucumber.listener.ExtentCucumberFormatter:target/report.html"
			}
)
public class MainRunner {

}

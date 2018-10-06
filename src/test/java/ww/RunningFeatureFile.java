package ww;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;

import cucumber.api.junit.*;

@RunWith(Cucumber.class)
@CucumberOptions(format = { "pretty", "html:target/test-report", "json:target/test-report.json",
		"junit:target/test-report.xml" }, features = {

				// this for login page
				"src/test/BDD/Testing_Valid_Zipcode_search_result.feature",

})

public class RunningFeatureFile {

}

package runner;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
//import io.cucumber.junit.Cucumber;
import cucumber.api.junit.Cucumber;


@RunWith(Cucumber.class)
@CucumberOptions(features="features",
glue= {"stepDefinition"},
plugin= {"pretty","html:target/htmlreports"
		}
	)

public class RunnerClass {

}

package todo.api.test;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features={"src/"}
        ,glue =  "todo.api.test.stepdefinations"
        ,plugin = {"html:target/cucumber-report/cucumber-reports","pretty",
        "html:target/cucumber-report/cucumber-preety",
        "json:target/cucumber-report/cucumber.json"
        }
)
public class TestRunner
{
}

package SwagLabs_Mobile;

import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
        features = {"src/test/resources/features"},
        glue = {"SwagLabs_Mobile","stepDefinitions"},
        plugin = {
                "pretty",
                "html:target/report-cucumber.html",
                "json:target/cucumber-json.json"
        }
)
public class TestRunner extends AbstractTestNGCucumberTests {

}

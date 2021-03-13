package serenity.JiraAPI.cucumber;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import serenity.JiraAPI.testbase.Init;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/java/serenity/JiraAPI/resources/Feature/" , glue = "serenity.JiraAPI.cucumber.steps")
public class TestRunner extends Init{

}
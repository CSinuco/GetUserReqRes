package in.reqres.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "in.reqres.stepDefinitions",
        tags = "@GET",
        snippets = CucumberOptions.SnippetType.CAMELCASE
)


public class CreateGetUserRunner {
}


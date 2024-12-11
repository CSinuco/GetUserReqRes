package in.reqres.stepDefinitions;

import in.reqres.tasks.GetUserTask;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;

import static in.reqres.constants.Constants.URL_Base;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.equalTo;

public class CreateGetUserStepDefinition {
    private static final String  restAPIUrl = URL_Base;

    @When("I send a request to the endpoint {string} with pet id {string}")
    public void iSendARequestToTheEndpointWithPetId(String endpoint, String id) {

        Actor user  = Actor.named("user").whoCan(CallAnApi.at(restAPIUrl));

        user.attemptsTo(
                GetUserTask.fromEndpoint(endpoint,id)

        );

    }

    @Then("I Validate that the response code is {string}")
    public void iValidateThatTheResponseCodeIs(String code) {

        Actor user = Actor.named("user");

        String codeRest = String.valueOf(SerenityRest.lastResponse().getStatusCode());
        user.should(
                seeThat("The responde code is",res->codeRest,equalTo(code))
        );
    }
}

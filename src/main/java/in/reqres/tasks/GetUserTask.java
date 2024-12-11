package in.reqres.tasks;

import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.rest.interactions.Get;
import net.serenitybdd.screenplay.Task;


import static net.serenitybdd.screenplay.Tasks.instrumented;

public class GetUserTask implements  Task{
    private final String endPoint;

    private final String id;

    public GetUserTask(String endPoint,String id) {
        this.endPoint = endPoint;
        this.id = id;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Get.resource(endPoint+id).with(
                        requestSpecification -> requestSpecification
                                .contentType(ContentType.JSON)
                                .header("accept", "application/json")
                                .log().all()
                )
        );
    }

    public static Performable fromEndpoint(String endPoint, String id) {
        return instrumented(GetUserTask.class, endPoint,id);
    }
}

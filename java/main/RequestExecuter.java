import netware.client.RequestClient;
import netware.client.callbacks.ClientCallback;
import netware.client.extensions.RequestHeaders;
import netware.client.extensions.Serializer;
import netware.client.holders.RequestError;
import netware.client.holders.RequestResponse;
import org.jetbrains.annotations.NotNull;

public class RequestExecuter {

    void execute() {

        RequestHeaders requestHeaders = new RequestHeaders()
                .add("Content-Type", "application/json");

        RequestBody requestBody = new RequestBody("John", "Doe");

        RequestClient requestClient = new RequestClient("http://localhost:8000/v1/display-custom-object")
                .method("POST")
                .headers(requestHeaders.getHeaders())
                .body(Serializer.serialize(requestBody))
                .build();

        if (requestClient.isSuccess()) {
            System.out.println(requestClient.response().getLog(true));
        } else {
            System.out.println(requestClient.error().getLog(true));
        }
    }
}

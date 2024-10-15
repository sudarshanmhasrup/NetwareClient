import netware.client.RequestClient;
import netware.client.extensions.RequestHeaders;
import netware.client.extensions.Serializer;

// Data class
class CustomObject {

    String firstName;
    String lastName;

    public CustomObject(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
}

// Class to execute network request
class RequestExecuter {

    void execute() {

        RequestHeaders requestHeaders = new RequestHeaders();
        requestHeaders.add("Content-Type", "application/json");
        requestHeaders.add("Accept", "application/json");

        CustomObject customObject = new CustomObject("John", "Doe");

        RequestClient requestClient = new RequestClient("http://localhost:8000/v1/display-custom-object")
                .method("POST")
                .headers(requestHeaders.getHeaders())
                .body(Serializer.jsonSerializer(customObject))
                .build();

        if (requestClient.isSuccess()) {
            System.out.println(requestClient.response().getLog(true));
        } else {
            System.out.println(requestClient.error().getLog(true));
        }
    }
}

// Main class
public class NetworkRequest {

    public static void main(String[] args) {

        RequestExecuter requestExecuter = new RequestExecuter();
        requestExecuter.execute();
    }
}

import netware.client.RequestClient;
import netware.client.extensions.RequestHeaders;

class RequestExecuter {

    void execute() {

        RequestHeaders requestHeaders = new RequestHeaders();
        requestHeaders.add("Content-Type", "application/json");
        requestHeaders.add("Accept", "application/json");

        RequestClient requestClient = new RequestClient(
                "http://localhost:8000/v1/display-custom-object",
                "GET",
                requestHeaders.getHeaders(),
                json
        );
    }
}


public class NetworkRequest {
    public static void main(String[] args) {

    }
}

## About library
Netware Client is a straightforward networking library to simplify networking in Kotlin and Java. This library is created to simplify the process of sending and receiving data between clients and servers. Please refer to the following documentation to learn how you can use this library in your project. [View the documentation](https://netwareclient.vercel.app/)

Netware Client supports the following operations:
- Perform `GET`, `PUT`, `POST`, `PATCH`, and `DELETE` HTTP requests.
- Send headers along with the network requests.
- Accept server response in `JSON` or `String` format.
- Send request body in `JSON` or `String` format.
- Display response and error logs in well format.

### About the project directory structure.
I have divided this project into sub-modules so it will be easy  going through the source code of this project for anyone who's willing to go through the proejct source code. I have also added API module and make sure you run it first before starting your walkthrough.
- `/api`: This module contains API logic.
- `/gradle`: Contains gradle metadata.
- `/java`: This contains a sample of NetwareClient usages in Java.
- `/kotlin`: This module contains a sample of NetwareClient usages in Kotlin.
- `/library`: This is the main module of this project and contains library logic.


### Examples
```java
import netware.client.RequestClient;
import netware.client.extensions.RequestHeaders;
import netware.client.extensions.Serializer;

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
```

### Background story

When I was learning how to send network requests in Java and later on in Kotlin, I realized that there is no easy way to do that. Even though there are libraries available in the market like Volley, Ktor Client, Fuel, etc., these libraries are complicated to implement and not so easy to get started as a beginer. With simplification and efficiency in mind, I decided to work on this library. To make this library mature and more efficient, I need contributors. If anyone who's reading this finds my idea interesting, then you can definitely contribute to this project. Just keep one thing in mind: we have to make this library as simple as possible to implement and efficient to handle all networking tasks in Kotlin and Java. You can contact me using this email: sudarshanmhasrup@gmail.com.

### Authors
[@Sudarshan Mhasrup](https://github.com/sudarshanmhasrup)

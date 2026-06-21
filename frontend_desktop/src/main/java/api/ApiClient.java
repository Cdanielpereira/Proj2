package api;

import java.net.http.HttpClient;
import java.time.Duration;

public class ApiClient {

    public static final String BASE_URL =
            "http://localhost:8080/goodstay/api";

    private static final HttpClient client = HttpClient.newBuilder()
            .connectTimeout(Duration.ofSeconds(10))
            .build();

    public static HttpClient getClient() {
        return client;
    }
}
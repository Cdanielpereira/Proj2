package api;

import auth.SessionManager;

import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class EntityApi {

    protected static HttpRequest.Builder baseRequest(String url) {

        HttpRequest.Builder builder = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("Content-Type", "application/json");

        String token = SessionManager.getInstance().getJwtToken();

        if (token != null && !token.isBlank()) {
            builder.header("Authorization", "Bearer " + token);
        }

        return builder;
    }

    protected static String send(HttpRequest request) {

        try {
            HttpResponse<String> response =
                    ApiClient.getClient()
                            .send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() >= 400) {
                throw new RuntimeException(
                        "HTTP " + response.statusCode() + ": " + response.body()
                );
            }

            return response.body();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    // =====================================================
    // CRUD GENÉRICO (RAW - NECESSÁRIO PARA FORM BUILDER)
    // =====================================================

    public static String getAllRaw(String entity, int pageNo, int pageSize) {

        try {
            String url = ApiClient.BASE_URL + "/" + entity
                    + "?pageNo=" + pageNo + "&pageSize=" + pageSize;

            HttpRequest request = baseRequest(url)
                    .GET()
                    .build();

            return send(request);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static String getByIdRaw(String entity, Long id) {

        try {
            HttpRequest request = baseRequest(
                    ApiClient.BASE_URL + "/" + entity + "/" + id
            )
                    .GET()
                    .build();

            return send(request);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static String createRaw(String entity, String json) {

        try {
            HttpRequest request = baseRequest(
                    ApiClient.BASE_URL + "/" + entity
            )
                    .POST(HttpRequest.BodyPublishers.ofString(json))
                    .build();

            return send(request);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static String updateRaw(String entity, Long id, String json) {

        try {
            HttpRequest request = baseRequest(
                    ApiClient.BASE_URL + "/" + entity + "/" + id
            )
                    .PUT(HttpRequest.BodyPublishers.ofString(json))
                    .build();

            return send(request);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void deleteRaw(String entity, Long id) {

        try {
            HttpRequest request = baseRequest(
                    ApiClient.BASE_URL + "/" + entity + "/" + id
            )
                    .DELETE()
                    .build();

            send(request);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
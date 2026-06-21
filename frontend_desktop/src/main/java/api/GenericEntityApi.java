package api;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.net.http.HttpRequest;

public class GenericEntityApi extends EntityApi {

    protected static final ObjectMapper mapper = new ObjectMapper();

    public static String list(
            String entity,
            int pageNo,
            int pageSize
    ) {

        String url =
                ApiClient.BASE_URL +
                        "/" +
                        entity +
                        "?pageNo=" +
                        pageNo +
                        "&pageSize=" +
                        pageSize;

        HttpRequest request =
                baseRequest(url)
                        .GET()
                        .build();

        return send(request);
    }

    public static String get(
            String entity,
            int id
    ) {

        HttpRequest request =
                baseRequest(
                        ApiClient.BASE_URL +
                                "/" +
                                entity +
                                "/" +
                                id
                )
                        .GET()
                        .build();

        return send(request);
    }

    public static String create(
            String entity,
            Object dto
    ) throws Exception {

        String body =
                mapper.writeValueAsString(dto);

        HttpRequest request =
                baseRequest(
                        ApiClient.BASE_URL +
                                "/" +
                                entity
                )
                        .POST(
                                HttpRequest.BodyPublishers
                                        .ofString(body)
                        )
                        .build();

        return send(request);
    }

    public static String update(
            String entity,
            int id,
            Object dto
    ) throws Exception {

        String body =
                mapper.writeValueAsString(dto);

        HttpRequest request =
                baseRequest(
                        ApiClient.BASE_URL +
                                "/" +
                                entity +
                                "/" +
                                id
                )
                        .PUT(
                                HttpRequest.BodyPublishers
                                        .ofString(body)
                        )
                        .build();

        return send(request);
    }

    public static void delete(
            String entity,
            int id
    ) {

        HttpRequest request =
                baseRequest(
                        ApiClient.BASE_URL +
                                "/" +
                                entity +
                                "/" +
                                id
                )
                        .DELETE()
                        .build();

        send(request);
    }
}
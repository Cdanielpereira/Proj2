package services;

import api.ApiClient;
import api.EntityApi;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.GenericPageResponse;
import services.EntityService;

import java.net.http.HttpRequest;
import java.util.Map;

public class EntityServiceImpl extends EntityApi implements EntityService {

    private static final ObjectMapper mapper = new ObjectMapper();

    @Override
    public GenericPageResponse<Map<String, Object>> getAll(String entity, int pageNo, int pageSize) {

        try {
            String url = ApiClient.BASE_URL + "/" + entity
                    + "?pageNo=" + pageNo
                    + "&pageSize=" + pageSize;

            HttpRequest request = baseRequest(url)
                    .GET()
                    .build();

            String json = send(request);

            return mapper.readValue(json, new TypeReference<>() {});
        } catch (Exception e) {
            throw new RuntimeException("Error fetching list", e);
        }
    }

    @Override
    public Map<String, Object> getById(String entity, Long id) {

        try {
            String url = ApiClient.BASE_URL + "/" + entity + "/" + id;

            HttpRequest request = baseRequest(url)
                    .GET()
                    .build();

            String json = send(request);

            return mapper.readValue(json, new TypeReference<>() {});
        } catch (Exception e) {
            throw new RuntimeException("Error fetching by id", e);
        }
    }

    @Override
    public Map<String, Object> create(String entity, Object dto) {

        try {
            String body = mapper.writeValueAsString(dto);

            String url = ApiClient.BASE_URL + "/" + entity;

            HttpRequest request = baseRequest(url)
                    .POST(HttpRequest.BodyPublishers.ofString(body))
                    .build();

            String json = send(request);

            return mapper.readValue(json, new TypeReference<>() {});
        } catch (Exception e) {
            throw new RuntimeException("Error creating entity", e);
        }
    }

    @Override
    public Map<String, Object> update(String entity, Long id, Object dto) {

        try {
            String body = mapper.writeValueAsString(dto);

            String url = ApiClient.BASE_URL + "/" + entity + "/" + id;

            HttpRequest request = baseRequest(url)
                    .PUT(HttpRequest.BodyPublishers.ofString(body))
                    .build();

            String json = send(request);

            return mapper.readValue(json, new TypeReference<>() {});
        } catch (Exception e) {
            throw new RuntimeException("Error updating entity", e);
        }
    }

    @Override
    public void delete(String entity, Long id) {

        try {
            String url = ApiClient.BASE_URL + "/" + entity + "/" + id;

            HttpRequest request = baseRequest(url)
                    .DELETE()
                    .build();

            send(request);
        } catch (Exception e) {
            throw new RuntimeException("Error deleting entity", e);
        }
    }
}
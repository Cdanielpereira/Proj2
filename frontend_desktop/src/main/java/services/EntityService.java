package services;

import model.GenericPageResponse;

import java.util.Map;

public interface EntityService {

    GenericPageResponse<Map<String, Object>> getAll(String entity, int pageNo, int pageSize);

    Map<String, Object> getById(String entity, Long id);

    Map<String, Object> create(String entity, Object dto);

    Map<String, Object> update(String entity, Long id, Object dto);

    void delete(String entity, Long id);
}
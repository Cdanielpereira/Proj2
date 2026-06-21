package config;

import java.util.Map;

public class AppConfig {

    private final Map<String, EntityDefinition> entities;

    public AppConfig(Map<String, EntityDefinition> entities) {
        this.entities = entities;
    }

    public Map<String, EntityDefinition> getEntities() {
        return entities;
    }

    public EntityDefinition getEntity(String name) {
        return entities.get(name);
    }
}
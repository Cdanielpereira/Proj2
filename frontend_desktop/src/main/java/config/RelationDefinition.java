package config;

public class RelationDefinition {

    private String field;
    private String entity;
    private String type;

    public RelationDefinition(String field, String entity, String type) {
        this.field = field;
        this.entity = entity;
        this.type = type;
    }

    public String getField() {
        return field;
    }

    public String getEntity() {
        return entity;
    }

    public String getType() {
        return type;
    }
}
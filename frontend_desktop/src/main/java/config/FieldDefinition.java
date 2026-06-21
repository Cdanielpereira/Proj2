package config;

public class FieldDefinition {

    private final String name;
    private final String label;
    private final String type;
    private final boolean required;

    public FieldDefinition(String name, String type, boolean required) {
        this.name = name;
        this.label = name; // fallback automático
        this.type = type;
        this.required = required;
    }

    public FieldDefinition(String name, String label, String type, boolean required) {
        this.name = name;
        this.label = label;
        this.type = type;
        this.required = required;
    }

    public String getName() {
        return name;
    }

    public String getLabel() {
        return label;
    }

    public String getType() {
        return type;
    }

    public boolean isRequired() {
        return required;
    }
}
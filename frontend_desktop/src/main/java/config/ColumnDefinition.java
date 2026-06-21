package config;

public class ColumnDefinition {

    private String field;
    private String label;
    private boolean filter;

    public ColumnDefinition(String field, String label, boolean filter) {
        this.field = field;
        this.label = label;
        this.filter = filter;
    }

    public String getField() {
        return field;
    }

    public String getLabel() {
        return label;
    }

    public boolean isFilter() {
        return filter;
    }
}
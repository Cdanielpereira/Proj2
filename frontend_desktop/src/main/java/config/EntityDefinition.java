package config;

public class EntityDefinition {

    private String title;

    private ColumnDefinition[] columns;
    private FieldDefinition[] fields;
    private RelationDefinition[] relations;

    public EntityDefinition(
            String title,
            ColumnDefinition[] columns,
            FieldDefinition[] fields,
            RelationDefinition[] relations
    ) {
        this.title = title;
        this.columns = columns;
        this.fields = fields;
        this.relations = relations;
    }

    public String getTitle() {
        return title;
    }

    public ColumnDefinition[] getColumns() {
        return columns;
    }

    public FieldDefinition[] getFields() {
        return fields;
    }

    public RelationDefinition[] getRelations() {
        return relations;
    }
}
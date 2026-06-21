package config;

import java.util.HashMap;
import java.util.Map;

public class EntityConfig {

    private static final Map<String, EntityDefinition> ENTITIES = build();

    private static Map<String, EntityDefinition> build() {

        Map<String, EntityDefinition> entities = new HashMap<>();

        // =========================
        // CLIENTE
        // =========================
        entities.put("cliente", new EntityDefinition(
                "Cliente",
                new ColumnDefinition[]{
                        new ColumnDefinition("nome", "Nome", true),
                        new ColumnDefinition("email", "Email", false),
                        new ColumnDefinition("nif", "NIF", false)
                },
                new FieldDefinition[]{
                        new FieldDefinition("nif", "number", false),
                        new FieldDefinition("nome", "text", true),
                        new FieldDefinition("email", "email", false)
                },
                new RelationDefinition[]{
                        new RelationDefinition("idUser", "user", "many-to-one"),
                        new RelationDefinition("idNacional", "nacionalidade", "many-to-one")
                }
        ));

        // =========================
        // CATERING
        // =========================
        entities.put("catering", new EntityDefinition(
                "Catering",
                new ColumnDefinition[]{
                        new ColumnDefinition("nhospedes", "Hóspedes", false),
                        new ColumnDefinition("precohosp", "Preço", false)
                },
                new FieldDefinition[]{
                        new FieldDefinition("nhospedes", "number", false),
                        new FieldDefinition("precohosp", "number", false),
                        new FieldDefinition("idServico", "number", false),
                        new FieldDefinition("idiva", "number", false)
                },
                new RelationDefinition[]{
                        new RelationDefinition("idServico", "servico", "many-to-one"),
                        new RelationDefinition("idiva", "tipoIva", "many-to-one")
                }
        ));

        return entities;
    }

    public static EntityDefinition get(String entity) {
        return ENTITIES.get(entity);
    }

    public static Map<String, EntityDefinition> getAll() {
        return ENTITIES;
    }
}
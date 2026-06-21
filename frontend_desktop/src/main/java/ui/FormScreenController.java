package ui;

import config.EntityConfig;
import config.EntityDefinition;
import config.FieldDefinition;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;

import java.util.HashMap;
import java.util.Map;

public class FormScreenController {

    @FXML private VBox formContainer;

    private final Map<String, Control> inputs = new HashMap<>();
    private EntityDefinition config;
    private String entity;
    private Integer id;
    private boolean isEdit;

    public void init(String entity, Integer id, boolean isEdit) {
        this.entity = entity;
        this.id = id;
        this.isEdit = isEdit;

        this.config = EntityConfig.get(entity);

        buildForm();
    }

    private void buildForm() {

        formContainer.getChildren().clear();

        for (FieldDefinition field : config.getFields()) {

            Label label = new Label(field.getLabel());

            TextField input = new TextField();
            input.setPromptText(field.getLabel());

            inputs.put(field.getName(), input);

            formContainer.getChildren().addAll(label, input);
        }

        Button submit = new Button(isEdit ? "Atualizar" : "Criar");
        submit.setOnAction(e -> handleSubmit());

        formContainer.getChildren().add(submit);
    }

    private void handleSubmit() {

        Map<String, Object> dto = new HashMap<>();

        for (var entry : inputs.entrySet()) {
            dto.put(entry.getKey(), ((TextField) entry.getValue()).getText());
        }

        System.out.println(dto);
    }
}
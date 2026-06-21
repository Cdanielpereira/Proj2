package ui;

import config.EntityConfig;
import config.EntityDefinition;
import config.ColumnDefinition;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ListScreenController {

    @FXML private TextField searchField;
    @FXML private VBox listContainer;
    @FXML private Button createButton;
    @FXML private Button refreshButton;

    private String entityKey;
    private EntityDefinition config;

    private List<Map<String, Object>> data = new ArrayList<>();

    public void init(String entityKey) {
        this.entityKey = entityKey;
        this.config = EntityConfig.get(entityKey);

        loadData();
        render();
    }

    @FXML
    private void initialize() {

        refreshButton.setOnAction(e -> {
            loadData();
            render();
        });

        searchField.textProperty().addListener((obs, oldV, newV) -> render());
    }

    private void loadData() {
        data = new ArrayList<>();
    }

    private void render() {

        listContainer.getChildren().clear();

        String filter = searchField.getText() == null
                ? ""
                : searchField.getText().toLowerCase();

        for (Map<String, Object> row : data) {

            if (!matchesFilter(row, filter)) continue;

            HBox card = new HBox(10);
            card.setStyle("-fx-padding:10; -fx-background-color:#00172d;");

            VBox info = new VBox(5);

            for (ColumnDefinition col : config.getColumns()) {

                Object value = row.get(col.getName());

                Label label = new Label(
                        col.getLabel() + ": " + (value != null ? value : "-")
                );

                label.setStyle("-fx-text-fill:white;");
                info.getChildren().add(label);
            }

            Button edit = new Button("Editar");
            Button delete = new Button("Apagar");

            card.getChildren().addAll(info, edit, delete);
            listContainer.getChildren().add(card);
        }
    }

    private boolean matchesFilter(Map<String, Object> row, String filter) {

        if (filter.isBlank()) return true;

        return row.values().stream()
                .anyMatch(v -> v != null &&
                        v.toString().toLowerCase().contains(filter));
    }

    @FXML
    private void handleCreate() {
        System.out.println("CREATE " + entityKey);
    }
}
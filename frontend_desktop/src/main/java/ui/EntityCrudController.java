package ui;

import config.EntityConfig;
import config.EntityDefinition;
import config.ColumnDefinition;
import model.GenericPageResponse;
import services.EntityService;
import services.EntityServiceImpl;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.util.List;
import java.util.Map;

public class EntityCrudController {

    @FXML
    private TableView<Map<String, Object>> table;

    private final EntityService service = new EntityServiceImpl();

    private String entityName;
    private EntityDefinition definition;

    public void setEntity(String entityName) {
        this.entityName = entityName;
        this.definition = EntityConfig.get(entityName);

        buildTable();
        loadData();
    }

    private void buildTable() {

        table.getColumns().clear();

        for (ColumnDefinition col : definition.getColumns()) {

            TableColumn<Map<String, Object>, Object> column =
                    new TableColumn<>(col.getLabel());

            column.setCellValueFactory(data ->
                    new javafx.beans.property.SimpleObjectProperty<>(
                            data.getValue().get(col.getField())
                    )
            );

            table.getColumns().add(column);
        }
    }

    private void loadData() {

        GenericPageResponse<Map<String, Object>> response =
                service.getAll(entityName, 0, 50);

        List<Map<String, Object>> data = response.getContent();

        table.setItems(FXCollections.observableArrayList(data));
    }
}
public class CateringController {
    @FXML private ListView<String> listView;
    private final CateringApi api = new CateringApi();
    private List<CateringDto> caterings;

    @FXML
    public void initialize() { loadData(); }

    private void loadData() {
        try {
            caterings = api.getAll();
            listView.setItems(FXCollections.observableArrayList(
                    caterings.stream()
                            .map(c -> c.getId() + " | "
                                    + c.getNhospedes() + " hospedes | "
                                    + c.getPrecohosp() + " EUR")
                            .toList()
            ));
        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }

    @FXML
    private void handleApagar() {
        int idx = listView.getSelectionModel().getSelectedIndex();
        if (idx < 0) return;
        new Alert(Alert.AlertType.CONFIRMATION, "Tem a certeza?")
                .showAndWait().ifPresent(r -> {
                    if (r == ButtonType.OK) {
                        try {
                            api.delete(caterings.get(idx).getId());
                            loadData();
                        } catch (Exception e) {
                            new Alert(Alert.AlertType.ERROR,
                                    e.getMessage()).show();
                        }
                    }
                });
    }
}

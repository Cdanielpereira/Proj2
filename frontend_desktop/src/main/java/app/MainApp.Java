package app;

import javafx.application.Application;
import javafx.stage.Stage;

public class MainApp extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("GoodStay");
        primaryStage.setMinWidth(800);
        primaryStage.setMinHeight(500);

        SceneManager sceneManager = new SceneManager(primaryStage);
        sceneManager.switchTo("/fxml/Home.fxml");
    }

    public static void main(String[] args) {
        launch(args);
    }
}
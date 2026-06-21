package app;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class SceneManager {

    private final Stage primaryStage;

    public SceneManager(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    public void switchTo(String fxmlPath) {
        try {
            URL url = getClass().getResource(fxmlPath);

            if (url == null) {
                throw new IOException("FXML not found: " + fxmlPath);
            }

            FXMLLoader loader = new FXMLLoader(url);
            Parent root = loader.load();

            Object controller = loader.getController();

            if (controller instanceof NavigationAware nav) {
                nav.setSceneManager(this);
            }

            if (primaryStage.getScene() == null) {
                Scene scene = new Scene(root, 900, 600);
                primaryStage.setScene(scene);
            } else {
                primaryStage.getScene().setRoot(root);
            }

            primaryStage.show();

        } catch (IOException e) {
            System.err.println("Error loading FXML: " + fxmlPath);
            e.printStackTrace();
        }
    }

    public Stage getPrimaryStage() {
        return primaryStage;
    }
}
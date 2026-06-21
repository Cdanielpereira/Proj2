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

    /**
     * Loads an FXML file and shows it in the primary window.
     * @param fxmlPath path from resources root, e.g. "/fxml/Home.fxml"
     */
    public void switchTo(String fxmlPath) {
        try {
            URL url = getClass().getResource(fxmlPath);
            if (url == null) {
                throw new IOException("FXML not found: " + fxmlPath);
            }

            FXMLLoader loader = new FXMLLoader(url);
            Parent root = loader.load();

            // Give the controller a reference to this SceneManager
            // so it can trigger further navigation.
            Object controller = loader.getController();
            if (controller instanceof NavigationAware) {
                ((NavigationAware) controller).setSceneManager(this);
            }

            Scene scene = primaryStage.getScene();
            if (scene == null) {
                scene = new Scene(root, 900, 600);
                primaryStage.setScene(scene);
            } else {
                scene.setRoot(root);
            }

            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Stage getPrimaryStage() {
        return primaryStage;
    }
}
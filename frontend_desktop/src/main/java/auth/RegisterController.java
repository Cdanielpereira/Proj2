package auth;

import app.AppNavigator;
import app.NavigationAware;
import app.SceneManager;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class RegisterController implements NavigationAware {

    @FXML private TextField usernameField;
    @FXML private TextField emailField;
    @FXML private PasswordField passwordField;
    @FXML private Label errorLabel;

    private AppNavigator navigator;

    @Override
    public void setSceneManager(SceneManager sceneManager) {
        this.navigator = new AppNavigator(sceneManager);
    }

    @FXML
    private void handleRegister() {
        // TODO: ligar ao backend
        navigator.goToLogin();
    }

    @FXML
    private void handleBackToHome() {
        navigator.goToHome();
    }
}
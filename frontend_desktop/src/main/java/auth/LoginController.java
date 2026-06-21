package auth;

import api.AuthApi;
import app.AppNavigator;
import app.NavigationAware;
import app.SceneManager;
import dto.LoginResponseDto;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.TextField;

public class LoginController implements NavigationAware {

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private CheckBox rememberCheck;

    @FXML
    private Label errorLabel;

    @FXML
    private Button loginButton;

    @FXML
    private ProgressIndicator loadingIndicator;

    private AppNavigator navigator;

    @Override
    public void setSceneManager(SceneManager sceneManager) {
        this.navigator = new AppNavigator(sceneManager);
    }

    @FXML
    private void handleLogin() {

        String username = usernameField.getText();
        String password = passwordField.getText();

        if (username == null || username.isBlank()
                || password == null || password.isBlank()) {

            showError("Preencha utilizador e palavra-passe.");
            return;
        }

        try {
            setLoading(true);
            errorLabel.setVisible(false);

            LoginResponseDto response =
                    AuthApi.login(username, password);

            SessionManager.getInstance().login(
                    response.getUserId(),
                    response.getUsername(),
                    response.getRole(),
                    response.getToken()
            );

            navigator.goToHomeAfterLogin();

        } catch (Exception e) {

            showError("Credenciais inválidas.");
            e.printStackTrace();

        } finally {
            setLoading(false);
        }
    }

    @FXML
    private void handleGoToRegister() {
        navigator.goToRegister();
    }

    private void showError(String message) {
        errorLabel.setText(message);
        errorLabel.setVisible(true);
        errorLabel.setManaged(true);
    }

    private void setLoading(boolean state) {
        loginButton.setDisable(state);

        if (loadingIndicator != null) {
            loadingIndicator.setVisible(state);
        }
    }
}
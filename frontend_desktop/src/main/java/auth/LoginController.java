package auth;

import app.AppNavigator;
import app.NavigationAware;
import app.SceneManager;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class LoginController implements NavigationAware {

    @FXML private TextField usernameField;
    @FXML private PasswordField passwordField;
    @FXML private CheckBox rememberCheck;
    @FXML private Label errorLabel;
    @FXML private Button loginButton;
    @FXML private ProgressIndicator loadingIndicator;

    private AppNavigator navigator;

    @Override
    public void setSceneManager(SceneManager sceneManager) {
        this.navigator = new AppNavigator(sceneManager);
    }

    @FXML
    private void handleLogin() {
        String username = usernameField.getText();
        String password = passwordField.getText();

        if (username.isBlank() || password.isBlank()) {
            showError("Preencha utilizador e palavra-passe.");
            return;
        }

        // TODO: replace this fake check with a real call to AuthService / AuthApi
        String role = fakeLogin(username, password);
        if (role == null) {
            showError("Credenciais inválidas.");
            return;
        }

        SessionManager.getInstance().login(username, role, "fake-jwt-token");
        navigator.goToHomeAfterLogin();
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

    /** Temporary stub. Replace with real authentication. */
    private String fakeLogin(String username, String password) {
        if ("cliente".equals(username) && "1234".equals(password)) return "CLIENTE";
        if ("user".equals(username) && "1234".equals(password)) return "USER";
        return null;
    }
}
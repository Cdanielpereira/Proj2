package app;

import auth.SessionManager;

public class AppNavigator {

    private final SceneManager sceneManager;

    public AppNavigator(SceneManager sceneManager) {
        this.sceneManager = sceneManager;
    }

    public void goToHome() {
        sceneManager.switchTo("/fxml/Home.fxml");
    }

    public void goToLogin() {
        sceneManager.switchTo("/fxml/auth/Login.fxml");
    }

    public void goToRegister() {
        sceneManager.switchTo("/fxml/auth/Register.fxml");
    }

    public void goToHomeAfterLogin() {

        String role = SessionManager.getInstance().getUserRole();

        if ("CLIENTE".equalsIgnoreCase(role)) {
            sceneManager.switchTo("/fxml/HomeCliente.fxml");
        } else {
            sceneManager.switchTo("/fxml/HomeUser.fxml");
        }
    }
}
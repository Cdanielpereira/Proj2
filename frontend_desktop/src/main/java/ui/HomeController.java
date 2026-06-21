package ui;

import app.AppNavigator;
import app.NavigationAware;
import app.SceneManager;
import javafx.fxml.FXML;

public class HomeController implements NavigationAware {

    private AppNavigator navigator;

    @Override
    public void setSceneManager(SceneManager sceneManager) {
        this.navigator = new AppNavigator(sceneManager);
    }

    @FXML
    private void handleGoToLogin() {
        navigator.goToLogin();
    }

    @FXML
    private void handleGoToRegister() {
        navigator.goToRegister();
    }
}
package ui;

import app.AppNavigator;
import app.NavigationAware;
import app.SceneManager;
import auth.SessionManager;
import javafx.fxml.FXML;

public class HomeUserController implements NavigationAware {

    private AppNavigator navigator;

    @Override
    public void setSceneManager(SceneManager sceneManager) {
        this.navigator = new AppNavigator(sceneManager);
    }

    @FXML
    private void handleLogout() {
        SessionManager.getInstance().logout();
        navigator.goToHome();
    }
}
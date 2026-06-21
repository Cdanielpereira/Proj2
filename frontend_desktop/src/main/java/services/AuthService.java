package services;

import api.AuthApi;
import dto.LoginResponseDto;

public class AuthService {

    public LoginResponseDto login(String username, String password) {
        return AuthApi.login(username, password);
    }

    public void logout() {
        auth.SessionManager.getInstance().logout();
    }

    public boolean isLoggedIn() {
        return auth.SessionManager.getInstance().isLoggedIn();
    }
}
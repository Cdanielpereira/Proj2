package auth;

public class SessionManager {

    private Integer userId;
    private String username;
    private String userRole;
    private String jwtToken;

    private SessionManager() {}

    private static class Holder {
        private static final SessionManager INSTANCE =
                new SessionManager();
    }

    public static SessionManager getInstance() {
        return Holder.INSTANCE;
    }

    public void login(
            Integer userId,
            String username,
            String userRole,
            String jwtToken
    ) {
        this.userId = userId;
        this.username = username;
        this.userRole = userRole;
        this.jwtToken = jwtToken;
    }

    public void logout() {
        userId = null;
        username = null;
        userRole = null;
        jwtToken = null;
    }

    public boolean isLoggedIn() {
        return jwtToken != null && !jwtToken.isBlank();
    }

    public Integer getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }

    public String getUserRole() {
        return userRole;
    }

    public String getJwtToken() {
        return jwtToken;
    }
}
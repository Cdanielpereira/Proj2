package auth;

public class SessionManager {

    private static SessionManager instance;

    private String username;
    private String userRole;   // e.g. "CLIENTE" or "USER"
    private String jwtToken;

    private SessionManager() {}

    public static SessionManager getInstance() {
        if (instance == null) {
            instance = new SessionManager();
        }
        return instance;
    }

    public void login(String username, String userRole, String jwtToken) {
        this.username = username;
        this.userRole = userRole;
        this.jwtToken = jwtToken;
    }

    public void logout() {
        this.username = null;
        this.userRole = null;
        this.jwtToken = null;
    }

    public boolean isLoggedIn() {
        return jwtToken != null;
    }

    public String getUsername() { return username; }
    public String getUserRole() { return userRole; }
    public String getJwtToken() { return jwtToken; }
}
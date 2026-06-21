package api;

import auth.SessionManager;
import com.fasterxml.jackson.databind.ObjectMapper;
import dto.LoginRequestDto;
import dto.LoginResponseDto;

import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class AuthApi {

    private static final ObjectMapper mapper = new ObjectMapper();

    public static LoginResponseDto login(String username, String password) {

        try {

            LoginRequestDto dto = new LoginRequestDto();
            dto.setUsername(username);
            dto.setPassword(password);

            String body = mapper.writeValueAsString(dto);

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(ApiClient.BASE_URL + "/auth/login"))
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(body))
                    .build();

            HttpResponse<String> response =
                    ApiClient.getClient()
                            .send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() != 200) {
                throw new RuntimeException(
                        "Login failed: " +
                                response.statusCode() +
                                " - " +
                                response.body()
                );
            }

            LoginResponseDto loginResponse =
                    mapper.readValue(
                            response.body(),
                            LoginResponseDto.class
                    );

            SessionManager.getInstance().login(
                    loginResponse.getUserId(),
                    loginResponse.getUsername(),
                    loginResponse.getRole(),
                    loginResponse.getToken()
            );

            return loginResponse;

        } catch (Exception e) {

            throw new RuntimeException(
                    "AuthApi login error",
                    e
            );
        }
    }

    public static void logout() {
        SessionManager.getInstance().logout();
    }
}
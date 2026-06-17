package goodstay_api.dtos.common;

import lombok.Data;

@Data
public class LoginResponseDto {

    private Integer userId;

    private String token;

    private String role;

    private String username;
}
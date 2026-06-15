package goodstay_api.dtos.common;

import lombok.Data;

@Data
public class LoginRequestDto {

    private String username;
    private String password;

}
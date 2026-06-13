package estg.ipvc.proj2.dtos.userdto;

import lombok.Data;

@Data
public class UserDto {
    private Integer id;
    private String username;
    private String password;
    private String telefone;
}
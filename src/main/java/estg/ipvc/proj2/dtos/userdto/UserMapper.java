package estg.ipvc.proj2.dtos.userdto;

import estg.ipvc.proj2.model.User;

public class UserMapper {

    private UserMapper() {}

    public static UserDto toDto(User u) {
        if (u == null) return null;

        UserDto dto = new UserDto();

        dto.setId(u.getId());
        dto.setUsername(u.getUsername());
        dto.setPassword(u.getPassword());
        dto.setTelefone(u.getTelefone());

        return dto;
    }

    public static User toEntity(UserDto dto) {
        if (dto == null) return null;

        User u = new User();

        u.setUsername(dto.getUsername());
        u.setPassword(dto.getPassword());
        u.setTelefone(dto.getTelefone());

        return u;
    }
}
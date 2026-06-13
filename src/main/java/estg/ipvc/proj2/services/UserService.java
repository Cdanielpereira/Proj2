package estg.ipvc.proj2.services;

import estg.ipvc.proj2.dtos.common.PageResponse;
import estg.ipvc.proj2.dtos.userdto.UserDto;

public interface UserService {

    UserDto createUser(UserDto dto);

    PageResponse<UserDto> getAllUsers(int pageNo, int pageSize);

    UserDto getUserById(int id);

    UserDto updateUser(UserDto dto, int id);

    void deleteUser(int id);
}
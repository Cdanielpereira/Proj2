package goodstay_api.services;

import goodstay_api.dtos.common.PageResponse;
import goodstay_api.dtos.userdto.UserDto;

public interface UserService {

    UserDto createUser(UserDto dto);

    PageResponse<UserDto> getAllUsers(int pageNo, int pageSize);

    UserDto getUserById(int id);

    UserDto updateUser(UserDto dto, int id);

    void deleteUser(int id);
}
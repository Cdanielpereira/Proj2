package goodstay_api.services.impl;

import goodstay_api.dtos.common.PageMapper;
import goodstay_api.dtos.common.PageResponse;
import goodstay_api.dtos.userdto.UserDto;
import goodstay_api.dtos.userdto.UserMapper;
import goodstay_api.exceptions.EntityNotFoundException;
import goodstay_api.model.User;
import goodstay_api.repository.UserRepository;
import goodstay_api.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDto createUser(UserDto dto) {

        User user = UserMapper.toEntity(dto);

        return UserMapper.toDto(
                userRepository.save(user)
        );
    }

    @Override
    public PageResponse<UserDto> getAllUsers(int pageNo, int pageSize) {

        Pageable pageable = PageRequest.of(pageNo, pageSize);

        Page<User> users = userRepository.findAll(pageable);

        return PageMapper.toPageResponse(users, UserMapper::toDto);
    }

    @Override
    public UserDto getUserById(int id) {

        User user = userRepository.findById(id)
                .orElseThrow(() ->
                        new EntityNotFoundException("Utilizador não encontrado"));

        return UserMapper.toDto(user);
    }

    @Override
    public UserDto updateUser(UserDto dto, int id) {

        User user = userRepository.findById(id)
                .orElseThrow(() ->
                        new EntityNotFoundException("Utilizador não encontrado"));

        user.setUsername(dto.getUsername());
        user.setPassword(dto.getPassword());
        user.setTelefone(dto.getTelefone());

        return UserMapper.toDto(
                userRepository.save(user)
        );
    }

    @Override
    public void deleteUser(int id) {

        User user = userRepository.findById(id)
                .orElseThrow(() ->
                        new EntityNotFoundException("Utilizador não encontrado"));

        userRepository.delete(user);
    }
}
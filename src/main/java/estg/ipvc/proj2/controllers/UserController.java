package estg.ipvc.proj2.controllers;

import estg.ipvc.proj2.dtos.common.PageResponse;
import estg.ipvc.proj2.dtos.userdto.UserDto;
import estg.ipvc.proj2.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/proj2")
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping("/users")
    public ResponseEntity<PageResponse<UserDto>> getAll(
            @RequestParam(defaultValue = "0") int pageNo,
            @RequestParam(defaultValue = "10") int pageSize
    ) {
        return ResponseEntity.ok(service.getAllUsers(pageNo, pageSize));
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<UserDto> getById(@PathVariable int id) {
        return ResponseEntity.ok(service.getUserById(id));
    }

    @PostMapping("/users")
    public ResponseEntity<UserDto> create(@RequestBody UserDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(service.createUser(dto));
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<UserDto> update(
            @RequestBody UserDto dto,
            @PathVariable int id
    ) {
        return ResponseEntity.ok(service.updateUser(dto, id));
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        service.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}
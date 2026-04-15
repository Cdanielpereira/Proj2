package estg.ipvc.proj2.controllers;

import estg.ipvc.proj2.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/proj2/")

public class UserController {

    @GetMapping("/user")
    public ResponseEntity<List<User>> getUsers(){
        List<User> users = new ArrayList<>();
        return ResponseEntity.ok(users);
    }
}
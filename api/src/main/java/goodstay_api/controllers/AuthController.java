package goodstay_api.controllers;

import goodstay_api.dtos.common.LoginRequestDto;
import goodstay_api.dtos.common.LoginResponseDto;
import goodstay_api.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/goodstay/api/auth")
@CrossOrigin(origins = "*")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public LoginResponseDto login(
            @RequestBody LoginRequestDto dto) {

        return authService.login(dto);
    }
}
package photo.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UsersController {

    @GetMapping("/check")
    public String users(){
        return "working!";
    }

    @GetMapping("/jwt")
    public Jwt getJwt(@AuthenticationPrincipal Jwt jwt){
        return jwt;
    }
}

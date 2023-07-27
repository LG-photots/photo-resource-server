package photo.controller;

import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.*;
import photo.dto.UserDto;

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

    @PreAuthorize("hasAuthority('ROLE_developer') or #id == #jwt.subject")
    //@Secured("ROLE_developer")
    @DeleteMapping(path = "/{id}")
    public String deleteUser(@PathVariable String id, @AuthenticationPrincipal Jwt jwt) {
        return "Deleted user with id " + id + " and JWT subject " + jwt.getSubject();
    }


    @PostAuthorize("returnObject.userId == #jwt.subject")
    @GetMapping(path = "/{id}")
    public UserDto getUser(@PathVariable String id, @AuthenticationPrincipal Jwt jwt) {
        String f = jwt.getSubject();
        return new UserDto("Sergey", "Kargopolov","3c5eef25-f335-4452-b449-5c0f2f7537af");
    }
}

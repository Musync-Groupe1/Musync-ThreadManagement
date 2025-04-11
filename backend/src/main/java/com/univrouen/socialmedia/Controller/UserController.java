package com.univrouen.socialmedia.Controller;


import com.univrouen.socialmedia.Dto.User.CreateUserRequestDto;
import com.univrouen.socialmedia.Entity.User;
import com.univrouen.socialmedia.Repository.UserRepository;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class UserController {
    private final UserRepository userRepository;
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("/register")
    public ResponseEntity<Void> createUser(@RequestBody CreateUserRequestDto userRequestDto,
                                           HttpServletResponse response){
        /*System.out.println("createUserRequestDto = " + userRequestDto.toString());
        User user = new User();
        user.setFirstName(userRequestDto.getFirstname());
        user.setLastName(userRequestDto.getLastname());
        user.setEmail(userRequestDto.getEmail());
        userRepository.save(user);
        return ResponseEntity.ok(user);*/
        return ResponseEntity.ok().build();

    }
}

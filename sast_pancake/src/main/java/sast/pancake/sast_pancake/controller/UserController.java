package sast.pancake.sast_pancake.controller;

import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import sast.pancake.sast_pancake.pojo.response.PersonalException.LoginException;
import sast.pancake.sast_pancake.service.UserService;

@RestController
public class UserController {

    @Resource
    UserService userService;

    @PostMapping("/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password) throws LoginException {
        return userService.login(username,password);
    }
}

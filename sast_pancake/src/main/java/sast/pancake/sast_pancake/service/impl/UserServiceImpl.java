package sast.pancake.sast_pancake.service.impl;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import sast.pancake.sast_pancake.mapper.UserMapper;
import sast.pancake.sast_pancake.pojo.entity.User;
import sast.pancake.sast_pancake.pojo.response.PersonalException.LoginException;
import sast.pancake.sast_pancake.service.UserService;

@Service
public class UserServiceImpl implements UserService{

    @Resource
    UserMapper userMapper;

    @Resource
    Algorithm algorithm;

    @Override
    public String login(String username, String password) throws LoginException {

        User user = userMapper.selectUser(username, password);
        String token = null;

        try {
            token = JWT.create()
                    .withClaim("id",user.getId())
                    .withClaim("username",user.getUsername())
                    .withClaim("role",user.getRole())
                    .sign(algorithm);
        } catch (Exception e) {
            throw new LoginException("用户名或密码错误");
        }

        return token;
    }
}

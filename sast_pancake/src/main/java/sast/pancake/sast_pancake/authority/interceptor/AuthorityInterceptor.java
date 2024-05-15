package sast.pancake.sast_pancake.authority.interceptor;

import com.auth0.jwt.JWTVerifier;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import sast.pancake.sast_pancake.pojo.response.PersonalException.AuthorityException;

@Component
public class AuthorityInterceptor implements HandlerInterceptor {
    @Resource
    JWTVerifier tokenVerifier;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws AuthorityException {
        String token = request.getHeader("Authorization");
        Integer role = tokenVerifier.verify(token).getClaim("role").asInt();
        if (role.intValue() == 1) {
            return true;
        }else{
            throw new AuthorityException("无权限");
        }
    }
}

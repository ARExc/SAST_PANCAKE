package sast.pancake.sast_pancake.authority.interceptor;

import com.auth0.jwt.JWTVerifier;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import sast.pancake.sast_pancake.pojo.response.PersonalException.TokenException;

@Component
public class TokenInterceptor implements HandlerInterceptor {

    @Resource
    JWTVerifier tokenVerifier;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws TokenException {
        String token = request.getHeader("Authorization");
        try {
            tokenVerifier.verify(token);
        } catch (Exception e) {
            throw new TokenException("token令牌异常");
        }
        return true;
    }
}

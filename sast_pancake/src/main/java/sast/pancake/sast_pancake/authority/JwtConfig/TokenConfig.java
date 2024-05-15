package sast.pancake.sast_pancake.authority.JwtConfig;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TokenConfig {

    @Bean
    public Algorithm tokenAlgorithm(@Value("${jwt.secret}")String secret){
        return Algorithm.HMAC256(secret);
    }

    @Bean
    public JWTVerifier tokenVerifier(Algorithm algorithm){
        return JWT.require(algorithm).build();
    }
}

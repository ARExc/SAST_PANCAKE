package sast.pancake.sast_pancake.config;

import jakarta.annotation.Resource;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import sast.pancake.sast_pancake.Converter.StringToLocalDateConverter;
import sast.pancake.sast_pancake.authority.interceptor.AuthorityInterceptor;
import sast.pancake.sast_pancake.authority.interceptor.TokenInterceptor;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Resource
    private TokenInterceptor tokenInterceptor;

    @Resource
    private AuthorityInterceptor authorityInterceptor;

    @Resource
    private StringToLocalDateConverter stringToLocalDateConverter;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(tokenInterceptor)
                .addPathPatterns("/pancake");
        registry.addInterceptor(authorityInterceptor)
                .addPathPatterns("/pancake/{id}","/pancake/{title}/{ddl}");
    }

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(stringToLocalDateConverter);
    }
}

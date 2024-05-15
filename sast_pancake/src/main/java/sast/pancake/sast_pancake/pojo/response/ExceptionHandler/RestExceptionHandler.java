package sast.pancake.sast_pancake.pojo.response.ExceptionHandler;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import sast.pancake.sast_pancake.pojo.response.GlobalResponse;
import sast.pancake.sast_pancake.pojo.response.PersonalException.AuthorityException;
import sast.pancake.sast_pancake.pojo.response.PersonalException.LoginException;
import sast.pancake.sast_pancake.pojo.response.PersonalException.ReturnCode;
import sast.pancake.sast_pancake.pojo.response.PersonalException.TokenException;

@RestControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(TokenException.class)
    public GlobalResponse<String> TokenException(Exception e) {
        return GlobalResponse.failed(ReturnCode.INVALID_TOKEN.getCode(),ReturnCode.INVALID_TOKEN.getMessage());
    }

    @ExceptionHandler(AuthorityException.class)
    public GlobalResponse<String> AuthorityException(Exception e) {
        return GlobalResponse.failed(ReturnCode.ACCESS_DENIED.getCode(),ReturnCode.ACCESS_DENIED.getMessage());
    }

    @ExceptionHandler(LoginException.class)
    public GlobalResponse<String> LoginException(Exception e) {
        return GlobalResponse.failed(ReturnCode.USERNAME_OR_PASSWORD_ERROR.getCode(),ReturnCode.USERNAME_OR_PASSWORD_ERROR.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public GlobalResponse<String> Exception(Exception e) {
        return GlobalResponse.failed(ReturnCode.RC500.getCode(), ReturnCode.RC500.getMessage());
    }

}

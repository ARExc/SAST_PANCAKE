package sast.pancake.sast_pancake.pojo.response.PersonalException;

public enum ReturnCode {
    /**操作成功**/
    RC100(100,"操作成功"),
    /**操作失败**/
    RC999(999,"操作失败"),
    /**服务异常**/
    RC500(500,"系统异常，请稍后重试"),

    INVALID_TOKEN(2001,"访问令牌不合法"),
    ACCESS_DENIED(2003,"没有权限访问该资源"),
    USERNAME_OR_PASSWORD_ERROR(1002,"用户名或密码错误");


    /**自定义状态码**/
    private final int code;
    /**自定义描述**/
    private final String message;

    ReturnCode(int code, String message){
        this.code = code;
        this.message = message;
    }


    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}

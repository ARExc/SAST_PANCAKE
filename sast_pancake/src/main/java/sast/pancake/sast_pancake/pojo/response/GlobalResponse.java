package sast.pancake.sast_pancake.pojo.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GlobalResponse <T>{
    private final Boolean success;
    private final Integer errCode;
    private final String errMsg;
    private final T data;

    public static <T> GlobalResponse<T> success(T data){
        return new GlobalResponse<>(true,null,null,data);
    }

    public static <T> GlobalResponse<T> failed(int errCode,String errMsg){
        return new GlobalResponse<>(false,errCode,errMsg,null);
    }
}

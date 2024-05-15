package sast.pancake.sast_pancake.mapper;

import org.apache.ibatis.annotations.Param;
import sast.pancake.sast_pancake.pojo.entity.User;

public interface UserMapper {
    User selectUser(@Param("username")String username,
                    @Param("password")String password);
}

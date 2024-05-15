package sast.pancake.sast_pancake.mapper;

import org.apache.ibatis.annotations.Param;
import sast.pancake.sast_pancake.pojo.entity.Pancake;

import java.time.LocalDate;
import java.util.List;

public interface PancakeMapper {
    void doPancake(@Param("id") Integer id);

    void deletePancake(@Param("id") Integer id);

    LocalDate selectNow();

    void createPancake(@Param("title") String title,@Param("createTime") LocalDate createTime,@Param("ddl") LocalDate ddl);

    List<Pancake> queryPancakes();
}

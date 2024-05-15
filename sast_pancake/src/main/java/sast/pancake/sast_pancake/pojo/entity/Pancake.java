package sast.pancake.sast_pancake.pojo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pancake {
    private Integer id;
    private String title;
    private LocalDate createTime;
    private LocalDate ddl;
    private Integer isDone;
}

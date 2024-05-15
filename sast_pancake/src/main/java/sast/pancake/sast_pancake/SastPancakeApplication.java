package sast.pancake.sast_pancake;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("sast.pancake.sast_pancake.mapper")
public class SastPancakeApplication {
    public static void main(String[] args) {
        SpringApplication.run(SastPancakeApplication.class, args);
    }
}

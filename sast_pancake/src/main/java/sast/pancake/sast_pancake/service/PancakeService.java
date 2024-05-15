package sast.pancake.sast_pancake.service;

import sast.pancake.sast_pancake.pojo.entity.Pancake;

import java.time.LocalDate;
import java.util.List;

public interface PancakeService {

        void doPancake(Integer id);

        void deletePancake(Integer id);

        void createPancake(String title, LocalDate ddl);

        List<Pancake> queryPancakes();

}

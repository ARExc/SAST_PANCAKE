package sast.pancake.sast_pancake.service.impl;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import sast.pancake.sast_pancake.mapper.PancakeMapper;
import sast.pancake.sast_pancake.pojo.entity.Pancake;
import sast.pancake.sast_pancake.service.PancakeService;

import java.time.LocalDate;
import java.util.List;

@Service
public class PancakeServiceImpl implements PancakeService {
    @Resource
    PancakeMapper pancakeMapper;

    @Override
    public void doPancake(Integer id) {
        pancakeMapper.doPancake(id);
    }

    @Override
    public void deletePancake(Integer id) {
        pancakeMapper.deletePancake(id);
    }

    @Override
    public void createPancake(String title, LocalDate ddl) {
        LocalDate createTime = pancakeMapper.selectNow();
        pancakeMapper.createPancake(title,createTime,ddl);
    }

    @Override
    public List<Pancake> queryPancakes() {
        return pancakeMapper.queryPancakes();
    }
}

package sast.pancake.sast_pancake.controller;

import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;
import sast.pancake.sast_pancake.pojo.entity.Pancake;
import sast.pancake.sast_pancake.service.PancakeService;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/pancake")
public class PancakeController {

    @Resource
    PancakeService pancakeService;

    @PostMapping("/{id}")
    public void doPancake(@PathVariable("id") Integer id){
        pancakeService.doPancake(id);
    }

    @DeleteMapping("/{id}")
    public void deletePancake(@PathVariable("id") Integer id){
        pancakeService.deletePancake(id);
    }

    @PutMapping("/{title}/{ddl}")
    public void createPancake(@PathVariable("title") String title,
                              @PathVariable("ddl") LocalDate ddl){
        pancakeService.createPancake(title,ddl);
    }

    @GetMapping("")
    public List<Pancake> queryPancakes(){
        return pancakeService.queryPancakes();
    }
}

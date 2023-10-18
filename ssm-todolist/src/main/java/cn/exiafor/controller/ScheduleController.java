package cn.exiafor.controller;

import cn.exiafor.pojo.Schedule;
import cn.exiafor.service.ScheduleService;
import cn.exiafor.utils.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("schedule")
@Slf4j
public class ScheduleController {
    @Autowired
    private ScheduleService scheduleService;

    @RequestMapping("/{pageSize}/{currentPage}")
    public Result page(@PathVariable("pageSize") int pageSize,
                       @PathVariable("currentPage") int currentPage) {

        Result r = scheduleService.page(pageSize, currentPage);
        log.info("查询的数据为 : {}", r);
        return r;
    }

    @DeleteMapping("/{id}")
    public Result remove(@PathVariable("id") int id) {
        return scheduleService.remove(id);
    }

    @PostMapping
    public Result save(@Validated @RequestBody Schedule schedule, BindingResult result) {
        if (result.hasErrors()) {
            return Result.fail("参数为 null ，不能保存");
        }
        return scheduleService.save(schedule);
    }

    @PutMapping
    public Result update(@Validated @RequestBody Schedule schedule, BindingResult result) {
        if (result.hasErrors()) {
            return Result.fail("参数为 null ，不能保存");
        }
        return scheduleService.update(schedule);
    }
}

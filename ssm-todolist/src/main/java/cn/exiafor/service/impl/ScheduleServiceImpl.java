package cn.exiafor.service.impl;

import cn.exiafor.mapper.ScheduleMapper;
import cn.exiafor.pojo.Schedule;
import cn.exiafor.service.ScheduleService;
import cn.exiafor.utils.PageBean;
import cn.exiafor.utils.Result;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScheduleServiceImpl implements ScheduleService {
    @Autowired
    private ScheduleMapper scheduleMapper;

    @Override
    public Result page(int pageSize, int currentPage) {
        PageHelper.startPage(currentPage, pageSize);
        List<Schedule> scheduleList = scheduleMapper.queryList();
        PageInfo<Schedule> info = new PageInfo<>(scheduleList);

        PageBean<Schedule> pageBean = new PageBean<>(
                currentPage, pageSize, info.getTotal(), info.getList());

        return Result.ok(pageBean);
    }

    @Override
    public Result remove(int id) {
        int rows = scheduleMapper.deleteById(id);
        if (rows > 0) {
            return Result.ok(null);
        } else {
            return Result.fail(null);
        }
    }

    @Override
    public Result save(Schedule schedule) {
        int rows = scheduleMapper.insert(schedule);
        if (rows > 0) {
            return Result.ok(null);
        } else {
            return Result.fail(null);
        }
    }

    @Override
    public Result update(Schedule schedule) {
        if (schedule.getId() == null) {
            return Result.fail("id 参数为 null ，无法修改");
        }
        int rows = scheduleMapper.update(schedule);
        if (rows > 0) {
            return Result.ok(null);
        } else {
            return Result.fail(null);
        }
    }
}

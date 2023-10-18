package cn.exiafor.service;


import cn.exiafor.pojo.Schedule;
import cn.exiafor.utils.Result;

public interface ScheduleService {
    Result page(int pageSize, int currentPage);

    Result remove(int id);

    Result save(Schedule schedule);

    Result update(Schedule schedule);
}

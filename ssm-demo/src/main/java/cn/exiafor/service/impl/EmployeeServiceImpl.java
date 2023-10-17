package cn.exiafor.service.impl;

import cn.exiafor.mapper.EmployeeMapper;
import cn.exiafor.pojo.Employee;
import cn.exiafor.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeMapper employeeMapper;

    @Override
    public List<Employee> findAll() {
        return employeeMapper.queryList();
    }
}

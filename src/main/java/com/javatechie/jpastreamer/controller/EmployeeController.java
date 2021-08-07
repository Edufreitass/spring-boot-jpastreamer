package com.javatechie.jpastreamer.controller;

import com.javatechie.jpastreamer.entity.Employee;
import com.javatechie.jpastreamer.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    @PostMapping
    public List<Employee> saveEmployees(@RequestBody List<Employee> employees) {
        return service.saveEmployees(employees);
    }

    @GetMapping("/{offset}/{limit}")
    public List<Employee> getEmployees(@PathVariable int offset, @PathVariable int limit) {
        return service.getEmployees(offset, limit);
    }

    @GetMapping("/{dept}")
    public List<Employee> getEmployeesByDept(@PathVariable String dept) {
        return service.getEmployeesByDept(dept);
    }

    @GetMapping("/fetch/{dept}/{salary}")
    public List<Employee> getEmployeesByDeptAndSalary(@PathVariable String dept, @PathVariable double salary) {
        return service.getEmployeesByDeptAndSalary(dept, salary);
    }

    @GetMapping("/range/{salary1}/{salary2}")
    public List<Employee> getEmployeeBySalaryRange(@PathVariable double salary1, @PathVariable double salary2) {
        return service.getEmployeeBySalaryRange(salary1, salary2);
    }

}

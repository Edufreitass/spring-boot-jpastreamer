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

}

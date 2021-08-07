package com.javatechie.jpastreamer.service;

import com.javatechie.jpastreamer.entity.Employee;
import com.javatechie.jpastreamer.entity.Employee$;
import com.javatechie.jpastreamer.repository.EmployeeRepository;
import com.speedment.jpastreamer.application.JPAStreamer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository repository;

    @Autowired
    private JPAStreamer jpaStreamer;

    public List<Employee> saveEmployees(List<Employee> employees) {
        return repository.saveAll(employees);
    }

    public List<Employee> getEmployees(int offset, int limit) {
        return jpaStreamer.stream(Employee.class)
                .sorted(Employee$.name)
                .skip(offset)
                .limit(limit)
                .collect(Collectors.toList());
    }

}

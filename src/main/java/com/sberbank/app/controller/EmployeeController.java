package com.sberbank.app.controller;

import com.sberbank.app.controller.dto.NewEmployeeInfoDto;
import com.sberbank.app.dao.model.Employee;
import com.sberbank.app.service.EmployeeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rest/employee")
@Api(value = "User Controller")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @ApiOperation(value = "get all employees from DB")
    @GetMapping("/employees")
    public List<Employee> findAll() {
        return employeeService.findAll();
    }

    @ApiOperation(value = "save employee")
    @PostMapping(value = "/save", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Employee createEmployee(@RequestBody NewEmployeeInfoDto info) {
        return employeeService.save(info);
    }

    @ApiOperation(value = "delete employee by id")
    @DeleteMapping("/delete/{id}")
    public void deleteEmployee(@PathVariable("id") Long id) {
        employeeService.deleteById(id);
    }

    @ApiOperation(value = "find employee by id")
    @GetMapping("/find/{id}")
    public Employee getEmployee(@PathVariable("id") Long id) {
        return employeeService.findById(id);
    }

    @ApiOperation(value = "update employee")
    @PutMapping("/update")
    public Employee update(@RequestBody Employee employee) {
        return employeeService.update(employee);
    }
}
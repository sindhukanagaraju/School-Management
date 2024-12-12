package com.example.schoolmanagement.controller;

import com.example.schoolmanagement.entity.Department;
import com.example.schoolmanagement.service.DepartmentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ Department")

public class DepartmentController {
    private final DepartmentService departmentService;

    public DepartmentController(final DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @PostMapping("")
    public Department createDepartment(@RequestBody final Department department) {
        return this.departmentService.createDepartment(department);
    }

    @GetMapping("/id/{id}")
    public Department getDepartmentById(@PathVariable final Long id) {
        return this.departmentService.getDepartmentById(id);
    }

    @GetMapping("")
    public List<Department> getDepartment() {
        return this.departmentService.getDepartment();
    }

    @PutMapping("/id/{id}")
    public Department updateDepartmentById(@PathVariable final Long id,@RequestBody final Department department){
        return this.departmentService . updateDepartmentById(department,id);
    }
    @DeleteMapping("/id/{id}")
    public void deleteDeprtmentById(@PathVariable("id") final Long id){
        this.departmentService.deleteDepartmentById(id);
    }
}
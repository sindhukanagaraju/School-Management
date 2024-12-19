package com.example.SchoolManagement.controller;

import com.example.SchoolManagement.entity.Department;
import com.example.SchoolManagement.service.DepartmentServices;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/department")
public class DepartmentController {
    private final DepartmentServices departmentServices;

    public DepartmentController(DepartmentServices departmentServices) {
        this.departmentServices = departmentServices;
    }

    @PostMapping("/create")
    public Department createDepartment(@RequestBody final Department department) {
        return this.departmentServices.createDepartment(department);
    }

    @GetMapping("/retrieve/{id}")
    public Department retrieveDepartmentById(@PathVariable final Long id) {
        return this.departmentServices.getDepartmentById(id);
    }

    @GetMapping("/retrieve")
    public List<Department> retrieveDepartmentAll() {
        return this.departmentServices.getDepartmentAll();
    }

    @PutMapping("/update/{id}")
    public Department updateDepartmentById(@PathVariable final Long id, @RequestBody final Department department) {
        return this.departmentServices.updateDepartmentById(department, id);
    }

//    @DeleteMapping("/delete/{id}")
//    public void deleteDepartmentById(@PathVariable final Long id) {
//        this.departmentServices.deleteDepartmentById(id);
//    }
    @DeleteMapping("/delete/{id}")
    public String deleteDepartmentById(@PathVariable("id") final Long id) {
        return this .departmentServices.deleteDepartmentById(id);
    }

}

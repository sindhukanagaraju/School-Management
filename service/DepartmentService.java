package com.example.schoolmanagement.service;

import com.example.schoolmanagement.entity.Department;
import com.example.schoolmanagement.repository.DepartmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService {

    private final DepartmentRepository departmentRepository;

    public DepartmentService(final DepartmentRepository departmentRepository)
    {
        this.departmentRepository = departmentRepository;
    }
    public Department createDepartment(final Department department)
    {
        return this.departmentRepository.save(department);
    }

    public Department getDepartmentById(final Long id)
    {
        Optional<Department> department = this.departmentRepository.findById(id);

        return department.orElse(null);
    }

    public List<Department> getDepartment(){
        return this.departmentRepository.findAll();
    }

    public Department updateDepartmentById(final Department department,final Long id)
    {
        department.setId(id);
        return this.departmentRepository.save(department);
    }

    public void deleteDepartmentById(final Long  id)
    {
        this.departmentRepository.deleteById (id);
    }
}

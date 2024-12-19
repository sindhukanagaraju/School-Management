package com.example.SchoolManagement.service;

import com.example.SchoolManagement.entity.Department;
import com.example.SchoolManagement.entity.School;
import com.example.SchoolManagement.repository.DepartmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentServices {
    private DepartmentRepository departmentRepository;

    public DepartmentServices(final DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    public Department createDepartment(final Department department) {
        return this.departmentRepository.save(department);
    }

    public Department getDepartmentById(final long id) {
        Optional<Department> department = this.departmentRepository.findById(id);
        return department.orElse(null);
    }

    public List<Department> getDepartmentAll() {
        return this.departmentRepository.findAll();
    }

    public Department updateDepartmentById(final Department department, long id) {
        department.setId(id);
        return this.departmentRepository.save(department);
    }

 //   public void deleteDepartmentById(final long id) {
    //    this.departmentRepository.deleteById(id);
   // }
    public String deleteDepartmentById(Long id) {
        Optional<Department> departmentOptional = departmentRepository.findById(Long.valueOf(id));
        if (departmentOptional.isPresent()) {
            departmentRepository.delete(departmentOptional.get());
            return "Department deleted successfully.";
        } else {
            return "Department not found with id: " + id;
        }
    }

}

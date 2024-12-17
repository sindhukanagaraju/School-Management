package com.example.SchoolManagement.controller;

import com.example.SchoolManagement.entity.School;
import com.example.SchoolManagement.service.SchoolService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ School")

public class SchoolController {
    private final SchoolService schoolService;


    public SchoolController(final SchoolService schoolService) {
        this.schoolService = schoolService;
    }

    @PostMapping()
    public School createSchool(@RequestBody final School school) {
        return this.schoolService.createSchool(school);
    }

    @GetMapping("fetch/{id}")
    public School getSchoolById(@PathVariable final Long id) {
        return this.schoolService.getSchoolById(id);
    }

    @GetMapping("")
    public List<School> getDepartment() {
        return this.schoolService.getSchool();
    }

    @PutMapping("/update/{id}")
    public School updateSchoolById(@PathVariable final Long id,@RequestBody final School school){
        return this.schoolService . updateSchoolId(school,id);
    }



    @DeleteMapping("/delete/{id}")
    public void deleteSchoolById(@PathVariable("id") final Long id){
        this.schoolService.deleteSchoolById(id);
    }
}




package com.example.SchoolManagement.controller;

import com.example.SchoolManagement.entity.School;
import com.example.SchoolManagement.service.SchoolService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/school")
public class SchoolController {

    private final SchoolService schoolService;

    public SchoolController(SchoolService schoolService) {
        this.schoolService = schoolService;
    }

    @PostMapping("/create")
    public School createSchool(@RequestBody final School school) {
        return this.schoolService.createSchool(school);
    }

    @GetMapping("/retrieve/{id}")
    public School getSchoolById(@PathVariable final Long id) {
        return this.schoolService.getSchoolById(id);
    }

    @GetMapping("/retrieve")
    public List<School> getSchool() {
        return this.schoolService.getSchool();
    }

    @GetMapping("/retrieve-name")
    public List<School> retrieveStudent(final String name) {
        System.err.println(name);
        return this.schoolService.retrieveByName(name);
    }
    
    @PutMapping("/update/{id}")
    public School updateSchoolById(@PathVariable final Long id, @RequestBody final School school) {
        return this.schoolService.updateSchoolId(id, school);
    }
//    @PutMapping("/update/{id}")
//     public School updateSchool(@PathVariable Long id, @RequestBody School school) {
//    School updatedSchool = schoolService.updateSchool(id, school);
//    return ResponseEntity.ok(updatedSchool);
//}

//    @DeleteMapping("/delete/{id}")
//    public void deleteSchoolById(@PathVariable("id") final Long id){
//        this.schoolService.deleteSchoolById(id);
//    }
    @DeleteMapping("/delete/{id}")
    public String deleteSchoolById(@PathVariable("id") final Long id) {
        return this .schoolService.deleteSchoolById(id);
    }


}





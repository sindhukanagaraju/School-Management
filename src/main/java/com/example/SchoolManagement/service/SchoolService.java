package com.example.SchoolManagement.service;

import com.example.SchoolManagement.entity.School;
import com.example.SchoolManagement.repository.SchoolRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SchoolService {

    private final SchoolRepository schoolRepository;

    public SchoolService(final SchoolRepository schoolRepository)
    {
        this.schoolRepository = schoolRepository;
    }
    public School createSchool(final School school)
    {
        return this.schoolRepository.save(school);
    }

    public School getSchoolById(final Long id)
    {
        Optional<School> school;
        school = this.schoolRepository.findById(id);
        return school.orElse(null);
    }

    public List<School> getSchool(){
        return this.schoolRepository.findAll();
    }

    public School updateSchoolId(final School school,final Long id)
    {
        school.setId(id);
        return this.schoolRepository.save(school);
    }



    public void deleteSchoolById(final Long  id)
    {
        this.schoolRepository.deleteById (id);
    }
}


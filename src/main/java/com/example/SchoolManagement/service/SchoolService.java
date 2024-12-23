package com.example.SchoolManagement.service;

import com.example.SchoolManagement.entity.Department;
import com.example.SchoolManagement.entity.School;
import com.example.SchoolManagement.repository.SchoolRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SchoolService {

    private final SchoolRepository schoolRepository;

    public SchoolService(final SchoolRepository schoolRepository) {
        this.schoolRepository = schoolRepository;
    }

    public School createSchool(final School school) {
        return this.schoolRepository.save(school);
    }

    public School getSchoolById(final Long id) {
        Optional<School> school;
        school = this.schoolRepository.findById(id);
        return school.orElse(null);
    }

    public List<School> getSchool() {
        return this.schoolRepository.findAll();

    }

    public List<School> retrieveByName(final String name) {
//        System.err.println(studentsRepository.findAll());
        return this.schoolRepository.retrieveByName(name);
//        return this.studentsRepository.findByNameNative(name);
    }

//    public School updateSchoolId(final School school, final Long id) {
//        school.setId(id);
//        return this.schoolRepository.save(school);
//    }

    public School updateSchoolId(Long id, School school) {
        Optional<School> optionalExistingSchool = schoolRepository.findById(id);

        if (optionalExistingSchool.isPresent()) {
            School existingSchool = optionalExistingSchool.get();


            if (school.getName() != null && !school.getName().isEmpty()) {
                existingSchool.setName(school.getName());
            }
            if (school.getAddress() != null && !school.getAddress().isEmpty()) {
                existingSchool.setAddress(school.getAddress());
            }

            return schoolRepository.save(existingSchool);
        } else {
            throw new RuntimeException("School not Found  in Id : "+id);

        }

    }

//    public void deleteSchoolById(final Long  id)
//    {
//        this.schoolRepository.deleteById (id);
//    }

    public String deleteSchoolById(Long id) {
        Optional<School> schoolOptional = schoolRepository.findById(Long.valueOf(id));
        if (schoolOptional.isPresent()) {
            schoolRepository.delete(schoolOptional.get());
            return "School deleted successfully.";
        } else {
            return "School not found with id: " + id;
        }
    }
}
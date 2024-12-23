package com.example.SchoolManagement.repository;
import com.example.SchoolManagement.entity.School;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SchoolRepository extends JpaRepository<School,Long> {

    @Query(value = "SELECT * FROM school WHERE name = :name", nativeQuery = true)
    List<School> retrieveByName(@Param("name") final String name);


}
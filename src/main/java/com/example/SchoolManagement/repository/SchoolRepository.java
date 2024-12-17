package com.example.SchoolManagement.repository;
import com.example.SchoolManagement.entity.School;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface SchoolRepository extends JpaRepository<School,Long> {
}
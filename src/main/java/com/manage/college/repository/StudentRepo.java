package com.manage.college.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.manage.college.models.Student;

@Repository
public interface StudentRepo extends JpaRepository<Student,Long>{
    
}


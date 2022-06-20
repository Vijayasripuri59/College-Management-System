package com.manage.college.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.manage.college.models.Teachers;

@Repository
public interface TeachersRepo extends JpaRepository<Teachers,Long> {
}

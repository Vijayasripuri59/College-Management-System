package com.manage.college.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.manage.college.models.Subjects;


@Repository
public interface SubjectsRepo extends JpaRepository<Subjects,Long> {
}

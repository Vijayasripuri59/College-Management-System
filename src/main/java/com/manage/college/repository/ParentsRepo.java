package com.manage.college.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.manage.college.models.Parents;

@Repository
public interface ParentsRepo extends JpaRepository<Parents,Long> {
}

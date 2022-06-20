package com.manage.college.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.manage.college.models.Login;

public interface LoginRepo extends JpaRepository<Login, Long> {

}

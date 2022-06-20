package com.manage.college.services;
import com.manage.college.models.Parents;
import com.manage.college.repository.ParentsRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ParentsSer {

	@Autowired
    private ParentsRepo parentsRepo;


    public Parents addParents(Parents parents){
        return parentsRepo.save(parents);
    }

}

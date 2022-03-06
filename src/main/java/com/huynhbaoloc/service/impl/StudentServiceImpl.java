package com.huynhbaoloc.service.impl;

import com.huynhbaoloc.entity.Student;
import com.huynhbaoloc.repo.StudentRepo;
import com.huynhbaoloc.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepo studentRepo;

    @Override
    public List<Student> findAll() {
        return studentRepo.findAll();
    }
}

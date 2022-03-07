package com.huynhbaoloc.service.impl;

import com.huynhbaoloc.entity.ClassRoom;
import com.huynhbaoloc.repo.ClassRoomRepo;
import com.huynhbaoloc.service.ClassRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassRoomServiceImpl implements ClassRoomService {

    @Autowired
    private ClassRoomRepo classRoomRepo;

    @Override
    public List<ClassRoom> search(String text) {
        return classRoomRepo.findByName(text);
    }

    @Override
    public List<ClassRoom> findAll() {
        return classRoomRepo.findAll();
    }

    @Override
    public void save(ClassRoom classRoom) {

    }
}

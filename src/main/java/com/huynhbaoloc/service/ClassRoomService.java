package com.huynhbaoloc.service;

import com.huynhbaoloc.entity.ClassRoom;

import java.util.List;

public interface ClassRoomService {

    List<ClassRoom> search(String name);

    List<ClassRoom> findAll();

    void save(ClassRoom classRoom);
}

package com.huynhbaoloc.repo;

import com.huynhbaoloc.entity.ClassRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ClassRoomRepo extends JpaRepository<ClassRoom, Long> {

    @Query(value = "Select * from class_room as c where c.name like %:name%", nativeQuery = true)
    List<ClassRoom> findByName(@Param("name") String name);

}

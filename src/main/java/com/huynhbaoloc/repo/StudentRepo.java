package com.huynhbaoloc.repo;

import com.huynhbaoloc.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepo extends JpaRepository<Student, Long> {
}

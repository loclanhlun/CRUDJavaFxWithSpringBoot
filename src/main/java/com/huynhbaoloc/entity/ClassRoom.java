package com.huynhbaoloc.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Data
@NoArgsConstructor
public class ClassRoom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String code;
    private String name;
    private int status;

    @OneToMany(mappedBy = "class_room", cascade = CascadeType.ALL) // Quan hệ 1-n với đối tượng ở dưới (Student) (1 lớp có nhiều học sinh)
    // MapopedBy trỏ tới tên biến Address ở trong Person.
    private Collection<Student> students;

    public ClassRoom(String code, String name, int status) {
        this.code = code;
        this.name = name;
        this.status = status;
    }
}

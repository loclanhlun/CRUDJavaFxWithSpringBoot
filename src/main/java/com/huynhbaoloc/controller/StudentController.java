package com.huynhbaoloc.controller;

import com.huynhbaoloc.entity.Student;
import com.huynhbaoloc.service.StudentService;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.shape.SVGPath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.io.IOException;

@Controller
public class StudentController extends AbstractController{

    @FXML
    private VBox container;

    @Autowired
    private StudentService studentService;

    @FXML
    private void initialize() throws IOException {
        container.getChildren().clear();
        studentService.findAll().stream().forEach(student -> {
            container.getChildren().add(new StudentItem(student));
        });
    }

    private class StudentItem extends HBox {
        private Label name, age, gender;
        private SVGPath edit;
        private StudentItem(Student student) {
            name = new Label();
            name.setText(student.getName());
            age = new Label();
            age.setText(String.valueOf(student.getAge()));
            gender = new Label();
            gender.setText(student.getGender());
            edit = new SVGPath();
            edit.setContent("M27 0c2.761 0 5 2.239 5 5 0 1.126-0.372 2.164-1 3l-2 2-7-7 2-2c0.836-0.628 1.874-1 3-1zM2 23l-2 9 9-2 18.5-18.5-7-7-18.5 18.5zM22.362 11.362l-14 14-1.724-1.724 14-14 1.724 1.724z");

            getChildren().addAll(name, age, gender, edit);
            getStyleClass().addAll("student-item", "student-item Label");

        }
    }
}

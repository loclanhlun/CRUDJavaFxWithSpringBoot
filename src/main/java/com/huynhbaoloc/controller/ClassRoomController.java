package com.huynhbaoloc.controller;

import com.huynhbaoloc.entity.ClassRoom;
import com.huynhbaoloc.service.ClassRoomService;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class ClassRoomController extends AbstractController{

    @FXML
    private TextField name;
    @FXML
    private TableView<ClassRoom> tableView;

    @Autowired
    private ClassRoomService classRoomService;

    @FXML
    private void initialize() {
        loadData();
    }

    @FXML
    private void search() {
        tableView.getItems().clear();
        List<ClassRoom> list = classRoomService.search(name.getText());
        tableView.getItems().addAll(list);
    }

    @FXML
    private void loadData() {
        tableView.getItems().clear();
        List<ClassRoom> list = classRoomService.findAll();
        tableView.getItems().addAll(list);

    }

    @FXML
    private void addNew() {
        ClassRoomEdit.addNew(this::save);
    }

    private void save(ClassRoom classRoom) {
        classRoomService.save(classRoom);
    }
}

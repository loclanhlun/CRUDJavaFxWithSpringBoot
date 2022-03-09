package com.huynhbaoloc.controller;

import com.huynhbaoloc.entity.ClassRoom;
import com.huynhbaoloc.service.ClassRoomService;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

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
        List<Integer> lists = new ArrayList<>();
        lists.add(0);
        lists.add(1);
        tableView.setOnMouseClicked(event -> {
            if(event.getClickCount() == 2)  {
                ClassRoom classRoom = tableView.getSelectionModel().getSelectedItem();
                if(null != classRoom) {
                    try {
                        ClassRoomEdit.edit(classRoom, this::save, lists);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
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
    private void addNew() throws IOException {
        List<Integer> list = new ArrayList<>();
        list.add(0);
        list.add(1);
        ClassRoomEdit.addNew(this::save, list);
    }

    private void save(ClassRoom classRoom) {
        classRoomService.save(classRoom);
        search();
    }
}

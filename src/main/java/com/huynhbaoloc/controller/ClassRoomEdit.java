package com.huynhbaoloc.controller;

import com.huynhbaoloc.entity.ClassRoom;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.util.function.Consumer;

public class ClassRoomEdit {
    @FXML
    private TextField code;
    @FXML
    private TextField name;
    @FXML
    private ComboBox<Integer> status;


    private ClassRoom classRoom;
    private Consumer<ClassRoom> saveHandler;

    public static void addNew(Consumer<ClassRoom> saveHandler) {
        edit(null, saveHandler);
    }

    public static void edit(ClassRoom classRoom, Consumer<ClassRoom> saveHandler) {

    }
}

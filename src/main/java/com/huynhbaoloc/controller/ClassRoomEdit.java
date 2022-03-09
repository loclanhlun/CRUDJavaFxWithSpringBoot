package com.huynhbaoloc.controller;

import com.huynhbaoloc.AccountException;
import com.huynhbaoloc.entity.ClassRoom;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.util.List;
import java.util.function.Consumer;

public class ClassRoomEdit {

    @FXML
    private Label message;
    @FXML
    private Label title;
    @FXML
    private TextField code;
    @FXML
    private TextField name;
    @FXML
    private ComboBox<Integer> status;


    private ClassRoom classRoom;
    private Consumer<ClassRoom> saveHandler;

    public static void addNew(Consumer<ClassRoom> saveHandler, List<Integer> list) throws IOException {
        edit(null, saveHandler, list);
    }

    public static void edit(ClassRoom classRoom, Consumer<ClassRoom> saveHandler, List<Integer> list) throws IOException {
        try {
            Stage stage = new Stage(StageStyle.UNDECORATED);
            stage.initModality(Modality.APPLICATION_MODAL);
            FXMLLoader loader = new FXMLLoader(ClassRoomEdit.class.getResource("/view/ClassRoomEdit.fxml"));
            stage.setScene(new Scene(loader.load()));


            ClassRoomEdit controller = loader.getController();
            controller.init(classRoom, saveHandler, list);

            stage.show();

        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void save() {
        try {
            validate();
            saveHandler.accept(classRoom);
            cancel();
        }catch (AccountException e){
            message.setText(e.getMessage());
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void validate() {
        if(code.getText().isEmpty()) {
            throw new AccountException("Please enter class code.");
        }
        if(name.getText().isEmpty()) {
            throw new AccountException("Please enter class name.");
        }
        if (status.getValue() == null) {
            throw new AccountException("Please choose status");
        }
        classRoom.setCode(code.getText());
        classRoom.setName(name.getText());
        classRoom.setStatus(status.getValue());
    }

    @FXML
    private void cancel() {
        name.getScene().getWindow().hide();
    }

    private void init(ClassRoom classRoom, Consumer<ClassRoom> saveHandler, List<Integer> list) {
        this.saveHandler = saveHandler;
        status.getItems().addAll(list);
        if(null == classRoom) {
            title.setText("Add new Class Room");
            this.classRoom = new ClassRoom();
        }else {
            title.setText("Edit class Room");
            this.classRoom = classRoom;
            name.setText(classRoom.getName());
            code.setText(classRoom.getCode());
            status.setValue(classRoom.getStatus());
        }
    }
}

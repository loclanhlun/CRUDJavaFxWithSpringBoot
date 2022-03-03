package com.huynhbaoloc.common;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;


public class Dialog {

    @FXML
    private Label title;

    @FXML
    private Label message;

    @FXML
    private Button okBtn;

    private Stage stage;

    public Dialog() {
    }

    @FXML
    public void cancel() {
        stage.getScene().getWindow().hide();
    }

    public void show() {
        stage.show();
    }

    public static class DialogBuilder {
        private String title;
        private String message;

        private ActionListener okActionListener;

        private DialogBuilder() {}

        public DialogBuilder okActionListener(ActionListener okActionListener) {
            this.okActionListener = okActionListener;
            return this;
        }

        public DialogBuilder message(String message) {
            this.message = message;
            return this;
        }

        public DialogBuilder title(String title) {
            this.title = title;
            return this;
        }

        public Dialog build() throws IOException {
            Stage stage = new Stage(StageStyle.UNDECORATED);
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Dialog.fxml"));
            Parent view = loader.load();
            Scene scene = new Scene(view);
            stage.setScene(scene);

            Dialog controller = loader.getController();
            controller.stage = stage;

            controller.title.setText(this.title);
            controller.message.setText(this.message);

            if(null != okActionListener) {
                controller.okBtn.setOnAction(event -> {
                    controller.cancel();
                    okActionListener.doAction();
                });
            }else {
                controller.okBtn.setVisible(false);
            }
            return controller;
        }

        public static DialogBuilder builder() {
            return new DialogBuilder();
        }
    }

    public static interface ActionListener {
        void doAction();
    }
}

package com.huynhbaoloc.controller;

import com.huynhbaoloc.AccountException;
import com.huynhbaoloc.SpringBootCRUDApplication;
import com.huynhbaoloc.entity.Account;
import com.huynhbaoloc.service.LoginService;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import java.io.IOException;

@Controller
public class LoginController {

    @Autowired
    private LoginService loginService;

    private static Account loginUser;

    @FXML
    private Button btnCancel;

    @FXML
    private PasswordField password;

    @FXML
    private Button btnLogin;

    @FXML
    private Label message;

    @FXML
    private TextField username;

    @FXML
    void cancel() {
        btnCancel.getScene().getWindow().hide();
    }

    @FXML
    void login() {
        try {
            loginUser = loginService.login(username.getText(), password.getText());

            // open application
            MainFrameController.show();
            close();
        }catch (AccountException e){
            message.setText(e.getMessage());
        }catch (Exception e){
            e.printStackTrace();
            cancel();
         }
    }

    public void attachEvent() {
        // when typing textField btnLogin is enable
        btnLogin.setDisable(true);
        username.textProperty().addListener((observable, oldValue, newValue) -> {
            btnLogin.setDisable(newValue.trim().isEmpty());
        });

        username.getScene().setOnKeyPressed(event -> {
            if(event.getCode().equals(KeyCode.ENTER)){
                if(btnCancel.isFocused()) {
                    cancel();
                }
                if(btnLogin.isFocused()) {
                    login();
                }
            }
        });
    }

    public static void loadView(Stage primaryStage) throws IOException {
        FXMLLoader loader = new FXMLLoader(LoginController.class.getResource("/view/Login.fxml"));
        loader.setControllerFactory(requiredType -> SpringBootCRUDApplication.getApplicationContext().getBean(requiredType));
        Parent root = loader.load();
        primaryStage.setScene(new Scene(root));

        LoginController login = loader.getController();
        login.attachEvent();

        primaryStage.show();
    }
    public void close() {
        btnLogin.getScene().getWindow().hide();
    }
}

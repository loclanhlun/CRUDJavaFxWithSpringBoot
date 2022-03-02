package com.huynhbaoloc.controller;

import com.huynhbaoloc.SpringBootCRUDApplication;
import com.huynhbaoloc.utils.Menu;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.springframework.stereotype.Controller;

import java.io.IOException;

@Controller
public class MainFrameController {


    @FXML
    private VBox sideBar;

    @FXML
    private StackPane contentView;

    @FXML
    private void initialize() throws IOException {
        loadView(Menu.Home);
    }

    @FXML
    private void clickMenu(MouseEvent event) throws IOException {
        Node node = ((Node) event.getSource());
        if(node.getId().equals("Exit")) {
            sideBar.getScene().getWindow().hide();
        } else {
            Menu menu = Menu.valueOf(node.getId());
            loadView(menu);
        }
    }

    private void loadView (Menu menu) throws IOException {
        for(Node node : sideBar.getChildren()) {
            node.getStyleClass().remove("active");
            if(node.getId().equals(menu.name())) {
                node.getStyleClass().add("active");
            }
        }
        contentView.getChildren().clear();
        FXMLLoader loader = new FXMLLoader(MainFrameController.class.getResource("/view/"+ menu.getFxml()));
        loader.setControllerFactory(SpringBootCRUDApplication.getApplicationContext()::getBean);
        Parent view = loader.load();
        contentView.getChildren().add(view);
    }
    public static void show() throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(MainFrameController.class.getResource("/view/MainFrame.fxml"));
        stage.setScene(new Scene(root));
        stage.setTitle("Main");
        stage.show();
    }
}

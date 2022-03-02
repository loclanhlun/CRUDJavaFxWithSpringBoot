package com.huynhbaoloc;

import com.huynhbaoloc.controller.LoginController;
import javafx.application.Application;
import javafx.stage.Stage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringBootCRUDApplication extends Application {
    private static ConfigurableApplicationContext applicationContext;

    @Override
    public void init() throws Exception {
        applicationContext = SpringApplication.run(SpringBootCRUDApplication.class);
    }

    @Override
    public void stop() throws Exception {
        applicationContext.close();
    }

    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        LoginController.loadView(primaryStage);
    }

    public static ConfigurableApplicationContext getApplicationContext() {
        return applicationContext;
    }
}

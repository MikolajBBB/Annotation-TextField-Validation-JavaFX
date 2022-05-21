package com.example.lab5;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Controller scenaKontrolera = new Controller();
        stage.setScene(new Scene(scenaKontrolera));
        stage.setTitle("Validation App");
        stage.setWidth(600);
        stage.setHeight(400);
        stage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}

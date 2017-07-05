package com.mycompany.testproject;

import java.net.URL;

import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


public class FXMLController implements Initializable {
    
    StackPane stackPane;
    Pane pane;
    
    @FXML
    private void handleReloadButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        MainApp temp = new MainApp();
        
        
        /*Scene scene = new Scene(pane);
        scene.getStylesheets().add("/styles/Styles.css");
        
        Stage stage = new Stage();
        stage.setScene(scene);
        
        stage.show();*/
        

        /*Stage stage = FXMLLoader.load(getClass().getResource("/fxml/Scene.fxml"));
        temp.start(pane.getParent());*/
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
}

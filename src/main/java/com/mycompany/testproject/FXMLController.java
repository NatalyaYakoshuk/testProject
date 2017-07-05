package com.mycompany.testproject;

import java.net.URL;

import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


public class FXMLController implements Initializable {
    
    StackPane stackPane;
    Pane pane;
    
     Double oldX;
   Double oldY;
   
    @FXML
    private Pane mypane;
    
    
    @FXML
    public void mouseMovedAction(javafx.scene.input.MouseEvent event){
         oldX = mypane.getTranslateX() - event.getSceneX();
         oldY = mypane.getTranslateY() - event.getSceneY();

    }
   
    @FXML
    public void mouseDraggedAction(javafx.scene.input.MouseEvent event){
         mypane.setTranslateX(oldX+event.getSceneX());
         mypane.setTranslateY(oldY+event.getSceneY());
        
    }
    
    
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

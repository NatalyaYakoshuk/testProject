package com.mycompany.testproject;

import java.net.URL;

import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import javafx.fxml.Initializable;
import javafx.scene.layout.StackPane;


public class FXMLController implements Initializable {
    
    StackPane stackPane;
    
    @FXML
    private void handleReloadButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
}

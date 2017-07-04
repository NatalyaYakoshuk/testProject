package com.mycompany.testproject;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ChoiceBox;

public class FXMLController implements Initializable {
    
    @FXML
    private Label label;
    private ChoiceBox choiceBox;
    
    @FXML
    private void start() {
    choiceBox = new ChoiceBox();
    choiceBox.getItems().add("Hello!");
    choiceBox.getItems().add("How are you?");
    choiceBox.getItems().add("Good luck");
}
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        start();
        label.setText((String)choiceBox.getValue());
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
}

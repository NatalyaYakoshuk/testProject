package com.mycompany.testproject;

import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;

import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


public class FXMLController implements Initializable {
    
    @FXML
    private StackPane stackPane;
    @FXML
    private Pane pane;
    @FXML
    private Pane mypane;
    @FXML
    private Spinner spinner;
    
    private Double oldX;
    private Double oldY;
   
    
    
    
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
    private void handleReloadButtonAction(ActionEvent event) throws IOException {
        stackPane.getChildren().clear();
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/Scene.fxml"));
        stackPane.getChildren().add(root);
    }
    
    private void test(){
        //Spinner<LocalDate> s = new Spinner<>();
        
        ObservableList<LocalDate> list; //todo: сделать инкапсулированно
        LocalDate day1 = LocalDate.now();
        LocalDate day2 = LocalDate.of(2010, Month.MARCH, 20);
        list = FXCollections.observableArrayList(day1,day2);
//        spinner = new Spinner<LocalDate>();
        SpinnerValueFactory<LocalDate> valueFactory = new SpinnerValueFactory<LocalDate>() {
            @Override
            public void decrement(int steps) {
                LocalDate current = this.getValue();
                int idx = list.indexOf(current);
                int newIdx = (list.size()+idx-steps)%list.size();
                LocalDate newLang = list.get(newIdx);
                this.setValue(newLang);
            }

            @Override
            public void increment(int steps) {
                LocalDate current = this.getValue();
                int idx = list.indexOf(current);
                int newIdx = (idx+steps)%list.size();
                LocalDate newLang = list.get(newIdx);
                this.setValue(newLang);
            }
        };
        valueFactory.setValue(day1);
        spinner.setValueFactory(valueFactory);

        
        /*spinner.setOnMouseClicked(e->{spinner.setVisible(false);});
        SpinnerValueFactory<LocalDate> svf = new SpinnerValueFactory.ListSpinnerValueFactory<>(list);
        svf.setValue(list.get(0));
        spinner.setValueFactory(svf);*/
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        test();
    }    
}

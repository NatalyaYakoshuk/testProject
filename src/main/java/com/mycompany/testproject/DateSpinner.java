/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.testproject;

import java.time.LocalDate;
import javafx.collections.ObservableList;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;


/**
 *
 * @author shlykov
 */

public class DateSpinner extends Spinner{
    private ObservableList<LocalDate> dateList;
    private final SpinnerValueFactory<LocalDate> mySVF;
    private final Spinner<LocalDate> mySpinner;
    
    public DateSpinner(ObservableList<LocalDate> dateList, Spinner<LocalDate> mySpinner){
        this.mySpinner = mySpinner;
        this.dateList = dateList;
        this.mySVF = new SpinnerValueFactory<LocalDate>() {
            @Override
            public void decrement(int steps) {
                LocalDate current = this.getValue();
                int idx = dateList.indexOf(current);
                int newIdx = (dateList.size()+idx-steps)%dateList.size();
                LocalDate newLang = dateList.get(newIdx);
                this.setValue(newLang);
            }

            @Override
            public void increment(int steps) {
                LocalDate current = this.getValue();
                int idx = dateList.indexOf(current);
                int newIdx = (idx+steps)%dateList.size();
                LocalDate newLang = dateList.get(newIdx);
                this.setValue(newLang);
            }
        };
        this.mySVF.setValue(this.dateList.get(0));
        this.mySpinner.setValueFactory(this.mySVF);
        mySpinner.getStyleClass().add(Spinner.STYLE_CLASS_SPLIT_ARROWS_HORIZONTAL);
    }
    
    public ObservableList<LocalDate> getDateList(){
        return dateList;
    }
    public void setDateList(ObservableList<LocalDate> dateList){
       this.dateList = dateList;
    }
}

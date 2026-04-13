package com.example;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class MainController {
    int n = 90;
    CheckBox[] boxes = new CheckBox[n];

    @FXML
    private GridPane gridPane;

    @FXML
    private TextField selectedBox;

    @FXML
    void initialize() {
        for(int i=0; i<n; i++) {
            boxes[i] = new CheckBox();
            boxes[i].setText(String.valueOf(i+1));
            gridPane.add(boxes[i], i % 7, i/7);
        }
    }

    @FXML
    void onClickSaveButton(ActionEvent event) {
        this.startSave();
    }

    void startSave() {}
}

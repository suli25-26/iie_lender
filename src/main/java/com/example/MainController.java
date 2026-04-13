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
            boxes[i].selectedProperty()
            .addListener((observable, oldValue, newValue) -> {
                System.out.println(newValue);
                this.selectedBox.setText(String.valueOf(countSelected()));
            });

            gridPane.add(boxes[i], i % 7, i/7);

        }
    }

    @FXML
    void onClickSaveButton(ActionEvent event) {
        this.startSave();
    }

    void startSave() {
        System.out.println(countSelected());
        if(countSelected() == 5) {
            System.out.println("Mentés...");
            Store.write(this.generateLine());
        }else {
            System.err.println("Hiba! 5 számot kell megjelölni!");
        }
    }

    int countSelected() {
        int count = 0;
        for(CheckBox box : boxes) {
            if(box.isSelected()) {
                count++;
            }
        }
        return count;
    }

    String generateLine() {
        StringBuffer sb = new StringBuffer();
        for(CheckBox box : boxes) {
            if(box.isSelected()) {
                sb.append(box.getText());
                sb.append(",");
            }
        }        
        return sb.toString();
    }
}

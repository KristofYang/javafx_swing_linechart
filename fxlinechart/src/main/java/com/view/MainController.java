package com.view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class MainController {

    @FXML
    public void handlerBtnClick(ActionEvent event){
        Button btnSource = (Button) event.getSource();
        btnSource.setText("i am clicked!");
    }
}

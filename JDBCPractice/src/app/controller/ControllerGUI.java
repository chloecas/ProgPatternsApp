package app.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.scene.layout.Pane;

public class ControllerGUI {

    @FXML
    private Pane loginPage;

    @FXML
    private void handleClick(ActionEvent event) {
        System.out.println("Button clicked!");
        loginPage.setVisible(true);

    }
}

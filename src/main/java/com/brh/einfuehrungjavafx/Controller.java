package com.brh.einfuehrungjavafx;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;

public class Controller {
    @FXML
    private TextField urlTf;
    @FXML
    private TextField directoryTf;
    @FXML
    protected void download() {
           var download = new Download();

           //Aufgabe: prüfen ob die Textfelder Daten enthalten
           download.load( urlTf.getText(), directoryTf.getText() );

    }

    @FXML
    protected void searchDirectory() {
        var window = directoryTf.getScene().getWindow();
        var directoryChooser = new DirectoryChooser();
        var file = directoryChooser.showDialog(window);
        String path = file.getAbsolutePath();
        directoryTf.setText(path);
    }
}
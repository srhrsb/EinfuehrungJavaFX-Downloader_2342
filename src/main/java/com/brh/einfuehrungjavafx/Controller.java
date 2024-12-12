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
           String url =  urlTf.getText();
           String directory =  directoryTf.getText();

           if(!url.isEmpty() && !directory.isEmpty()){
               download.load( url, directory );
           }


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
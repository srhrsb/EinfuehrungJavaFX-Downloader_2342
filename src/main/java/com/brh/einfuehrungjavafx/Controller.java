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
           //Aufgabe: prüfen ob die Textfelder Daten enthalten
           String url =  urlTf.getText();
           String directory =  directoryTf.getText();

           if(!url.isEmpty() && !directory.isEmpty()){

                 new Thread( new Download( url, directory) ).start();
                 new Thread( new Download("https://spiel-programmieren.de/Images/PanelWeb.jpg" , directory) ).start();
                 new Thread( new Download( "https://spiel-programmieren.de/Images/PanelUnity.jpg", directory) ).start();

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
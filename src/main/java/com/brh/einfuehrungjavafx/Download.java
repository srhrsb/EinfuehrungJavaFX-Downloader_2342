package com.brh.einfuehrungjavafx;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

//Anmerkung: Diese Art und Weise würde bei größeren Dateien nicht funktionieren
//da die while-Schleife in der Methode "load" der Prozess zu lange aufhalten würde
//in einem weiteren Versuch werden wir später versuchen, den Download nebenläufig durchzuführen

public class Download {
   private File outputFile;

    /**
     * Download durchfuehren
     * @param link url
     * @param folder Zielordner
     */
   public void load( String link, String folder){

       try{ //Exceptionhandling weil die URL Klasse und die HttpUrlConection
            //CheckedExceptions sind und eine Fehlerbehandlung "erzwingen" durch das Schlüsselwort throws
           URL url = new URL(link);
           //Http Verbindung herstellen
           HttpURLConnection connection = (HttpURLConnection) url.openConnection();

           //Stream öffnen
           BufferedInputStream inputStream = new BufferedInputStream(connection.getInputStream());

           //Ausgabefile -> hier werden die runtergeladenen Datengespeichert
           File file = new File(link);//dient der Feststellung des Dateinamens
           String filename = file.getName();
           outputFile = new File(folder, filename);//File erstellt

           OutputStream outputStream = new FileOutputStream( outputFile );
           BufferedOutputStream bufferdOutputStream = new BufferedOutputStream( outputStream );

           byte[] buffer = new byte[1024];
           int readByte = 0;
           int progress = 0;


           while((readByte = inputStream.read( buffer, 0, 1024)) >= 0){ //solange Daten im Stream sind
               bufferdOutputStream.write( buffer, 0, readByte); //gelesene Daten an Outputstream übergeben
               progress +=readByte;
               System.out.println("schon runtergeladen: "+ progress);
           }

           bufferdOutputStream.close();
           inputStream.close();
       }
       catch( MalformedURLException e){
           System.err.println( "Fehlerhafte Url:" + e.getMessage());
       }
       catch( IOException e){
           System.err.println( "Fehler: " + e.getMessage());
       }
       finally{

       }
   }








}

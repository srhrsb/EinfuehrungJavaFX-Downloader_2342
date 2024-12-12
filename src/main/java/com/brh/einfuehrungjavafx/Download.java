package com.brh.einfuehrungjavafx;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Download {
   private File outputFile;

   public void load( String link, String folder){

       try{
           URL url = new URL(link);
           HttpURLConnection connection = (HttpURLConnection) url.openConnection();

           BufferedInputStream inputStream = new BufferedInputStream(connection.getInputStream());

           File file = new File(link);
           String filename = file.getName();

           outputFile = new File(folder, filename);


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

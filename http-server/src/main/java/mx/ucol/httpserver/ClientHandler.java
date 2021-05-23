package mx.ucol.httpserver;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.FileNotFoundException;


public class ClientHandler implements Runnable {
  final Socket socket;

  public ClientHandler(Socket socket) {
    this.socket = socket;
  }

  public List<String> readContent(File nameFile){
    Scanner reader=null;
    File myFile = new File("www" + nameFile+".html");
    System.out.println("www" + nameFile+".html");
    List<String> fileData = new ArrayList<String>();
    try {
      reader= new Scanner(nameFile);
      while (reader.hasNextLine()) {
        String data = reader.nextLine();
        fileData.add(data);
      }
      reader.close();
    } catch (FileNotFoundException e) {
      System.out.println("An error occurred: " + e.getMessage());
    }
    return fileData;
  }

  public void run() {
    PrintWriter output = null;
    BufferedReader input = null;

    try {
      output = new PrintWriter(socket.getOutputStream(), true);
      input = new BufferedReader(new InputStreamReader(socket.getInputStream()));

      String received;
      while ((received = input.readLine()) != null) {
        String requestArray[] = received.split(" ");

        if (requestArray[0].equals("GET")) {
          // Get the resource name and read its contents in the /www folder
          // If the resource equals "/" it should open index.html
          System.out.println("Resource: " + requestArray[1]);

         // String nameFile = requestArray[1];
          File nameFile;
          nameFile= new File(requestArray[1]);
          String contenido = "";

          for (String s : readContent(nameFile)) {
            System.out.println(s);
            contenido += s;
          }
          System.out.println(contenido);

          // Update the htmlResponse variable with the file contents
          String htmlResponse = contenido;
         // System.out.println(read.Content());
          int contentLength = htmlResponse.length();

          // This line should not be modified just yet
          output.write("HTTP/1.1 200 OK\r\nContent-Length: " +
            String.valueOf(contentLength) + "\r\n\r\n" + htmlResponse);

          // We already sent the response, break the loop
          break;
        }
      }

    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      try {
        output.close();
        input.close();
        socket.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
    
  }
}
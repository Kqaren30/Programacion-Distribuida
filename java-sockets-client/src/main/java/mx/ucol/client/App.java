package mx.ucol.client;

import java.io.*;
import java.net.*;
import java.util.Scanner;//Para poder leer lo ingresado por el teclado

public class App {

    private static class keyboardReader implements  Runnable{
        DataOutputStream outputStream;
        String inputData = "";
        Scanner keyboardInput = new Scanner(System.in);

        private keyboardReader(DataOutputStream outputStream){
            this.outputStream=outputStream;
        }

        public void run() {
            try{
                while(inputData !=null){

                    System.out.print("\nWrite a message: ");
                    inputData =keyboardInput.nextLine();
                    outputStream.writeUTF(inputData);

                    if (inputData.equals("bye")){
                        break;
                    }
                }
                keyboardInput.close();
            }catch (IOException e){System.err.print(e);}
        }
    }

    private static class InputReader implements Runnable{
        DataInputStream inputStream;
        String inputData="";

        private InputReader(DataInputStream inputStream){
            this.inputStream = inputStream;
        }

        public void run() {
            try{
                //Poll the inputStream = Cada que haya un nuevo dato se ira impriendo
                while((inputData=inputStream.readUTF()) !=null){
                    System.out.println("\nReceived from server: " + inputData);

                    if(inputData.equals("bye")){
                        break;
                    }
                }
            }catch (IOException e){ System.err.print(e);}
        }
    }

    public static void main( String[] args )
    {
        Socket socket;
        DataOutputStream outputStream;
        DataInputStream inputStream;
        int port = 3000;

        try {
            socket = new Socket("localhost", port);
            outputStream = new DataOutputStream(socket.getOutputStream());
            inputStream= new DataInputStream(socket.getInputStream());

            //Hilo independiente para leer el teclado
            Thread keyboardReader = new Thread(new keyboardReader(outputStream));

            //Hilo independiente para leer los mensajes recibidos
            Thread inputReader = new Thread(new InputReader(inputStream));

            keyboardReader.start();
            inputReader.start();
            keyboardReader.join();
            inputReader.join();

            outputStream.flush();
            outputStream.close();
            socket.close();
        } catch (Exception e) {
            System.err.print(e);
        }
    }
}

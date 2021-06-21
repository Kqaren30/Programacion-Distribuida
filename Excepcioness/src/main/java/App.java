
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class App
{
    public static void main( String[] args )
    {
        File myFile;
        myFile= new File("file1.txt");
        String nameFile="index.html";
        createFile(myFile);
        writeContent(myFile,"Hello World!!!");
        File myFile2 = new File("archivos/about.html");
        readContent(myFile2);
        readContent2 read = new readContent2(nameFile);
        System.out.println(read.Content());
        readContent3 read2 = new readContent3(myFile2);
        System.out.println("Prueba final:\n"+read2.Content());
        //readContent2(nameFile);
        try{
            System.out.println("Absolute path: " + myFile.getAbsolutePath());
        } catch (SecurityException e){
            System.out.println("An error ocurred while getting the absolute path: "+e.getMessage()); }
    }

    public static void  createFile(File myFile){
        try{
            if(myFile.createNewFile()){
                System.out.println("New File created: "+myFile.getName());
            } else {
                System.out.println("This file was created before");
            }
        } catch (IOException e){
            System.out.println("An error ocurred while creating a new file: "+e.getMessage());
        } catch (SecurityException e){
            e.printStackTrace();//Se utiliza para imprimir el registro del stack donde se ha iniciado la excepción
        }
    }

    public static void writeContent(File myFile,String contents){
        FileWriter writer=null;
        try{
            writer=new FileWriter(myFile);
            writer.write(contents);
            System.out.println("Content saved");
            // writer.close();
        } catch (IOException e){
            System.out.println("An error ocurred while writing: "+e.getMessage());
        } finally {
            if(writer!=null){
                try{ writer.close(); System.out.println("Writer closed");}
                catch (IOException e){System.out.println("An error ocurred while writing: "+e.getMessage());}
            }
        }
    }

    public static void readContent(File myFile){
        Scanner reader=null;
        try{
            reader= new Scanner(myFile);
            while (reader.hasNextLine()){
                String data = reader.nextLine();
                System.out.println("Content of "+myFile+": "+data);
            } //reader.close();
        } catch (FileNotFoundException e){
            System.out.println("An error ocurred while reading: "+e.getMessage());
        } finally {
            if(reader!=null){
                reader.close();
                System.out.println("Reader closed");
            }
        }
    }

    /*public static void readContent2(String nameFile){
        try{
            String file = "archivos/"+nameFile;
            Scanner scanner = new Scanner(new File(file));
            String data = scanner.nextLine();
            //scanner.useDelimiter(" ");
            System.out.println("Content 2 of "+nameFile+": "+data);
            scanner.close();
        }catch (IOException e){System.out.println("An error ocurred while reading: "+e.getMessage());}
    }*/
}
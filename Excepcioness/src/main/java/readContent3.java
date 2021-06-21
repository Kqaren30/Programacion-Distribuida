import java.io.*;
import java.util.Scanner;

public class readContent3 {
    public File nameFile;

    public readContent3(File nameFile){
        this.nameFile=nameFile;
    }

    public String Content(){
        String content="";
        Scanner reader=null;
        try{
            reader= new Scanner(nameFile);
            while (reader.hasNextLine()){
                String data = reader.nextLine();
               // System.out.println("Content of "+nameFile+": "+data);
                content=data;
            } //reader.close();
        } catch (FileNotFoundException e){
            System.out.println("An error ocurred while reading: "+e.getMessage());
        } finally {
            if(reader!=null){
                reader.close();
                //System.out.println("Reader closed");
            }
        }
        return content;
    }

}
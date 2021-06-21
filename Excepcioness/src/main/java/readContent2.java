import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class readContent2 {
    public String nameFile="";

    public readContent2(String nameFile){
        this.nameFile=nameFile;
    }

    public String Content(){
        String content="";
        try{
            String file = "archivos/"+nameFile;
            Scanner scanner = new Scanner(new File(file));
            String data = scanner.nextLine();
            //scanner.useDelimiter(" ");
            //System.out.println("Content 2 of "+nameFile+": "+data);
            content="Content 2 of "+nameFile+": "+data;
            scanner.close();
        }catch (FileNotFoundException e){System.out.println("An error ocurred while reading: "+e.getMessage());}
     return content;
    }

}

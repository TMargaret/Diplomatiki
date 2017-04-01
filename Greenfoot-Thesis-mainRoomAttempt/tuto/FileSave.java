import java.io.*;
import java.util.Scanner;
public class FileSave implements Serializable
{
    public FileSave()
    {
        File file = new File("test.txt");
//write
        try{
            PrintWriter output = new PrintWriter(file);
            output.println("Mike");
            output.println(42);
            output.close();
        }catch (IOException ex){
            System.out.printf("error: %s\n", ex);
        }
       //read 
        try{
        Scanner input = new Scanner(file);
        String name = input.nextLine();
        String age = input.nextLine();
        
        System.out.println(name + age);
    }catch (FileNotFoundException ex){
        System.out.printf("error: %s\n", ex);
    }
    }
}
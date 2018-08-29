import java.util.*;
import java.io.*;
import java.io.IOException;

public class Directoryinfo { 
   public static void main(String[] args) {
      File currentDir = new File(".");
      displayDirectoryContents(currentDir);
   } 
   public static void displayDirectoryContents(File dir) {
      try { 
         File[] files = dir.listFiles();
         for (File file : files) {
            if (file.isDirectory()) {
               System.out.println("directory:" + file.getCanonicalPath());
               displayDirectoryContents(file);
            } else {
               System.out.println("file:" + file.getCanonicalPath());
               displayFileContents(file);
            } 
         } 
      } catch (IOException e) {
         e.printStackTrace();
      } 
   } 
 public static void displayFileContents(File fname){
        String line = null;
        try
        {
           
            FileReader fileReader = new FileReader(fname);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while((line = bufferedReader.readLine()) != null)
            {
                System.out.println(line);
            }
            bufferedReader.close();
        }
        catch(IOException ex)
        {
            System.out.println("Error reading file named '" + fname + "'");
        }
 }
}

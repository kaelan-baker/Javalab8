package parta;
import java.io.*;
import java.util.Scanner;

public class FileStats {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Enter the filename: ");
        String filename = keyboard.nextLine();
        keyboard.close();

        if (filename.equals("")) {
            filename = "input";
        } 
        File file = new File(filename + ".txt");
        
        Scanner fileReader = new Scanner(file);
        int x = 0;
        while(fileReader.hasNextLine()){
            int y = 0;
            String line = fileReader.nextLine();
            for (int i = 0; i < line.length(); i++) {
                if(line.charAt(i) == '*'){
                    System.out.printf("The position of the asterisk is : %d, %d in the file %s\n", y, x, filename);
                }
                y++;
            }
            x++;
        }
        fileReader.close();
       
    }
}
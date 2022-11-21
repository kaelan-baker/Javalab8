package partb;

import java.io.*;
import java.util.Scanner;

public class FileMaker {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        String filename;
        String inputLines;
        int numLines;
        String charsetStr;

        System.out.println("What file name do you want made?");
        filename = keyboard.nextLine();
        filename = checkName(filename);
        System.out.println(filename);

        System.out.println("How many lines do you want in the file?");
        inputLines = keyboard.nextLine();
        numLines = checkLines(inputLines);
        System.out.println(numLines);

        System.out.println("Please enter a character set to use to fill the lines.");
        charsetStr = keyboard.nextLine();
        System.out.println(getCharset(charsetStr));

        //creating .txt and filling it

        try {
            fillFile(getCharset(charsetStr), numLines, filename);
        } catch (Exception e) {
            e.printStackTrace();
        }
        keyboard.close();

    }

    public static String checkName(String inStr) {
        String filename = inStr;
        if (filename.equals("")) {
            filename = "output";
        }
        return filename;
    }

    public static int checkLines(String inStr) {
        int lines;
        if (inStr.equals("")) {
            lines = 20;
        } else {
            lines = Integer.parseInt(inStr);
        }
        if (lines < 1 || lines > 20) {
            lines = 20;
        }
        return lines;
    }

    public static char[] getCharset(String inStr) {
        String input = inStr;
        if(input.equals("")){
            input = "ABC123";
        }

        char[] charset = new char[input.length()];
        for (int i = 0; i < charset.length; i++) {
            charset[i] = input.charAt(i);
        }
        return charset;
    }

    public static void fillFile(char[] inCharset, int inLines, String infilename) throws Exception {
        char[] charset = new char[inCharset.length];
        int i = 0;
        for (char c : inCharset) {
            charset[i] = c;
            i++;
        }
        int lines = inLines;
        String filename = infilename;
        PrintWriter pw = new PrintWriter(filename + ".txt");
        i = 0;
        while(i <= lines -1){
            i++;
            int linelength = 0;
            while(linelength < lines){
                linelength++;
                for (int j = 0; j < (Math.random()*10); j++) {
                    pw.print(charset[(int)(Math.random()*charset.length)]);
                }
                
            }
            pw.print("\n");
        }
        pw.close();
        
    }

}

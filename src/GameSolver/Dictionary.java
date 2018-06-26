package GameSolver;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Dictionary {

    private static FileReader fileReader;
    private static ArrayList<String> words = new ArrayList<String>();
    private static Scanner keyboard = new Scanner(System.in);
    private static ArrayList<String> wordChecker = new ArrayList<String>();

    public static void main(String[] args) {

        // Adding the words to an ArrayList
        // *********************************************************************
        String fileName = "words_alpha.txt";
        String line = null;
        try {
            fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while ((line = bufferedReader.readLine()) != null) {
                words.add(line);
            }
            bufferedReader.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Unable to open file '" + fileName + "'");
        } catch (IOException exc) {
            System.out.println("Error reading file '" + fileName + "'");
        }
        // *********************************************************************

        System.out.println("Please enter the number of alphabets: - ");
        int num = 0;
        num = keyboard.nextInt();
        for (int i = 0; i < num; i++) {
            wordChecker.add(keyboard.next());
        }
        
    }
}

package GameSolver;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Scanner;

public class Dictionary {

    private static FileReader fileReader;
    private static ArrayList<String> words = new ArrayList<String>();
    private static Scanner keyboard = new Scanner(System.in);
    private static String[] wordChecker;
    private static ArrayList<String> finalWords;

    public static void main(String[] args) {

        // Adding the words to an ArrayList
        // *********************************************************************
        String fileName = "words_alpha.txt";
        String line = null;

        // adds all the words from the dictionary to an ArrayList
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

        // takes in the number of letters
        int num = 0;
        System.out.println("Please enter the number of alphabets: - ");
        num = keyboard.nextInt();

        // takes in letters to be added by the user
        wordChecker = new String[num];
        System.out.println("Please enter the letters ");
        for (int i = 0; i < num; i++) {
            wordChecker[i] = keyboard.next();
        }

        // making a clone of the list so that our original list
        // doesn't get affected
        finalWords = (ArrayList<String>) words.clone();

        /*
         * // removes the word greater than the max. length of the word for(int
         * i = 0; i < finalWords.size(); i++) {
         * if(finalWords.get(i).length()>num) { finalWords.remove(i); } }
         */

        ListIterator<String> it = finalWords.listIterator();

        // removing every possible word which dosen't start with the letters
        // entered by the user and also removes the word greater than the max.
        // length of the word

        for (int i = 0; i < wordChecker.length; i++) {
            while (it.hasNext()) {
                String word = it.next();
                if (word.length() > num || !word.startsWith(wordChecker[i])) {
                    it.remove();
                }
            }
        }

        /*
         * for (int i = 0; i < wordChecker.length; i++) { for (int j = 0; j <
         * finalWords.size(); j++) { if
         * (!finalWords.get(i).startsWith(wordChecker[i])) {
         * finalWords.remove(words.get(j)); } } }
         */
        
        // TESTING
        
        System.out.println("Size of list after removals: " + finalWords.size());
        System.out.println("Words Possible");
        for (int i = 0; i < finalWords.size(); i++) {
            System.out.println(finalWords.get(i));
        }

    }
}

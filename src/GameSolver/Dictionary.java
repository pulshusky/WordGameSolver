package GameSolver;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

/**
 * This program asks the user for the letters and then searches through a
 * dictionary of all the possible words from the letters passed by the user
 * 
 * @author Pulkit Garg
 * @author Tye Borden
 *
 */

public class Dictionary {

    private static FileReader fileReader;
    private static ArrayList<String> words = new ArrayList<String>();
    private static Scanner keyboard = new Scanner(System.in);

    public static void main(String[] args) {

        Iterator<String> intLetters;
        String letters;
        List<String> finalList;
        String fileName = "words_alpha.txt";
        String line = null;

        try {
            fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            // adding the words in the dictionary to an ArrayList
            while ((line = bufferedReader.readLine()) != null) {
                words.add(line);
            }
            bufferedReader.close();
            System.out.print("What letters do you want all combinations" + " of ? - ");
            letters = keyboard.nextLine();

            // an iterator to go over the list of dictionary words
            intLetters = words.iterator();

            // removing the words which are greater than maximum
            // possible length of words possible from the passed
            // in letters
            while (intLetters.hasNext()) {
                if (intLetters.next().length() > letters.length()) {
                    intLetters.remove();
                }
            }

            finalList = new ArrayList<>();

            // checking in which words in the list matches with the
            // passed in letters
            for (int i = 0; i < words.size(); i++) {
                if (words.get(i).matches("[" + letters + "]+")) {
                    finalList.add(words.get(i));
                }
            }

            // printing the final list
            System.out.println(finalList.toString());

        } catch (FileNotFoundException ex) {
            System.out.println("Unable to open file '" + fileName + "'");
        } catch (IOException exc) {
            System.out.println("Error reading file '" + fileName + "'");
        }

    }
}

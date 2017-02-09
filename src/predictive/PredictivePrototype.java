package predictive;
import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.stream.Stream;

/**
 * 1 Prototypes and design (25%)

 * @Author Laurie Dugdale
 */
public class PredictivePrototype {

    // declaring constant field variables for clarity.
    private static final char[] KEYPAD = "22233344455566677778889999".toCharArray();
    private static final String[] LETTERS = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    /**
     * Answer 1.1) Use of StringBuffer is better for string concatenation using append as it is
     * mutable and designed to perform better at String concatenation using the append method.
     * ---------------------------------------------------------------------------------
     * wordToSignature accepts a String and converts it to a string of integers ( 2 >= x <= 9 ).
     * Each integer represents a set of letters ( 2 == "abc", 3 == "def" etc.).
     *
     * PRECONDITION:
     * The check for a valid word is done in signatureToWords so this method presumes that all words that are requested
     * contain only valid characters - a valid character is chars between - a <= x >= z and A <= x >= Z .
     * (as requested in the worksheet)
     *
     * @param word String presumed to contain only characters including and between a - z
     * @return String containing numbers between 2 and 9 These numbers represent the numbers on a phone keypad.
     */
    public static String wordToSignature(String word) {

        // convert all the elements of the word to lower case
        word = word.toLowerCase();
        StringBuffer SB = new StringBuffer();

        //an attempt at a lambda, however commented out as it proved much slower then the for loop below.
        //word.chars().forEachOrdered(c -> SB.append(KEYPAD[(char)c - 97]));

        // looping through word
        for (char c : word.toCharArray()) {
            // if the char at position i is a letter subtract it from a ( or 97) to get the right
            // number from the KEYPAD array and append it using StringBuilder

            SB.append(KEYPAD[c - 'a']);

        }

        return SB.toString();
    }

    /**
     * Answer 1.2) Reading the dictionary from a file is inefficient because it cannot be searched as effectively
     * as a data structure is able to do. Also each time a signature is requested the file has to be opened and looped.
     * A data structure should only need to do this once.
     * ---------------------------------------------------------------------------------
     * signatureToWords accepts a String containing numbers as a parameter representing a signature to be matched to
     * a word in the dictionary file ( e.g. if a number in the string is 2 it will be matched to "abc" ).
     * This method reads directly from the "words" file in the root directory. A set of all the Strings that are
     * matched to the signature are returned.
     *
     * @param signature String of numbers representing the numbers on a keypad used for a t9 texting system
     * @return Set of Strings containing the matched words from the "words" file in the directory.
     */
    public static Set<String> signatureToWords(String signature) {

        // the needed local variables
        Set<String> results = new HashSet<>();
        StringBuffer regEx = new StringBuffer();
        String word;

        // loop through the signature String
        for (char c : signature.toCharArray()){
            // the current number in the signature is between 2 and 9
            if (c >= '2' && c <= '9') {
                // append it with the values from the position in the String array LETTERS
                // at the location of the current char - (char)0 - (int)2
                regEx.append("[" + LETTERS[(c - '0') - 2] + "]");
            } else {

                // if not a valid signature return empty set
                return new HashSet<>();
            }
        }

        // read in the file -- scanner is inside "try with resources" as it explicitly closes
        try( Scanner in = new Scanner( new File("words"))){

            // while there is a next line
            while ( in.hasNextLine() ) {

                // check if current word is valid
                if(!isValidWord(word = in.nextLine().toLowerCase())) {
                    continue;
                }


                // assign in.nextLine to a variable so we only change lines once
                // if the current line matches the regex expression add it to the HashSet results
                if(word.matches(regEx.toString())){
                    results.add(word);
                }
            }

        // throw an exception if the file cannot be found
        } catch(IOException e){
            System.err.println("Got an IOException: " + e.getMessage());
        }

        return results;
    }

    /**
     * isValidWord checks if a given String contains only chars including and between a - z and A - Z.
     * if another char is found method returns false else it returns true.
     *
     * @param word String of any length or type
     * @return boolean true if all chars are including and between a - z and A - Z
     */
    public static boolean isValidWord(String word){

        // loop through the chars in the String word
        for (char c : word.toCharArray()) {
            // if char is not between a-z and A-Z return false
            if(!Character.isLetter(c)) {
                return false;
            }
        }

        return true;
    }

    /**
     * isValidWord checks if a given String contains only chars including and between a - z and A - Z.
     * if another char is found method returns false else it returns true.
     *
     * @param word String of any length.
     * @return boolean true if all chars are including and between a - z and A - Z
     */
    private static boolean isValidSignature(String word){

        // loop through the chars in the String word
        for (char c : word.toCharArray()) {
            // if char is not between a-z and A-Z return false
            if(c >= '2' && c <= '9') {
                return true;
            }
        }

        return false;
    }

    public static void main(String [] args){

        System.out.println(signatureToWords("65876"));
//        long startTime = System.nanoTime();
//        System.out.println(wordToSignature("enterprise"));
//        long endTime = System.nanoTime();
//
//        System.out.println(endTime - startTime);

    }
}

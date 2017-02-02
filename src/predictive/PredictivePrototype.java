package predictive;
import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.stream.Stream;

/**
 * @Author Laurie Dugdale
 */
public class PredictivePrototype {

    private static final char[] KEYPAD = "22233344455566677778889999".toCharArray();
    private static final String[] LETTERS = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};


    /**
     * Answer 1.1) Use of StringBuffer is better for string concatenation using append as it is
     * mutable and designed to perform better at String concatenation using the append method.
     * ---------------------------------------------------------------------------------
     * wordToSignature accepts a String
     *
     * @param word
     * @return
     */
    public static String wordToSignature(String word) {

        // convert all the elements of the word to lower case
        word = word.toLowerCase();
        StringBuffer SB = new StringBuffer();

        //an attempt at a less readable lambda
        //word.chars().forEachOrdered(c -> SB.append(KEYPAD[(char)c - 97]));

        // looping through word
        for (char c : word.toCharArray()) {
            // if the char at position i is a letter subtract 97 to get the right
            // number from the KEYPAD array and append it using StringBuilder
            if (Character.isLetter(c)) {
                SB.append(KEYPAD[c - 97]);
            }
        }

        return SB.toString();
    }

    /**
     * Answer 1.2) Reading the dictionary from a file is inefficient because
     * ---------------------------------------------------------------------------------
     *
     * @param signature
     * @return
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
                // append it with the values from the possition in the String array LETTERS
                // at location of the current char - (char)0 - (int)2
                regEx.append("[" + LETTERS[(c - '0') - 2] + "]");
            } else {
                regEx.append(" ");
            }
        }
        System.out.println(regEx.toString());

        // read in the file -- scanner is inside "try with resources" as it explicitly closes
        try( Scanner in = new Scanner( new File("testWords"))){

            // while there is a next line
            while ( in.hasNextLine() ) {
                // check if current word is valid
                if(!isValidWord(word = in.nextLine())) {
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
     * isValidWord checks if a given String contains only chars between a - z and A - Z.
     * if another char is found method returns false else it returns true.
     *
     * @param word String of any length or type
     * @return boolean true if all chars are between a - z and A     - Z
     */
    private static boolean isValidWord(String word){

        // loop through the chars in the String word
        for (char c : word.toCharArray()) {
            // if char is not between a-z and A-Z return false
            if(!Character.isLetter(c)) {
                return false;
            }
        }

        return true;
    }

    public static void main(String [] args){

        //System.out.println(signatureToWords("4663"));
        //System.out.println('z' - 97);

        long startTime = System.nanoTime();
        System.out.println(wordToSignature("enterprise"));
        long endTime = System.nanoTime();

        System.out.println(endTime - startTime);

    }
}

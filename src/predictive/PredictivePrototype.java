package predictive;
import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * Created by mnt_x on 31/01/2017.
 */
public class PredictivePrototype {

    private static final char[] KEYPAD = "22233344455566677778889999".toCharArray();
    private static final String[] LETTERS = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};


    public static String wordToSignature(String word) {
        word = word.toLowerCase();
        StringBuffer SB = new StringBuffer();
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (Character.isLetter(c)) {
                SB.append(KEYPAD[c - 97]);
            } else {
                SB.append(" ");
            }
        }
        return SB.toString();
    }



    public static Set<String> signatureToWords(String signature) {

        String regEx = "";
        Set<String> results = new HashSet<String>();

        for (char c : signature.toCharArray()){
            if (c >= '2' && c <= '9') {
                regEx += "[" + LETTERS[(c - '0') - 2] + "]";
            } else {
                regEx += " ";
            }
        }

        try( Scanner in = new Scanner( new File("words" ) ) ){

            while ( in.hasNextLine() ) {
                String word = in.nextLine();
                if(word.matches(regEx)){
                    results.add(word);
                }
            }

        } catch(IOException e){
            System.err.println("Got an IOException: " + e.getMessage());
        }

        return results;
    }

    public static void main(String [] args){
        //System.out.println(wordToSignature("Home"));
        System.out.println(signatureToWords("01"));
        //System.out.println('z' - 97);
    }
}

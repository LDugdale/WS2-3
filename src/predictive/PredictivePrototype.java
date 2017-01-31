package predictive;
import java.io.File;
import java.io.FileReader;
import java.util.*;

/**
 * Created by mnt_x on 31/01/2017.
 */
public class PredictivePrototype {


    private static Map<Character, Integer> alphaNumeric = new HashMap<>();


        public static String wordToSignature(String word) {

            word = word.toLowerCase();
            StringBuffer SB = new StringBuffer(word);

            alphaNumeric.put('a', 2);
            alphaNumeric.put('b', 2);
            alphaNumeric.put('c', 2);
            alphaNumeric.put('d', 3);
            alphaNumeric.put('e', 3);
            alphaNumeric.put('f', 3);
            alphaNumeric.put('g', 4);
            alphaNumeric.put('h', 4);
            alphaNumeric.put('i', 4);
            alphaNumeric.put('j', 5);
            alphaNumeric.put('k', 5);
            alphaNumeric.put('l', 5);
            alphaNumeric.put('m', 6);
            alphaNumeric.put('n', 6);
            alphaNumeric.put('o', 6);
            alphaNumeric.put('p', 7);
            alphaNumeric.put('q', 7);
            alphaNumeric.put('r', 7);
            alphaNumeric.put('s', 7);
            alphaNumeric.put('t', 8);
            alphaNumeric.put('u', 8);
            alphaNumeric.put('v', 8);
            alphaNumeric.put('w', 9);
            alphaNumeric.put('x', 9);
            alphaNumeric.put('y', 9);
            alphaNumeric.put('z', 9);

            for(int i = 0; i < SB.length(); i++) {

                if (alphaNumeric.containsKey(SB.charAt(i))) {
                    SB.replace(i, i + 1, "" + alphaNumeric.get(SB.charAt(i)));
                } else {
                    SB.replace(i, i + 1, " ");
                }
            }
            return SB.toString();
        }

        public static Set<String> signatureToWords(String signature) {

            File file = new File("testWords.txt");
            try{
                Scanner in = new Scanner(file);
            } catch(Exception e){

            }

        }



        public static void main(String [] args){
            System.out.println(wordToSignature("Home"));
        }
}

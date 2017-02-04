package predictive;

/**
 * Created by mnt_x on 01/02/2017.
 */
public class Sigs2WordsList {
    public static void main(String[] args) {

        ListDictionary ld = new ListDictionary("words");

        for (String s : args) {
            System.out.println(ld.signatureToWords(s));
        }
    }
}
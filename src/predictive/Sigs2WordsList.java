package predictive;

/**
 * @author Laurie Dugdale
 * ----------------------------------------------------------------------
 *  List Dictionary time for command -
 *  time java predictive.Sigs2WordsProto 4663 876 89 4 245 2345 9 8657 65 4646 46662368 885226 8852266
 *  real    0m1.244s
 * ------------------------------------------------------------------------
 *
 *
 */
public class Sigs2WordsList {
    public static void main(String[] args) {

        ListDictionary ld = new ListDictionary("words");

        for (String s : args) {
            System.out.println(ld.signatureToWords(s));
        }
    }
}
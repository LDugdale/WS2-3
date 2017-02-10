package predictive;

/**
 * @author Laurie Dugdale
 *
 *  ----------------------------------------------------------------------
 *  List Dictionary time for command -
 *  time java predictive.Sigs2WordsList 4663
 *  real    0m1.246s
 *  ----------------------------------------------------------------------
 *  List Dictionary time for command -
 *  time java predictive.Sigs2WordsList 4663 876 89 4 245
 *  real    0m1.231s
 * ----------------------------------------------------------------------
 *  List Dictionary time for command -
 *  time java predictive.Sigs2WordsList 4663 876 89 4 245 2345 9 8657 65 4646 46662368 885226 8852266
 *  real    0m1.244s
 * ------------------------------------------------------------------------
 *  List Dictionary time for command -
 *  time java predictive.Sigs2WordsList 4663 876 89 4 245 2345 9 8657 65 4646 46662368 885226 8852266 76325 543543 97 654 2 3 5 6 7 8 546 9227 923
 *  real    0m1.243s
 * ------------------------------------------------------------------------
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
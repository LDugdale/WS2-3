package predictive;

/**
 * @author Laurie Dugdale
 *
 *  ----------------------------------------------------------------------
 *  List Dictionary time for command -
 *  time java predictive.Sigs2WordsList 4663
 *  real	0m0.654s
 *  ----------------------------------------------------------------------
 *  List Dictionary time for command -
 *  time java predictive.Sigs2WordsList 4663 876 89 4 245
 *  real	0m0.665s
 * ----------------------------------------------------------------------
 *  List Dictionary time for command -
 *  time java predictive.Sigs2WordsList 4663 876 89 4 245 2345 9 8657 65 4646 46662368 885226 8852266
 *  real	0m0.641s
 * ------------------------------------------------------------------------
 *  List Dictionary time for command -
 *  time java predictive.Sigs2WordsList 4663 876 89 4 245 2345 9 8657 65 4646 46662368 885226 8852266 76325 543543 97 654 2 3 5 6 7 8 546 9227 923
 *  real	0m0.659s
 * ------------------------------------------------------------------------
 *  List Dictionary time for command -
 *  time java predictive.Sigs2WordsList 4663 876 89 4 245 2345 9 8657 65 4646 46662368 885226 8852266 76325 543543 97 654 2 3 5 6 7 8 546 9227 923 22737737 227336 22774 2277 227653 4637 463843 465336 4653 2253 2653 6837 6837242733 356837 56837 63837
 *  real	0m0.693s
 * ------------------------------------------------------------------------
 *
 * The signatureToWords method for the list class has a significant performance increase mostly due to the fact
 * that the List is only loaded once. Performance becomes more noticeable the more signatures are entered.
 * This is due to only having to access the main dictionary file once and the (O)log n complexity of binary search.
 *
 * Linearly iterating forward and back through the List after finding a match could prove problematic. It is unlikely
 * that there will be a big enough ammount of matching signatures that this will make a noticeable difference.
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
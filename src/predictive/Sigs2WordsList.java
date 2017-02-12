package predictive;

/**
 * @author Laurie Dugdale
 *
 *  Dictionary used "words"
 *  ----------------------------------------------------------------------
 *  Command -
 *  time java predictive.Sigs2WordsList 4663
 *  Timings -
 *  setup : 573004063ns
 *  lookup : 329522ns
 *  real : 0m0.654s
 *  ----------------------------------------------------------------------
 *  Command -
 *  time java predictive.Sigs2WordsList 4663 876 89 4 245
 *  Timings -
 *  setup : 567320268ns
 *  lookup : 516141ns
 *  real : 0m0.665s
 * ----------------------------------------------------------------------
 *  Command -
 *  time java predictive.Sigs2WordsList 4663 876 89 4 245 2345 9 8657 65 4646 46662368 885226 8852266
 *  Timings -
 *  setup : 580617645ns
 *  lookup : 778888ns
 *  real : 0m0.641s
 * ------------------------------------------------------------------------
 *  Command -
 *  time java predictive.Sigs2WordsList 4663 876 89 4 245 2345 9 8657 65 4646 46662368 885226 8852266 76325 543543 97 654 2 3 5 6 7 8 546 9227 923
 *  Timings -
 *  setup : 552570535ns
 *  lookup : 1235544ns
 *  real : 0m0.659s
 * ------------------------------------------------------------------------
 *  Command -
 *  time java predictive.Sigs2WordsList 4663 876 89 4 245 2345 9 8657 65 4646 46662368 885226 8852266 76325 543543 97 654 2 3 5 6 7 8 546 9227 923 22737737 227336 22774 2277 227653 4637 463843 465336 4653 2253 2653 6837 6837242733 356837 56837 63837
 *  Timings -
 *  setup : 578158406ns
 *  lookup : 1748063ns
 *  real : 0m0.693s
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

        // create ListDictionary object and record the time
        long beginning = System.nanoTime();
        ListDictionary ld = new ListDictionary("words");
        long end = System.nanoTime();

        // print the start time
        System.out.println("Sigs2WordsList setup : " + (end - beginning) + "ns");

        // loop inputs and record time at the beginning and end
        beginning = System.nanoTime();
        for(String s : args){

            System.out.println(ld.signatureToWords(s));

        }
        end = System.nanoTime();

        // print the look up time
        System.out.println("Sigs2WordsList lookup : " + (end - beginning) + "ns");

    }
}
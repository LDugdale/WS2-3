package predictive;

/**
 * @author Laurie Dugdale
 *
 *  Dictionary used "words"
 *  TreeMap results -
 *  ----------------------------------------------------------------------
 *  Command -
 *  time java predictive.Sigs2WordsMap 4663
 *  Timings -
 *  setup : 772865218ns
 *  lookup : 155465ns
 *  real : 0m0.884s
 *  ----------------------------------------------------------------------
 *  Command -
 *  time java predictive.Sigs2WordsMap 4663 876 89 4 245
 *  Timings -
 *  setup : 788121211ns
 *  lookup : 277071ns
 *  real : 0m0.886s
 *  ----------------------------------------------------------------------
 *  Command -
 *  time java predictive.Sigs2WordsMap 4663 876 89 4 245 2345 9 8657 65 4646 46662368 885226 8852266
 *  Timings -
 *  setup : 816197444ns
 *  lookup : 439751ns
 *  real : 0m0.889s
 *  ------------------------------------------------------------------------
 *  Command -
 *  time java predictive.Sigs2WordsMap 4663 876 89 4 245 2345 9 8657 65 4646 46662368 885226 8852266 76325 543543 97 654 2 3 5 6 7 8 546 9227 923
 *  Timings -
 *  setup : 807730214ns
 *  lookup : 676033ns
 *  real : 0m0.869s
 *  ------------------------------------------------------------------------
 *  Command -
 *  time java predictive.Sigs2WordsMap 4663 876 89 4 245 2345 9 8657 65 4646 46662368 885226 8852266 76325 543543 97 654 2 3 5 6 7 8 546 9227 923 22737737 227336 22774 2277 227653 4637 463843 465336 4653 2253 2653 6837 6837242733 356837 56837 63837
 *  Timings -
 *  setup : 822912033ns
 *  lookup : 1005519ns
 *  real : 0m0.915s
 * ------------------------------------------------------------------------
 *
 *  HashMap results -
 *  ----------------------------------------------------------------------
 *  Command -
 *  time java predictive.Sigs2WordsMap 4663
 *  Timings -
 *  setup : 657570705ns
 *  lookup : 166359ns
 *  real : 0m0.750s
 *  ----------------------------------------------------------------------
 *  Command -
 *  time java predictive.Sigs2WordsMap 4663 876 89 4 245
 *  Timings -
 *  setup : 654923599ns
 *  lookup : 291448ns
 *  real : 0m0.754s
 *  ----------------------------------------------------------------------
 *  Command -
 *  time java predictive.Sigs2WordsMap 4663 876 89 4 245 2345 9 8657 65 4646 46662368 885226 8852266
 *  Timings -
 *  setup : 674674921ns
 *  lookup : 413405ns
 *  real : 0m0.756s
 *  ------------------------------------------------------------------------
 *  Command -
 *  time java predictive.Sigs2WordsMap 4663 876 89 4 245 2345 9 8657 65 4646 46662368 885226 8852266 76325 543543 97 654 2 3 5 6 7 8 546 9227 923
 *  Timings -
 *  setup : 684555817ns
 *  lookup : 695824ns
 *  real : 0m0.753s
 *  ------------------------------------------------------------------------
 *  Command -
 *  time java predictive.Sigs2WordsMap 4663 876 89 4 245 2345 9 8657 65 4646 46662368 885226 8852266 76325 543543 97 654 2 3 5 6 7 8 546 9227 923 22737737 227336 22774 2277 227653 4637 463843 465336 4653 2253 2653 6837 6837242733 356837 56837 63837
 *  Timings -
 *  setup : 651662543ns
 *  lookup : 1057153ns
 *  real : 0m0.763s
 * ------------------------------------------------------------------------
 *
 *  The Map dictionary class is consitantly slow than the ListDictionary class by around 0.1s no matter what the size
 *  of the argument list is. However when the times are broken down we can see that the actual lookup time for the
 *  signatureToWords method is considerably quicker.
 *
 *  Also when comparing TreeMap to HashMap we see a similar pattern. as a whole TreeMap takes another 0.1s longer but
 *  has a much quicker lookup time. Thus in my opinion making it the better choice for this class.
 *
 *  The code for the MapDictionary class is also much more readable and compact.
 *
 */
public class Sigs2WordsMap {

    public static void main(String[] args) {

        // create MapDictionary object and record the time
        long beginning = System.nanoTime();
        Dictionary d = new MapDictionary("words");
        long end = System.nanoTime();

        // print the start time
        System.out.println("Sigs2WordsMap setup : " + (end - beginning) + "ns");

        // loop inputs and record time at the beginning and end
        beginning = System.nanoTime();
        for(String s : args){

            System.out.println(d.signatureToWords(s));

        }
        end = System.nanoTime();

        // print the look up time
        System.out.println("Sigs2WordsMap lookup : " + (end - beginning) + "ns");
    }
}

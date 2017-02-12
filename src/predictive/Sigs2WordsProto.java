package predictive;

/**
 * @author Laurie Dugdale
 *
 *  Dictionary used "words"
 *  ----------------------------------------------------------------------
 *  Command -
 *  time java predictive.Sigs2WordsProto 4663
 *  Timings -
 *  lookup : 536085414ns
 *  real : 0m0.634s
 *  ----------------------------------------------------------------------
 *  Command -
 *  time java predictive.Sigs2WordsProto 4663 876 89 4 245
 *  Timings -
 *  lookup : 1990892054ns
 *  real : 0m2.156s
 * ----------------------------------------------------------------------
 *  Command -
 *  time java predictive.Sigs2WordsProto 4663 876 89 4 245 2345 9 8657 65 4646 46662368 885226 8852266
 *  Timings -
 *  lookup : 5233914090ns
 *  real : 0m5.311s
 * ----------------------------------------------------------------------
 *  Command -
 *  time java predictive.Sigs2WordsProto 4663 876 89 4 245 2345 9 8657 65 4646 46662368 885226 8852266 76325 543543 97 654 2 3 5 6 7 8 546 9227 923
 *  Timings -
 *  lookup : 9871537783ns
 *  real : 0m9.964s
 * ------------------------------------------------------------------------
 *  Command -
 *  time java predictive.Sigs2WordsProto 4663 876 89 4 245 2345 9 8657 65 4646 46662368 885226 8852266 76325 543543 97 654 2 3 5 6 7 8 546 9227 923 22737737 227336 22774 2277 227653 4637 463843 465336 4653 2253 2653 6837 6837242733 356837 56837 63837
 *  Timings -
 *  lookup : 16754452337ns
 *  real : 0m16.466s
 * ------------------------------------------------------------------------
 *
 * As the method signatureToWords is scanning the dictionary and iterating though it each time a signature
 * is given the method is very slow.
 *
 *
 */
public class Sigs2WordsProto {

    public static void main(String[] args) {


        // loop inputs and record time at the beginning and end
        long beginning = System.nanoTime();
        for(String s : args){

            System.out.println(PredictivePrototype.signatureToWords(s));

        }
        long end = System.nanoTime();

        // print the look up time
        System.out.println("Sigs2WordsProto lookup : " + (end - beginning) + "ns");

    }
}

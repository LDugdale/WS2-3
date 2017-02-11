package predictive;

/**
 * @author Laurie Dugdale
 *
 *  ----------------------------------------------------------------------
 *  Prototype Dictionary time for command -
 *  time java predictive.Sigs2WordsProto 4663
 *  real	0m0.634s
 *  ----------------------------------------------------------------------
 *  Prototype Dictionary time for command -
 *  time java predictive.Sigs2WordsProto 4663 876 89 4 245
 *  real	0m2.156s
 * ----------------------------------------------------------------------
 *  Prototype Dictionary time for command -
 *  time java predictive.Sigs2WordsProto 4663 876 89 4 245 2345 9 8657 65 4646 46662368 885226 8852266
 *  real	0m5.311s
 * ----------------------------------------------------------------------
 *  Prototype Dictionary time for command -
 *  time java predictive.Sigs2WordsProto 4663 876 89 4 245 2345 9 8657 65 4646 46662368 885226 8852266 76325 543543 97 654 2 3 5 6 7 8 546 9227 923
 *  real	0m9.690s
 * ------------------------------------------------------------------------
 *  Prototype Dictionary time for command -
 *  time java predictive.Sigs2WordsProto 4663 876 89 4 245 2345 9 8657 65 4646 46662368 885226 8852266 76325 543543 97 654 2 3 5 6 7 8 546 9227 923 22737737 227336 22774 2277 227653 4637 463843 465336 4653 2253 2653 6837 6837242733 356837 56837 63837
 *  real	0m16.466s
 * ------------------------------------------------------------------------
 *
 * As the method signatureToWords is scanning the dictionary and iterating though it each time a signature
 * is given the method is very slow.
 *
 *
 */
public class Sigs2WordsProto {

    public static void main(String[] args) {

        for(String s : args){
            System.out.println(PredictivePrototype.signatureToWords(s));
        }

    }
}

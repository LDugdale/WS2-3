package predictive;

/**
 * @author Laurie Dugdale
 *
 *  ----------------------------------------------------------------------
 *  Prototype Dictionary time for command -
 *  time java predictive.Words2SigProto this is a test abcdefghijklmnopqrstuvwxyz
 *  real	0m0.095s
 *  ----------------------------------------------------------------------
 *  Prototype Dictionary time for command -
 *  time java predictive.Words2SigProto this is a test abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz abcdefghijklmnopqrstuvwxyz abcdefghijklmnopqrstuvwxyz
 *  real	0m0.091s
 * ----------------------------------------------------------------------
 *  Tree Dictionary time for command -
 *  time java predictive.Words2SigProto this is a test abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz abcdefghijklmnopqrstuvwxyz abcdefghijklmnopqrstuvwxyz abcdefghijklmnopqrstuvwxyz abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz abcdefghijklmnopqrstuvwxyz abcdefghijklmnopqrstuvwxyz abcdefghijklmnopqrstuvwxyz abcdefghijklmnopqrstuvwxyz abcdefghijklmnopqrstuvwxyz abcdefghijklmnopqrstuvwxyz
 *  real	0m0.076s
 * ------------------------------------------------------------------------
 *
 * Not much to be checked with regards to time for this method. Its very fast for our needs. It efficiently turns
 * all valid signatures into characters. using StringBuffer.
 *
 */
public class Words2SigProto {

    public static void main(String[] args) {

        for(String s : args){
            System.out.println(PredictivePrototype.wordToSignature(s));
        }

    }
}

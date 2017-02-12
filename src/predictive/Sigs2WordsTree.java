package predictive;

/**
 * @author Laurie Dugdale
 *
 *  Dictionary used "words"
 *  ----------------------------------------------------------------------
 *  Command -
 *  time java predictive.Sigs2WordsTree 4663
 *  Timings -
 *  setup : 1835190104ns
 *  lookup : 525494ns
 *  real : 0m1.923s
 *  ----------------------------------------------------------------------
 *  Command -
 *  time java predictive.Sigs2WordsTree 4663 876 89 4 245
 *  Timings -
 *  setup : 1832915380ns
 *  lookup : 8316939ns
 *  real : 0m2.156s
 * ----------------------------------------------------------------------
 *  Command -
 *  time java predictive.Sigs2WordsTree 4663 876 89 4 245 2345 9 8657 65 4646 46662368 885226 8852266
 *  Timings -
 *  setup : 1760037444ns
 *  lookup : 140770164ns
 *  real : 0m1.995s
 * ----------------------------------------------------------------------
 *  Command -
 *  time java predictive.Sigs2WordsTree 4663 876 89 4 245 2345 9 8657 65 4646 46662368 885226 8852266 76325 543543 97 654 2 3 5 6 7 8 546 9227 923
 *  Timings -
 *  setup : 1819134951ns
 *  lookup : 137364756ns
 *  real : 0m2.044s
 * -----------------------------------------------------------------------
 *  Command -
 *  time java predictive.Sigs2WordsTree 4663 876 89 4 245 2345 9 8657 65 4646 46662368 885226 8852266 76325 543543 97 654 2 3 5 6 7 8 546 9227 923 22737737 227336 22774 2277 227653 4637 463843 465336 4653 2253 2653 6837 6837242733 356837 56837 63837
 *  Timings -
 *  setup : 1744249977ns
 *  lookup : 144610764ns
 *  real : 0m1.979s
 * ------------------------------------------------------------------------

 *
 * The TreeDictionary class in terms of performance is perhaps not the best choice, loading the words into the
 * dictionary is very inefficient with this particular requested implementation. and looping through each set to
 * cut words down to the length of a signature is also slow. Even if searching for the initial signature match is (O)log n.
 *
 * However for achieving the main goal of a t9 system it is a step closer to the ideal solution as the tree data structure
 * allows us to look at all the possible choices the user might wish to type. Something that is not easily done when
 * utilizing a basic, list, set or map.
 *
 * For speed MapDictionary is the better class is better but for Utility and achieving the goal of a T9 predictive text
 * system TreeDictionary makes the most sense.
 *
 */
public class Sigs2WordsTree {

    public static void main(String[] args) {

        // create TreeDictionary object and record the time
        long beginning = System.nanoTime();
        Dictionary d = new TreeDictionary("words");
        long end = System.nanoTime();

        // print the start time
        System.out.println("Sigs2WordsTree setup : " + (end - beginning) + "ns");

        // loop inputs and record time at the beginning and end
        beginning = System.nanoTime();
        for(String s : args){

            System.out.println(d.signatureToWords(s));

        }
        end = System.nanoTime();

        // print the look up time
        System.out.println("Sigs2WordsTree lookup : " + (end - beginning) + "ns");

    }


}

package predictive;

/**
 * @author Laurie Dugdale
 *
 *  ----------------------------------------------------------------------
 *  Prototype Dictionary time for command -
 *  time java predictive.Sigs2WordsProto 4663
 *  real	0m0.671s
 *  ----------------------------------------------------------------------
 *  Prototype Dictionary time for command -
 *  time java predictive.Sigs2WordsProto 4663 876 89 4 245
 *  real	0m2.069s
 * ----------------------------------------------------------------------
 *  Tree Dictionary time for command -
 *  time java predictive.Sigs2WordsTree 4663 876 89 4 245 2345 9 8657 65 4646 46662368 885226 8852266
 *  real	0m1.968s
 * ------------------------------------------------------------------------
 *  Tree Dictionary time for command -
 *  time java predictive.Sigs2WordsTree 4663 876 89 4 245 2345 9 8657 65 4646 46662368 885226 8852266 76325 543543 97 654 2 3 5 6 7 8 546 9227 923
 *  real	0m2.015s
 * ------------------------------------------------------------------------
 *  Tree Dictionary time for command -
 *  time java predictive.Sigs2WordsTree 4663 876 89 4 245 2345 9 8657 65 4646 46662368 885226 8852266 76325 543543 97 654 2 3 5 6 7 8 546 9227 923 22737737 227336 22774 2277 227653 4637 463843 465336 4653 2253 2653 6837 6837242733 356837 56837 63837
 *  real	0m2.072s
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
 */
public class Sigs2WordsTree {

    public static void main(String[] args) {

        Dictionary d = new TreeDictionary("words");

        for(String s : args){
            System.out.println(d.signatureToWords(s));
        }
    }
}

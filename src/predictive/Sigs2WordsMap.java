package predictive;

/**
 * @author Laurie Dugdale
 *
 *  TreeMap results -
 *  ----------------------------------------------------------------------
 *  Map Dictionary time for command -
 *  time java predictive.Sigs2WordsMap 4663
 *  real	0m0.884s
 *  ----------------------------------------------------------------------
 *  Map Dictionary time for command -
 *  time java predictive.Sigs2WordsMap 4663 876 89 4 245
 *  real	0m0.886s
 *  ----------------------------------------------------------------------
 *  Map Dictionary time for command -
 *  time java predictive.Sigs2WordsMap 4663 876 89 4 245 2345 9 8657 65 4646 46662368 885226 8852266
 *  real	0m0.889s
 *  ------------------------------------------------------------------------
 *  Map Dictionary time for command -
 *  time java predictive.Sigs2WordsMap 4663 876 89 4 245 2345 9 8657 65 4646 46662368 885226 8852266 76325 543543 97 654 2 3 5 6 7 8 546 9227 923
 *  real	0m0.869s
 *  ------------------------------------------------------------------------
 *  Map Dictionary time for command -
 *  time java predictive.Sigs2WordsMap 4663 876 89 4 245 2345 9 8657 65 4646 46662368 885226 8852266 76325 543543 97 654 2 3 5 6 7 8 546 9227 923 22737737 227336 22774 2277 227653 4637 463843 465336 4653 2253 2653 6837 6837242733 356837 56837 63837
 *  real	0m0.915s
 * ------------------------------------------------------------------------
 *
 *  HashMap results -
 *  ----------------------------------------------------------------------
 *  Map Dictionary time for command -
 *  time java predictive.Sigs2WordsMap 4663
 *  real	0m0.750s
 *  ----------------------------------------------------------------------
 *  Map Dictionary time for command -
 *  time java predictive.Sigs2WordsMap 4663 876 89 4 245
 *  real	0m0.754s
 *  ----------------------------------------------------------------------
 *  Map Dictionary time for command -
 *  time java predictive.Sigs2WordsMap 4663 876 89 4 245 2345 9 8657 65 4646 46662368 885226 8852266
 *  real	0m0.756s
 *  ------------------------------------------------------------------------
 *  Map Dictionary time for command -
 *  time java predictive.Sigs2WordsMap 4663 876 89 4 245 2345 9 8657 65 4646 46662368 885226 8852266 76325 543543 97 654 2 3 5 6 7 8 546 9227 923
 *  real	0m0.753s
 *  ------------------------------------------------------------------------
 *  Map Dictionary time for command -
 *  time java predictive.Sigs2WordsMap 4663 876 89 4 245 2345 9 8657 65 4646 46662368 885226 8852266 76325 543543 97 654 2 3 5 6 7 8 546 9227 923 22737737 227336 22774 2277 227653 4637 463843 465336 4653 2253 2653 6837 6837242733 356837 56837 63837
 *  real	0m0.763s
 * ------------------------------------------------------------------------
 *
 *  The Map dictionary class is consitantly slow than the ListDictionary class by around 0.1s no matter what the size
 *  of the argument list is. The code for the MapDictionary class is however much more readable and compact
 *
 *  Using TreeMap is at least a further 0.1s slower for each command.
 *
 *
 */
public class Sigs2WordsMap {

    public static void main(String[] args) {

        Dictionary d = new MapDictionary("words");

        for(String s : args){
            System.out.println(d.signatureToWords(s));
        }
    }
}

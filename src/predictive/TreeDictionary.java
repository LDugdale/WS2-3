package predictive;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class TreeDictionary implements Dictionary {

    private boolean root; // True only the current node is the main root node at the base of the whole tree.
    private TreeDictionary[] children; // Array of the child nodes must always be of length 8.
    private Set<String> words; // Set containing the words for each node except the root node at the base of the whole tree

    /**
     * Constructors
     */

    /**
     * Root node constructor
     */
    public TreeDictionary(String path){

        children = new TreeDictionary[8];
        root = true;

        try( Scanner in = new Scanner( new File(path) ) ){

            while ( in.hasNextLine() ) {

                String word = in.nextLine();
                if(isValidWord(word)) {
                    word = word.toLowerCase();
                    addToTree(word, word);
                }
            }

        } catch(IOException e){

            System.err.println("Got an IOException: " + e.getMessage());
        }
    }

    /**
     * Constructor for the child nodes.
     */
    public TreeDictionary() {

        children = new TreeDictionary[8];
        this.root = false;
        this.words = new HashSet<>();
    }

    /**
     *  Getters & Setters
     */
    /**
     *
     * @return
     */
    public Set<String> getWords(){

        return this.words;
    }

    /**
     *
     * @param word
     */
    public void addWord(String word){

        if (!root) {

            this.words.add(word);
        }
    }

    /**
     *
     * @param c
     * @return
     */
    public TreeDictionary getNode(char c){

        return children[convertToArrayVal(c)];
    }

    /**
     *
     * @param n
     * @param c
     */
    public void setNode(TreeDictionary n, char c){

        this.children[convertToArrayVal(c)] = n;
    }

    /**
     *  Instance methods
     */
    /**
     * Method continues until word length is 0
     *
     * @param word
     * @param nodeWord
     */
    public void addToTree(String word, String nodeWord){

        // If the word length is 0 return.
        if(word.length() == 0 ){
            return;
        }

        // Assigning to prevent calling the same method multiple times.
        char c = word.charAt(0);

        // If there is no node at the needed position create one and add the word.
        if (getNode(c) == null) {

            setNode(new TreeDictionary(), c);
            getNode(c).addWord(nodeWord);

        // else the node exists and we can add the word as normal
        } else {

            getNode(c).addWord(nodeWord);
        }

        // recursive method - continues until the word length is 0
        getNode(c).addToTree(word.substring(1), nodeWord);
    }

    /**
     *
     * @param signature
     * @return
     */
    public Set<String> signatureToWords(String signature){

        int length = signature.length();
        Set<String> results = new HashSet<String>();

        for (String s: getFullWords(signature)) {

            String test = s.substring(0, length);
            results.add(test);
        }

        return results;
    }


    /**
     * Helper methods
     */
    /**
     * Recursive method to fetch all the Set of Strings from a particular node the words in the set are uncropped.
     *
     * @param signature
     * @return
     */
    private Set<String> getFullWords(String signature){

        if(signature.length() == 0){

            return getWords();
        } else {

            int pos = (signature.charAt(0)-'0') - 2;
            return children[pos].getFullWords(signature.substring(1));
        }

    }

    /**
     *
     * @param c
     * @return
     */
    private int convertToArrayVal(char c){

        // if c - 'a' is equal to 18, 21, 24, 25
        if ( c- 'a' == 18 || c - 'a' == 21  || c - 'a' == 24 || c - 'a' == 25) {

            //subtract one from the result due to p and q containing 4 digits
            return ((c - 'a') - ((c - 'a') % 3)) / 3 - 1;
        } else {

            // Sum to map the letters to the 8 index array;
            return ((c - 'a') - ((c - 'a') % 3)) / 3;
        }
    }

    private boolean isValidWord(String word){

        // loop through the chars in the String word
        for (char c : word.toCharArray()) {
            // if char is not between a-z and A-Z return false
            if(!Character.isLetter(c)) {
                return false;
            }
        }

        // passed all the checks return true
        return true;
    }
}


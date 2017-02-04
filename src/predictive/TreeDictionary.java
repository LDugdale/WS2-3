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
     * Root node constructor.
     * This constructor accepts a String representing the path to the dictionary file. When the class is instantiated
     * with this constructor (the root node constructor), the tree is created and populated with the valid words
     * ( words only containing letters of the alphabet ) in the file.
     *
     * @param path A string representing the path to the required dictionary file.
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
     * After the Tree is created with the root node constructor this constructor is used to create the child nodes.
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
     * Getter for words field variable
     *
     * @return words field variable.
     */
    public Set<String> getWords(){

        return this.words;
    }

    /**
     * Setter for word field variable
     * adds a word to the words Set belonging to the current node. Does not add if current node is the main root node.
     *
     * @return words field variable.
     */
    public void addWord(String word){

        if (!root) {

            this.words.add(word);
        }
    }

    /**
     * Getter for the nodes in the tree
     * Looking up the array is done using char.
     *
     * e.g.
     * 'a', 'b', 'c' = 1
     * 'd', 'e', 'f' = 2
     *
     * PRECONDITION:
     * the char must be a lower case letter of the english alphabet.
     *
     * @param c a lowercase letter of the alphabet, used to find the position in the array.
     * @return The corresponding TreeDictionary node out of the array.
     */
    public TreeDictionary getNode(char c){

        // Throw exception if node is empty.
        if (children[convertToArrayVal(c)] == null){
            throw new IllegalStateException("Trying to access an empty node");
        }

        return children[convertToArrayVal(c)];
    }

    /**
     * Getter for the nodes in the tree
     * Looking up the array is done using char.
     *
     * e.g.
     * 'a', 'b', 'c' = 1
     * 'd', 'e', 'f' = 2
     *
     * PRECONDITION:
     * the char must be a lower case letter of the english alphabet.
     *
     * @param n TreeDictionary object to add to the array of nodes.
     * @param c a lowercase letter of the alphabet, used to find the position in the array.
     */
    public void setNode(TreeDictionary n, char c){

        if (children[convertToArrayVal(c)] != null) {
            throw new IllegalStateException("Trying to set a node that already exists");
        }

        this.children[convertToArrayVal(c)] = n;
    }

    /**
     *  Main instance methods
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

    @Override
    /**
     * signatureToWords accepts a String containing numbers as a parameter representing a signature to be matched to
     * a word in the dictionary LinkedList ( e.g. if a number in the string is 2 it will be matched to "abc" ).
     * A set of all the Strings that are matched to the signature are returned.
     *
     * @param signature String of numbers representing the numbers on a keypad used for a t9 texting system
     * @return Set of Strings containing the matched words from the "words" file in the directory.
     */
    public Set<String> signatureToWords(String signature){

        // check if signature contains only the accepted characters ( 2 <= c => 9 )
        if(!isValidSignature(signature)){

            throw new IllegalArgumentException("The range of characters in the signature must be 2 <= c => 9 ");
        }

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
     * Recursive method to fetch the Set of Strings from a particular node, the words in the set are uncropped.
     * getFullWords accepts a String of numbers
     * Method continues until signature length is 0.
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
     * convertToArrayVal is used for converting a character ( including and between a - z and A - Z) to its
     * corresponding keypad value. Used for fetching and setting nodes in the array.
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

    /**
     * isValidWord checks if a given String contains only chars including and between a - z and A - Z.
     * if another char is found method returns false else it returns true.
     *
     * @param word String of any length or type
     * @return boolean true if all chars are including and between a - z and A - Z
     */
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

    /**
     * isValidWord checks if a given String contains only chars including and between a - z and A - Z.
     * if another char is found method returns false else it returns true.
     *
     * @param word String of any length.
     * @return boolean true if all chars are including and between a - z and A - Z
     */
    private static boolean isValidSignature(String word){

        // loop through the chars in the String word
        for (char c : word.toCharArray()) {
            // if char is not between a-z and A-Z return false
            if(c >= '2' && c <= '9') {
                return true;
            }
        }

        return false;
    }
}


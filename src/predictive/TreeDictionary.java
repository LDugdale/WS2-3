package predictive;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class TreeDictionary {

    private boolean root;
    private TreeDictionary parent;
    private TreeDictionary[] children;
    private boolean isLeaf;
    private boolean isWord;     //Does this node represent the last character of a word
    private char character;     //The character this node represents
    private Set<String> words;

    /**
     * Root node constructor
     */
    public TreeDictionary()
    {
        children = new TreeDictionary[8];
        words = new HashSet<>();
        this.character = character;
    }



    public TreeDictionary(String path){
        children = new TreeDictionary[8];
        isLeaf = true;
        isWord = false;
        root = true;

        try( Scanner in = new Scanner( new File(path) ) ){

            while ( in.hasNextLine() ) {
                String word = in.nextLine();
                addWord(word, word);
            }

        } catch(IOException e){
            System.err.println("Got an IOException: " + e.getMessage());
        }


    }

    /*********************************************************************/

    public Set<String> getWords(){
        return this.words;
    }

    /**
     *
     * @param c
     * @return
     */
    public static int convertToArrayVal(char c) {

        if ( c- 'a' == 18 || c - 'a' == 21  || c - 'a' == 24 || c - 'a' == 25) {
            return ((c - 'a') - ((c - 'a') % 3)) / 3 - 1;
        } else {
            return ((c - 'a') - ((c - 'a') % 3)) / 3;
        }
    }

    /**
     * Adds a word to this node. This method is called recursively and
     * adds child nodes for each successive letter in the word, therefore
     * recursive calls will be made with partial words.
     * @param word the word to add
     */
    public void addWord(String word, String nodeWord) {
        if(word.length() == 0 ){
            return;
        }
        int pos = convertToArrayVal(word.charAt(0));
        if (children[pos] == null) {
            children[pos] = new TreeDictionary();
            children[pos].parent = this;
        }
        if (!root) {
            words.add(nodeWord);
        }

//        System.out.println(pos);
//        System.out.println(nodeWord);

        children[pos].addWord(word.substring(1), nodeWord);



    }

    /**
     * Returns the child TrieNode representing the given char,
     * or null if no node exists.
     * @param c
     * @return
     */
    public TreeDictionary getNode(char c) {


        return children[convertToArrayVal(c)];
    }

    public Set<String> signatureToWords(String signature){
        //System.out.println("length:   " + signature.length());
        if(signature.length() == 0){

            return getWords();
        } else {
            int pos = (signature.charAt(0)-'0') - 2;
            System.out.println("position: " + pos);
            System.out.println(getWords());
            return children[pos].signatureToWords(signature.substring(1));
        }

    }

}


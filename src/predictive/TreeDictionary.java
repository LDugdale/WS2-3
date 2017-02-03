package predictive;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TreeDictionary {

    private TreeDictionary parent;
    private TreeDictionary[] children;
    private boolean isLeaf;
    private boolean isWord;     //Does this node represent the last character of a word
    private char character;     //The character this node represents

    /**
     * Root node constructor
     */
    public TreeDictionary()
    {
        children = new TreeDictionary[8];
        isLeaf = true;
        isWord = false;
    }

    /**
     * Constructor for child node.
     */
    public TreeDictionary(char character)
    {
        this();
        this.character = character;
    }

    public TreeDictionary(String path){
        children = new TreeDictionary[8];
        isLeaf = true;
        isWord = false;

        try( Scanner in = new Scanner( new File(path) ) ){

            while ( in.hasNextLine() ) {
                String word = in.nextLine();
                addWord(word);
            }

        } catch(IOException e){
            System.err.println("Got an IOException: " + e.getMessage());
        }


    }

    /*********************************************************************/

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
    public void addWord(String word)
    {
        isLeaf = false;
        int pos = convertToArrayVal(word.charAt(0));

        if (children[pos] == null) {
            children[pos] = new TreeDictionary(word.charAt(0));
            children[pos].parent = this;
        }

        if (word.length() > 1) {
            children[pos].addWord(word.substring(1));
        } else {
            children[pos].isWord = true;
        }
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

    /**
     * Returns a List of String objects which are lower in the
     * hierarchy that this node.
     * @return
     */
    public List getWords()
    {
        //Create a list to return
        List list = new ArrayList();

        //If this node represents a word, add it
        if (isWord) {
            list.add(toString());
        }

        //If any children
        if (!isLeaf)
        {
            //Add any words belonging to any children
            for (int i=0; i<children.length; i++) {
                if (children[i] != null) {
                    list.addAll(children[i].getWords());

                }

            }

        }

        return list;

    }



    /**

     * Gets the String that this node represents.

     * For example, if this node represents the character t, whose parent

     * represents the charater a, whose parent represents the character

     * c, then the String would be "cat".

     * @return

     */

    public String toString()

    {

        if (parent == null) {

            return "";

        }

        else  {

            return parent.toString() + new String(new char[] {character});

        }

    }

}

///**
// *
// */
//public class Tree {
//
//    private  boolean empty;
//    private List<String> values = new LinkedList<>();
//    private Tree[] children = new Tree[8];
//
//    public Tree(){
//        this.empty = true;
//
//    }
//
//    public Tree(boolean test) {
//        this.empty = test;
//        Arrays.fill(this.children, new Tree());
//    }
//
//    /***************************************************************/
//

//
//    public Tree addChild(char c){
//
//        int pos = convertToArrayVal(c);
//        return this.children[pos] = new Tree();
//    }
//
//    public Tree getChild(char c){
//
//        int pos = convertToArrayVal(c);
//        return this.children[pos];
//    }
//
//    public boolean childIsEmpty(char c){
//        int pos = convertToArrayVal(c);
//        return(this.children[pos] == null);
//    }
//
//    public void setValues(String word){
//        values.add(word);
//    }
//
//    public List<String> getValues(String word){
//        return this.values;
//    }
//
//    public boolean isEmpty(){
//        return this.empty;
//    }
//
//    /*****************************************************************************/
//
//    public String addWord(Tree a, String word, String wordIterator){
//
//        if(word.length() == 0){
//
//            a.setValues(word);
//            return wordIterator;
//        } else if (this.children.length == 0){
//
//            a.setValues(word);
//            return addWord(a.addChild(wordIterator.charAt(0)), word, wordIterator.substring(1));
//        } else {
//
//           // a.setValues(word);
//            return addWord(a.getChild(wordIterator.charAt(0)), word, wordIterator.substring(1));
//        }
//
//
//    }
//
//
//}

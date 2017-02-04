package predictive;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class TreeDictionary {

    private boolean root;
    private TreeDictionary[] children;
    private Set<String> words;

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
    public Set<String> getWords(){

        return this.words;
    }

    public void addWord(String word){

        if (!root) {

            this.words.add(word);
        }
    }

    public TreeDictionary getNode(char c){

        return children[convertToArrayVal(c)];
    }

    public void setNode(TreeDictionary n, char c){

        this.children[convertToArrayVal(c)] = n;
    }

    /**
     *  Instance methods
     */

    public void addToTree(String word, String nodeWord){

        if(word.length() == 0 ){

            return;
        }

        char c = word.charAt(0);

        if (getNode(c) == null) {

            System.out.println("word: " + word);
            setNode(new TreeDictionary(), c);
            getNode(c).addWord(word);
        } else if (word.length() > 0) {
            System.out.println("word: " + word);
            getNode(c).addWord(word);
        }


        getNode(c).addToTree(word.substring(1), nodeWord);
    }

    public Set<String> signatureToWords(String signature){
//        int length = signature.length() - 1;
//
//        Set<String> values = new HashSet<>();
//        for (int i = 0; i <= length; i++) {
//
//            if(i == length ){
//                values = this.children[i].getWords();
//            }
//        }
//
//
//        return values;
        if(signature.length() == 0){

            return getWords();
        } else {

            int pos = (signature.charAt(0)-'0') - 2;
            return children[pos].signatureToWords(signature.substring(1));
        }

    }

    private int convertToArrayVal(char c){

        // if c - 'a' is equal to 18, 21, 24, 25
        if ( c- 'a' == 18 || c - 'a' == 21  || c - 'a' == 24 || c - 'a' == 25) {

            return ((c - 'a') - ((c - 'a') % 3)) / 3 - 1;
        } else {

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

        return true;
    }
}


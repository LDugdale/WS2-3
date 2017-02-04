package predictive;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class TrieNode
    {
        private TrieNode parent;
        private TrieNode[] children;
        private boolean isLeaf;     //Quick way to check if any children exist
        private boolean isWord;     //Does this node represent the last character of a word
        private char character;     //The character this node represents

        /**
         * Constructor for top level root node.
         */
        public TrieNode(String path)
        {
            children = new TrieNode[26];
            isLeaf = true;
            isWord = false;
            try( Scanner in = new Scanner( new File(path) ) ){

                while ( in.hasNextLine() ) {

                    String word = in.nextLine();
                    if(isValidWord(word)) {
                        word = word.toLowerCase();
                        addWord(word);
                    }
                }

            } catch(IOException e){

                System.err.println("Got an IOException: " + e.getMessage());
            }

        }

        /**
         * Constructor for child node.
         */
        public TrieNode(char character)
        {
            children = new TrieNode[26];
            isLeaf = true;
            isWord = false;
            this.character = character;
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
            int charPos = word.charAt(0) - 'a';

            if (children[charPos] == null)
            {
                children[charPos] = new TrieNode(word.charAt(0));
                children[charPos].parent = this;
            }

            if (word.length() > 1)
            {
                children[charPos].addWord(word.substring(1));
            }
            else
            {
                children[charPos].isWord = true;
            }
        }

        /**
         * Returns the child TrieNode representing the given char,
         * or null if no node exists.
         * @param c
         * @return
         */
        public TrieNode getNode(char c)
        {
            return children[c - 'a'];
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
            if (isWord)
            {
                list.add(toString());
            }

            //If any children
            if (!isLeaf)
            {
                //Add any words belonging to any children
                for (int i=0; i<children.length; i++)
                {
                    if (children[i] != null)
                    {
                        list.addAll(children[i].getWords());

                    }

                }

            }

            return list;

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

        /**

         * Gets the String that this node represents.

         * For example, if this node represents the character t, whose parent

         * represents the charater a, whose parent represents the character

         * c, then the String would be "cat".

         * @return

         */

        public String toString()

        {

            if (parent == null)

            {

                return "";

            }

            else

            {

                return parent.toString() + new String(new char[] {character});

            }

        }

    }

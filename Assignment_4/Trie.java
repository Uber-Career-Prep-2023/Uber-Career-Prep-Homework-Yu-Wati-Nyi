public class Trie {
    
    public static int ALPHABET_SIZE = 26;

    public static class TrieNode{
        TrieNode children[] = new TrieNode[ALPHABET_SIZE];

        //valid is true if the node represents end of a word
        boolean validWord;

        public TrieNode(){
            validWord = false;
            for(int i = 0; i< ALPHABET_SIZE; i++){
                children[i] = null;
            }
        }
    }

    public static TrieNode root = new TrieNode();

    public static void insert(String word){

        int level;
        int length = word.length();
        int index;

        TrieNode current = root; //why is this necessary? 

        for(level = 0; level< length; level++ ){
            index = word.charAt(level) - 'a';
            if(current.children[index] == null)
                current.children[index] = new TrieNode();
            current = current.children[index];
        }

        //mark the last node as leaf
        current.validWord = true;
    }
    //Returns true if key presents in trie, else false
    public static Boolean isValidWord(String word){
        int level;
        int length = word.length();
        int index;
        TrieNode current = root;

        for(level = 0; level<length; level ++){
            index = word.charAt(level) - 'a';

            if(current.children[index] == null){
                return false;

            }
            current = current.children[index];
        }
        return current.validWord;
    }
    public static Boolean isEmpty(TrieNode root){
        for(int i = 0; i< ALPHABET_SIZE; i++){
            if(root.children[i] != null){
                return false;
            }

        }
        return true;
    }
    public static void remove(String word){
        removeHelper(word, root, 1);
    }
    public static void removeHelper(String word, TrieNode root, int depth){

        //if root is empty
        if(root == null){
            return;
        }

        //if the last character of the word is being processed
        if(depth == word.length()){
            
            //the character is no longer the end of the word
            if(root.validWord){
                root.validWord = false;
            }
            //if the character is not a prefix of any other word
            if(isEmpty(root)){
                root = null;
            }
        }
        //it it is not the last character, recur for the child obtained using ASCII code
        int index = word.charAt(depth) - 'a';
        removeHelper(word, root.children[index], depth+1);

        // If root does not have any child (its only child got
        // deleted), and it is not end of another word.
        if (isEmpty(root) && root.validWord == false){
            root = null;
        }
 
        return;

    }
    // Driver
    public static void main(String args[])
    {
        // Input keys (use only 'a' through 'z'
        // and lower case)
        String keys[] = { "the", "a", "there",
                        "answer", "any", "by",
                        "bye", "their", "hero", "heroplane" };
        int n = keys.length;
 
        //TrieNode root = new TrieNode();
 
        // Construct trie
        for (int i = 0; i < n; i++)
            insert(keys[i]);
 
        // Search for different keys
        if(isValidWord("the"))
            System.out.println("Yes");
        else
            System.out.println("No");
 
        if(isValidWord("these"))
            System.out.println("Yes");
        else
            System.out.println("No");
 
        remove("heroplane");
         
        if(isValidWord("hero"))
            System.out.println("Yes");
        else
            System.out.println("No");
 
    }

}

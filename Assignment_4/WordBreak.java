public class WordBreak {
    /**
     * Given a string of characters without spaces and a dictionary of valid words, determine if it can be broken into a list of valid words by adding spaces. 

        Dictionary:


        Elf
        Go
        Golf
        Man
        Manatee
        Not
        Note
        Pig
        Quip
        Tee
        Teen


        Input: mangolf
        Output: True (“man”, “golf”)

        Input: manateenotelf
        Output: True (“manatee”, “not”, “elf”)

        Input: quipig
        Output: False

        *************************************************************************************************

        Method: Trie

        Time Complexity: O(n)
        
        Space Complexity: O(n*m), where n is the number of words, and m is the number of nodes

        time-taken: about 45 minutes

     */

    public static class TrieNode{

        int ALPHABET_SIZE = 26;
        TrieNode[] children;
        Boolean validWord;

        public TrieNode(){
            children = new TrieNode[ALPHABET_SIZE];
            for(int i = 0; i< ALPHABET_SIZE; i++){
                children[i] = null;
            }
            validWord = false;
        }
    }

    public static TrieNode rootDict = new TrieNode();

    //insert all dictionarys into Trie
    public static void wordDictHelper(String[] wordDictList){

        for(String word: wordDictList){

            word = word.toLowerCase();
            int index; 
            TrieNode current = rootDict;

            for(int i = 0; i< word.length(); i++){
                index = word.charAt(i) - 'a';
                if(current.children[index] == null){
                    current.children[index] = new TrieNode();
                }
                current = current.children[index];
            }
            current.validWord = true;
        }
    }

    public static Boolean wordBreak(String wordCombo, String[] wordDictList){

        wordDictHelper(wordDictList);

        //not capitalized boolean
        boolean[] dp = new boolean[wordCombo.length()];
        for(int ch = 0; ch < wordCombo.length(); ch ++){
            if(ch == 0 || dp[ch-1]){
                int index;
                TrieNode current = rootDict;
                for(int i = ch; i< wordCombo.length(); i++){
                    //check if the word is valid or not with each character, as soon as it is valid 
                    index = wordCombo.charAt(i) - 'a';
                    if(current.children[index] == null){
                        break; 
                    }
                    current = current.children[index];
                    if(current.validWord){
                        dp[i] = true;
                    }
                }
            }
        }

        return dp[wordCombo.length() - 1];

    }

    public static void main(String[] args) {
        
        String[] inputDict  = { "Elf", "Go","Golf","Man", "Manatee", "Not", "Note", "Pig", "Quip", "Tee","Teen"};

        String wordCombo = "manateenotelf";

        System.out.println(wordBreak(wordCombo, inputDict));
    }

}

import java.util.ArrayList;

public class Boggle {
    /**
     * Time Taken: 40 min
     * 
     * Time Complexity: O(n)
     * 
     * Space Complexity: O(n * m) for keeping a Trie
     * 
     * Method: Trie
     */
    //initiate a TrieNode nested class
    public static int ALPHABET_SIZE = 25;

    public static class TrieNode{
        TrieNode[] children = new TrieNode[ALPHABET_SIZE];
        Boolean isValidWord;

        public TrieNode(){
            isValidWord = false;
            for(int i = 0; i< ALPHABET_SIZE; i++){
                children[i] = null;
            }
        }
    }

    //Initialize board Trie
    public static TrieNode board = new TrieNode();
    public static int[] simpleBoard = new int[25];
    /**
     * boggle function
     * initiate a TrieNode and insert all elements from the board into the TrieNode
     * @param ArrayList<String> dictionary
     * @param TrieNode the root of the board
     * @param ArrayList<String> board
     * @return ArrayList<String> output existing words in board
     */
    public static ArrayList<String> boggle(String[] dictionary, char[] inboard){
        ArrayList<String> output = new ArrayList<>();


       
        //put all board words into Trie
        for(int i = 0; i< inboard.length; i++ ){
            int index = inboard[i] - 'a';
            if(simpleBoard[index] == 0){
                simpleBoard[index] = 1;
            }
            
        }
        //check if words in dictionary are also in board
        for(String word: dictionary){
            if(searchHelper(word, simpleBoard)){
                output.add(word);
            }
        }
        return output;
    }
    
    /**
     * search helper
     * @param String dictionary word
     * @param TrieNode board
     */
    public static Boolean searchHelper(String dictWord, int[] board2){
        
        // TrieNode current = board2;
        String lowerDictWord = dictWord.toLowerCase();
        for(int i = 0; i< lowerDictWord.length(); i++){
            int index = lowerDictWord.charAt(i) - 'a';
            if(simpleBoard[index] == 0){
                return false;
            }
            // current = current.children[index];
        }
        return true;
    }

    /*
     * main
     */
    public static void main(String[] args) {
        
        String[] dictionary = {"Ace","Ape","Cape","Clap","Clay","Gape","Grape","Lace","Lap","Lay","Mace","Map","May","Pace","Pay","Rap","Ray","Tap","Tape","Trace","Trap","Tray","Yap"};
        char[] board = {'A','D','E','R','C','P','L','A','Y'};
        char[] lowercaseChars = new char[board.length];

        for (int i = 0; i < board.length; i++) {
            lowercaseChars[i] = Character.toLowerCase(board[i]);
        }

        System.out.println(boggle(dictionary, lowercaseChars).toString());
    }
    


}

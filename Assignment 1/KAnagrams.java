import java.util.HashMap;
/**
 * Yu Wati Nyi
 * Question 7
 * Time Complexity:
 * Space Complexity:
 */
public class KAnagrams {
/**
 * Two Strings are considered to be "k-anagrams" if they can be made into
 * chaning at most k characters in one of the strings. Given two strings
 * and an integer k, determine if they are k-anagrams.
*/ 

public Boolean kAnagrams(String input1, String input2, int k){

    //create array checker to prevent double count
    Boolean[] newArray = new Boolean[input1.length()];
    Boolean[] newArray2 = new Boolean[input1.length()];
    //populate newArray with true
    for(int i = 0; i< newArray.length; i++){
        newArray[i] = true;
        newArray2[i] = true;
    }
    //create new Hashmap
    HashMap<Character, Character> newMap = new HashMap<>();

    //if(input1.length() == input2.length()){
    for(int i = 0; i< input1.length(); i++){
        for(int j = 0; j< input2.length(); j++){
            if (input1.charAt(i) == input2.charAt(j) && newArray2[j] == true){
                newMap.put(input1.charAt(i), input2.charAt(j));
                //newArray[i] = false;
                newArray2[j] = false;
                break;
            }
        }
    }

    int count = input1.length() - newMap.size();

    if(count == k){
        return true;
    }
    else{
        return false;
    }
    
}
public static void main(String[] args){

    KAnagrams solution7 = new KAnagrams();
    String input1 ="debit curd";
    String input2 = "bad credit";
    int k = 1;
    Boolean ans = solution7.kAnagrams(input1, input2, k);

    System.out.println(ans);


}
/**
 * time taken: 40 min
 * 
 * note:
 * "bad credit' and 'debit curd' test did not work
 */

}

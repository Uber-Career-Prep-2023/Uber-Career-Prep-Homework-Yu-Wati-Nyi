import java.util.ArrayList;
/**
 * Yu Wati Nyi
 * Question 5
 * Time Complexity: O(n^3)
 * Space Complexity: 
 */

public class ShortestSubString {
/**
 * Given a string a a second string representing required characters, return the length of the shortest substring containing all the required characters
 */ 


 //Helper Method to make a string from an Array List of Characters
 public String CharacterstoString(ArrayList<Character> input){
    StringBuilder sb = new StringBuilder();

    for(Character a: input){
        sb.append(a);
    }

    String newString = sb.toString();
    return newString;
 }


 public int shortestsubstring(String input, String inputCheck){
    
    
    ArrayList<Character> stringHolder = new ArrayList<Character>();
    
    String outputString = "";

    int[] counter = new int[inputCheck.length()];
    int size = 100;

    
    for(int k = 0; k< input.length(); k++){
        counter = new int[inputCheck.length()];
        
        for(int i = 0 +k ; i< input.length(); i++){
            
            int count = 0;
            for(int j =0; j< inputCheck.length(); j++){
                if(input.charAt(i)== inputCheck.charAt(j) && counter[j] <1 ){
                    counter[j]++;
                    break;
                }
            }
            for(int j =0; j< inputCheck.length(); j++){

                if(counter[j] > 0){
                    count++;
                }
            }
            stringHolder.add(input.charAt(i));
            
            if (count == inputCheck.length()){
                
                if(stringHolder.size() < size){
                    outputString = CharacterstoString(stringHolder);

                    size = outputString.length();
                }
                stringHolder.clear();
                
                break;
                

            }
            
            
        }
       
    }
    

    return outputString.length();
 }
 public static void main(String[] args){

    ShortestSubString solution5 = new ShortestSubString();
    String inputString ="abracadabra";
    String inputCharacters = "abc";
    int ans = solution5.shortestsubstring(inputString, inputCharacters);

    System.out.println(ans);


}


}
/**
 * Time Taken: 2 hours 
 * 
 * 
 * 
 */

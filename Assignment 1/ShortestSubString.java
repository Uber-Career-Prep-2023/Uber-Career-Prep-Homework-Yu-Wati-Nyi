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
    
    //create arraylist to hold each substring
    ArrayList<Character> stringHolder = new ArrayList<Character>();
    
    //string to hold shortest string
    String outputString = "";

    //array to keep track of occurences of each character in the input check string
    int[] counter = new int[inputCheck.length()];
    int size = 100; // initial size

    //start new substring with starting point one index later
    for(int k = 0; k< input.length(); k++){
        counter = new int[inputCheck.length()]; //set all occurences to zero
        
        for(int i = 0 +k ; i< input.length(); i++){ //loop through input
            
            int count = 0;
            for(int j =0; j< inputCheck.length(); j++){ 
                if(input.charAt(i)== inputCheck.charAt(j) && counter[j] <1 ){ //iterate if there is an occurence and less than one so that there is no double count
                    counter[j]++;
                    break;
                }
            }
            for(int j =0; j< inputCheck.length(); j++){ //count which characters in inputcheck are included

                if(counter[j] > 0){
                    count++;
                }
            }
            stringHolder.add(input.charAt(i)); //add character to arraylist
            
            if (count == inputCheck.length()){ //if all characters in inputCheck are included in that order
                
                if(stringHolder.size() < size){//update with new shortest string
                    outputString = CharacterstoString(stringHolder); //make a string

                    size = outputString.length();// set new size for comparison
                }
                stringHolder.clear(); //clear the arraylist to repeat process with new substrings
                
                break; //start at next k value, do not go through the remaining substrings in current k value
                

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

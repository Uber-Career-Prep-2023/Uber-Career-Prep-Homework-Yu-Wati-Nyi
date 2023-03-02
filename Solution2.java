import java.util.ArrayList;

/**
 * Yu Wati Nyi
 * Question 2: Reverse Vowels
 */
public class Solution2 {


    public String reverseVowels(String input){

        char[] inputArray = input.toCharArray();
        
        ArrayList<Integer> vowels = new ArrayList<Integer>();

        char[] newVowels;

        char[] vowellist = {'a','A','e','E','i','I','o','O','u','U'};

        for(int i = 0; i< inputArray.length; i++){

            for(char a: vowellist){
                if(inputArray[i] == a){
                    vowels.add(i);
                }
            }
        }
        newVowels = new char[vowels.size()];
        for(int i = 0; i< vowels.size(); i++){
                newVowels[i] = inputArray[vowels.get(vowels.size()-1-i)];
 
        }

        for(int i = 0; i< newVowels.length; i++){

            inputArray[vowels.get(i)] = newVowels[i];

        }

        String outputString = String.valueOf(inputArray);

        return outputString;
       
    }
    public static void main(String[] args){

        Solution2 solution = new Solution2();
        String inString = "flominga";
        String ans = solution.reverseVowels(inString);
        System.out.println(ans);

    }
    /**
     * Total Time: 40 min
     * 
     */
    
}

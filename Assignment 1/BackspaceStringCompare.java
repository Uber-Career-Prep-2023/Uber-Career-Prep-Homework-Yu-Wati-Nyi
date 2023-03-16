/**
 * Yu Wati Nyi
 * Question 4
 * Time Complexity 
 * Space Complexity
 */
import java.util.ArrayList;
public class BackspaceStringCompare {
    
    public String backspacestring(String input){

        // String outpString = "";
        // for(int i = 0; i< input.length(); i++){
        //     if(input.charAt(i)=='#'){
        //         outpString = input.replace(input.charAt(i),"" );
        //     }
        // }
        char[] inputArray = input.toCharArray();

        ArrayList<Character> characterInput = new ArrayList<>();

       

        for(int i = 0; i< input.length(); i++){

            if(inputArray[i] == '#'){
                inputArray[i-1] = ' ';
                inputArray[i] = ' ';
            }
            
        }

        String outputString = inputArray.toString();

        return outputString;



}

    public static void main(String[] args){

        BackspaceStringCompare solution = new BackspaceStringCompare();

        String inputString = "u#Uber Careee#r Prep";

        String answer = solution.backspacestring(inputString);

        System.out.println(answer);

    }
}
/**
 * Time Taken: 40 min
 * Note: Incomplete
 * 
 */

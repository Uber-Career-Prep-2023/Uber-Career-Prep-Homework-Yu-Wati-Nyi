import java.util.HashMap;
/**
 * Yu Wati Nyi
 * Question 6
 * Time Complexity: 
 * Space Complexity:
 */
public class MissingInteger {
/*Given an integer n and a sorted array of integers of size n-1 which 
contains all but one the integers in the range 1-n,find the missing int */

public int missinginteger(int[] inputArray, int arraySize){
    
    //create array of size n
    int[] newArray = new int[arraySize];
    for(int i = 0; i< arraySize; i++){//populate array
        newArray[i] = i+1;
    }

    HashMap<Integer,Integer> newMap = new HashMap<>();

    //match key with value if value exists in input Array
    for(int i =0; i< newArray.length; i++){
        for(int j = 0; j< inputArray.length; j++){
            if(inputArray[j] == newArray[i]){
                newMap.put(newArray[i], inputArray[j]);
            }
        }
    }

    int missingInteger = 0;
    //find key without a value
    for(int i =0; i< newArray.length; i++){
        if(!newMap.containsValue(newArray[i])){
            missingInteger = newArray[i];
        }
    }

    return missingInteger;

}

public static void main(String[] args){

    MissingInteger solution6 = new MissingInteger();
    int[] input = {1, 2, 3, 4, 5, 6, 7, 8, 10, 11, 12};
    int arraySize = 12;
    int ans = solution6.missinginteger(input, arraySize);

    System.out.println(ans);


}
/**
 * Time taken: 30 minutes
 */

}


import java.util.Arrays;
/**
 * Yu Wati Nyi
 * Question 9
 * Time Complexity: 
 * Space Complexity: 
 */

public class DedupArray {

    public int[] dedupArray(int[] inputArray){
        
        //int i = 0;
        int index = inputArray.length;
        boolean check = false;
        for(int i = 0; i < index; i++){
            int k = i+1;
            if(inputArray[i] == inputArray[k]){
                check = true;
            }
            while(check){
    
                for(int j = k+1; j< inputArray.length; j++ ){
                    inputArray[j-1] = inputArray[j];
                }
                inputArray[inputArray.length-1] = -1;
                index--;

                check = inputArray[i] == inputArray[k];
            }
            continue;
        }

        return inputArray;
    }

    public static void main(String[] args){
        DedupArray solution9 = new DedupArray();

        int[] inputArray = {1, 2, 2, 3, 3, 3, 4, 4, 4, 4};

        int[] ans = solution9.dedupArray(inputArray);

        System.out.println(Arrays.toString(ans));
    }   
}
/**
 * time taken: 40 minutes
 */

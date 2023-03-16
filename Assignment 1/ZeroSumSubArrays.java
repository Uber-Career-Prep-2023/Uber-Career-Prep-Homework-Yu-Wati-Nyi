import java.util.ArrayList;
/**
 * Yu Wati Nyi
 * Question 3
 * Time Complexity:
 * Space Complexity: 
 * 
 */


public class ZeroSumSubArrays {
    
    ArrayList<Integer> subArray = new ArrayList<Integer>();

    public int zeroSum(int[] inputArray){

        //loop through the input and continue to add
        int len = inputArray.length;
        int count = 0;
        for(int j = 0; j < len; j++){
            for(int k = 0; k<len; k++){
                int sum = 0;
                for(int i = j; i< len-k; i++){
                    sum = sum + inputArray[i];
                }
                if(sum == 0){
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args){

        ZeroSumSubArrays solution = new ZeroSumSubArrays();
        int[] input = {5, 2, -1, -3, -3};
        int ans = solution.zeroSum(input);

        System.out.println(ans);


    }
}
/* 
time taken: 50 minutes
problems:
sum sets to zero at unwanted times
whether the element is zero has not been tested
*/

/**
 * Yu Wati Nyi
 * Question 10
 * Time Complexity: 
 * Space Complexity:
 * 
 */
public class TwoSum {
/*
Given an array of integers and a target integer k, return the number of pairs of integers in 
the array that sum to k. In each pair, the two items must be distinct elements
(come from different indices in the array)
 */

    public int twoSum(int[] inputArray, int k) {

        int[] ans = new int[2];
        int count = 0;

        //loop through the array 
            //loop again with pointer on the index with 
        for(int i = 0; i< inputArray.length; i++){
            for(int j = i+1; j< inputArray.length; j++){
                if(inputArray[i]+ inputArray[j] == k){
                    ans[0] = i;
                    ans[1] = j;
                    count++;
                }
            }
        }
        return count;
        
    }

    public static void main(String[] args){
        TwoSum solution10 = new TwoSum();

        int[] inputArray = {1, 10, 8, 3, 2, 5, 7, 2, -2, -1};
        int k = 9;

        int ans = solution10.twoSum(inputArray, k);

        System.out.println(ans);
    }

}
/*
 * time taken: 10 minutes
 */

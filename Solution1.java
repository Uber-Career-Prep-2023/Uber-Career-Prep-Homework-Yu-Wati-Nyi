/**
 * Yu Wati Nyi
 * Question 1
 * Time Complexity: O(n^2)
 * Space Complexity: I do not know how to find space complexity
 */
public class Solution1{

    /**
     * helper method to find subarray
     * @param start
     * @param k
     * @param array
     * @return
     */
    public int[] sliceArray(int start, int k, int[] array){
        int[] sliced = new int[k];
        for(int i = 0; i< sliced.length; i++){
            sliced[i] = array[start+i];
        }
        return sliced;
    }

    /**
     * Find the maximum mean of a subarray of size k
     * @param inputArray
     * @param k
     * @return
     */
    public double maxMeanSub(int[] inputArray, int k){

        int maxSum = 0;
        int sum =0;
        //loop through the input array
        for(int i= 0; i + k< inputArray.length; i++){
            sum = 0;
            //make subarrays of k size
            int[] section = sliceArray(i, k, inputArray);
            //loop through each subarray
            for(int j =0; j< section.length; j++){
                //find the sum
                sum = sum + section[j];
                //System.out.println(sum);
                //update the maximum sum
                if (maxSum< sum){
                    maxSum = sum;
                    //System.out.println(maxSum);
                }
            }

        }

        //calculate the mean of the maximum sum
        double mean =0;
        mean = (double) maxSum/k;

        return mean;
    }

    //main method to test test cases
    public static void main(String[] args){

        Solution1 assignment = new Solution1();
        int[] input = {1, 1, 1, 1, -1, -1, 2, -1, -1, 6};
        double mean = assignment.maxMeanSub(input, 5);
        
        System.out.println(mean);

    }
}
/**
 * Total time: 40 minutes
 * 
 * Note: 
 * Does not round to 1
 * 
 */
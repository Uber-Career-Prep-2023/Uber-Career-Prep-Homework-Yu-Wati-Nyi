import java.util.HashMap;

public class MinCostStairClimbing {
    /*
     * A staircase on a hiking trail implements a rather unusual toll system to cover trail maintenance costs. 
     * Each stair in the staircase has a different toll which you only have to pay if you step on that stair. 
     * Due to the height of the stairs, you can only climb one or two stairs at once. 
     * This means that from the ground you must initially step on either stair 0 or stair 1 and that, 
     * if there are n stairs, the last stair you step on can be either stair n-1 or n-2. 
     * Given an array representing the costs per stair, what is the minimum possible toll you can pay to climb the staircase?

        Examples:
        Input: [4, 1, 6, 3, 5, 8]
        Output: 9 (step on stairs 1, 3, 4 for a cost of 1+3+5)

        Input: [11, 8, 3, 4, 9, 13, 10]
        Output: 25 (step on stairs 1, 3, 5 for a cost of 8+4+13)
    
        *************************************************************************

        Method: Dynamic Programming top-down 

        Time Complexity: O(N)

        Space Complexity: O(N)

        Time-Taken: 45 min

     */
    private static HashMap<Integer, Integer> memo = new HashMap<Integer, Integer>();

    public static int minCostStairClimbing(int[] input){
        return minCostHelper(input.length, input);
    }

    public static int minCostHelper(int i, int[] input){
        //base case is step 0 and step 1
        if(i<=1){
            return 0;
        }
        //Check if we have already calculated min cost
        if(memo.containsKey(i)){
            return memo.get(i);
        }

        // If not, cache the result in our hash map and return it
        int downOne = input[i - 1] + minCostHelper(i - 1, input);
        int downTwo = input[i - 2] + minCostHelper(i - 2, input);
        memo.put(i, Math.min(downOne, downTwo));
        return memo.get(i);
    }

    public static void main(String[] args) {
        //test case
        int[] input = {11, 8, 3, 4, 9, 13, 10};

        System.out.println(minCostStairClimbing(input));

        
    }
}

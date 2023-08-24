public class CoinChange {
    /*
     * Given a list of coin denominations and a target sum, return the number of possible ways to make change for that sum.

        Examples:
        Input:
        Coins: [2, 5, 10]

        Sum: 20
        Output: 6 (Options are: 10 2s; 4 5s; 2 10s; 5 2s & 2 5s; 5 2s & 1 10; 2 5s & 1 10)

        Sum: 15
        Output: 3 (Options are: 5 2s & 1 5; 1 5 & 1 10; 3 5s)


        APPROACH

        have a list of possible combinations
        return the size

        how to find possible combinations?

        recursion? 

        basecase? 

        bottom up approach, recurse function will return the sum of the coins
        
        if sum of combinations > 0, then return 0

        if the sum of combination == amount , then add to list might not need a list -> actually need a list, so that there is no repetition

        sum = coin[i] + recurse(coin)

        *****************************************************

        Method: Back Tracking

        Time Complexity: 0(2^N) -> can be improved with DP

        Space Complexity: O(N)

        Time Taken : 50 min

     */

    public static int coinChange(int[] coins, int sum){

        return coinChangeHelper(coins,0, sum,  0, 0);

    }

    public static int coinChangeHelper(int[] coins, int currSum, int sum, int count, int start){
        
        //stop if the currSum == sum
        if(currSum == sum){
            //count += 1;
            return 1; //return the count of cominations
        }
        //stop if the currSum > sum
        if(currSum > sum){
            return 0;
        }

        for(int i = start; i< coins.length; i++){
            currSum += coins[i];
            //start increments because we don't 
            count += coinChangeHelper(coins, currSum, sum, count, start + 1);
            currSum -= coins[i];

        }

        return count; 

    }

    public static void main(String[] args) {
        int[] coins = {2, 5, 10};
        int sum = 20;
        System.out.println(coinChange(coins, sum));
        //output: 6 //actual ouput 7

        int sum2 = 15;
        System.out.println(coinChange(coins, sum2));
    }

}

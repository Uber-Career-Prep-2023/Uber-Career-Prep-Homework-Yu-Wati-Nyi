import java.util.ArrayList;

public class CatalanNum {
    /*
        Time Taken: 40 minutes
        Method: Dynamic Programming
        Time Complexity: O(n square)
        Space Complexity: O(n)
        
     * The Catalan numbers are a mathematical sequence of numbers. 
     * The nth Catalan number is defined as (2n)! / (n+1)!n!.
     *  Given a non-negative integer n, return the Catalan numbers 0-n.

        Examples:
        Input: 1
        Output: 1, 1

        Input: 5
        Output: 1, 1, 2, 5, 14, 42

     */

    public static ArrayList<Integer> catalanNum(int n){
        
        ArrayList<Integer> output = new ArrayList<>();

        for(int i = 0; i< n+1; i++){
            output.add(factorialHelper(i));
        }

        return output;
    }

    public static int factorialHelper(int n){

        //Table to store the results of subproblems
        int catalan[] = new int[n+2];

        //Initialize first two values in table
        catalan[0] = 1;
        catalan[1] = 1;

        //Fill entries in catalan[]
        //using recursive formula
        
        for(int i = 2; i <= n ; i++){
            catalan[i] = 0;
            for(int j = 0; j< i; j++){
                catalan[i] += catalan[j] * catalan[i-j-1];
            }
        }

        //return last entry
        return catalan[n];
    }

    public static void main(String[] args) {
        System.out.println(catalanNum(5));
    }


}

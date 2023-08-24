public class LargestSquareOf1s {
    /**
     * Given a square matrix of 0s and 1s, find the dimension of the largest square consisting only of 1s.
     * 
     * ********************************
     * 
     * Method: Dynamic Programming
     * Time Complexity: O(n square)
     * Space Complexity: O(n * m), where n is row and m is column
     * Time Taken: 45 minutes

     */

    public static int largestSquareof1(int[][] inputMatrix){

        //if the matrix is empty, if there are no rows or columns
        if(inputMatrix == null || inputMatrix.length == 0 || inputMatrix[0].length == 0){
            return 0;
        }

        int maxDimension = 0;
        int rowLen = inputMatrix.length;
        int colLen = inputMatrix.length;

        //intialize dp array with one more row and one more column
        int[][] dp = new int[rowLen+1][colLen+1];

        //iterate through the matrix starting at [1,1]
        for(int i = 1;  i< rowLen; i++){
            for(int j = 1; j< colLen; j++){
                //check if the cell diagnol up is one
                if(inputMatrix[i][j] == 1){
                    //make the [i,j] in dp array store the edge dimension diagonal up left, up, left
                    dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1])) + 1;
                    //find the largest edge diminesion by comparing with exisitng max and current storage
                    maxDimension = Math.max(maxDimension, dp[i][j]);
                }
                else{
                    continue;
                }
            }
        }

        // //Visualizing
        // // Loop through all rows
        // for (int[] row : inputMatrix)
        //     System.out.println(Arrays.toString(row));

        // // Loop through all rows
        // for (int[] row : dp)
        //     System.out.println(Arrays.toString(row));

        return maxDimension;

    }
    public static void main(String[] args) {
        
        //test 1
        int[][] input1 = new int[][]{{0, 1, 0, 1},
                                     {0, 0, 1, 1}, 
                                     {0, 1, 1, 1}, 
                                     {0, 0, 1, 1}};

        System.out.println(largestSquareof1(input1)); //output 2

        //test 2

        int[][] input2 = new int[][]{{0, 1, 0, 1, 1},
                                     {0, 0, 1, 1, 1}, 
                                     {1, 1, 1, 1, 1},
                                     {1, 1, 1, 1, 1},
                                     {0, 1, 1, 0, 0}};

        System.out.println(largestSquareof1(input2)); //output 3

    }


}

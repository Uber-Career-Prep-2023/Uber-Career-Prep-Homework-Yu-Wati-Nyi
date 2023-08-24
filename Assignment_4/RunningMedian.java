public class RunningMedian {
/**
 * 
 * Time taken: 20 min
 * Method: Multiple Query Problems: Amortize Pre-Processing
 * Time Complexity; O(nlogn) because of sorting
 * Space Complexity: O(1)
You will be given a stream of numbers, one by one. After each new number, return the median of the numbers so far.

Examples (newest number at each step in bold):
Input: 1
Output: 1

Input: 1, 11
Output: 6

Input: 1, 11, 4
sorted: 1, 4, 11
Output: 4

Input: 1, 11, 4, 15
Sorted: 1, 4, 11, 15
Output: 7.5

Input: 1, 11, 4, 15, 12
Output: 11


pseudo
note - returns float not integer or double? 
- is the input a double or integer? 

sort the array 
find the mid using binary search
base case is 
when front == last - for one mid
when front > last - for two mid

*/
    public static Double runningMedian(int[] input){

        if(input.length == 0){
            return 0.0;
        }

        sortHelper(input);


        if(input.length % 2 == 0){
            return evenBinary(input, 0, input.length-1);
        }

        return oddBinary(input, 0, input.length-1);
    }

    public static int[] sortHelper(int[] input){
        int n = input.length;

        for(int i = 0; i< n-1; i++){
            int min_index = i;
            for(int j = i+1; j< n; j++){
                if(input[j] < input[min_index]){
                    min_index = j;
                }
            }

            int temp = input[min_index];
            input[min_index] = input[i];
            input[i] = temp;
        }

        return input;
    }
    public static Double oddBinary(int[] input, int start, int end){
        if(input.length == 0){
            return 0.0;
        }

        if(start == end){
            return (double)input[start];
        }

        return oddBinary(input, start+1, end-1);

        
    }

    public static Double evenBinary(int[] input, int start, int end){

        if(input.length == 0){
            return 0.0;
        }

        if(start > end){
            Double median = (double)(input[start]+input[end])/2;
            return median;
        }

        return evenBinary(input, start+1, end-1);
    }

    public static void main(String[] args) {
        
        int[] input = {1, 11};

        System.out.println(runningMedian(input));
    }


}

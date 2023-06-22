import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class FirstKBinaryNumbers {
/*
Given a number, k, return an array of the first k binary numbers, represented as strings.

Examples:
Input: 5
Output: ["0", "1", "10", "11", "100"]

Input: 10
Output: ["0", "1", "10", "11", "100", "101", "110", "111", "1000", "1001"]

Time Taken: 40 min
Method: Queue
Time Complesity: O(N)
Space Compelxity: O(1)

 */ 
    private static ArrayList<String> binaryNumbers = new ArrayList<>();

    public static ArrayList<String> generateBinaryNumbers(int k) {
        
        Queue<String> queue = new LinkedList<>();

        // Start with the first binary number
        binaryNumbers.add("0");
        queue.add("1");

        // Generate k binary numbers
        while (k > 0) {
            // Remove the front element from the queue
            String front = queue.poll();
            binaryNumbers.add(front);

            // Append "0" and "1" to the front element
            queue.add(front + "0");
            queue.add(front + "1");

            k--;
        }

        return binaryNumbers;  
    }

    public static void main(String[] args) {
        generateBinaryNumbers(5);
        for(int i= 0; i<binaryNumbers.size(); i++ ){
            System.out.println(binaryNumbers.get(i));
        }
    }
}


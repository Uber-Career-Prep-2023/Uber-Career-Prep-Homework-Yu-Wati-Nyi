import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class MergeKSortedArrays {
/*
Given an array of k sorted arrays, merge the k arrays into a single sorted array.

Examples:
Input: 2, [[1, 2, 3, 4, 5], [1, 3, 5, 7, 9]]
Output: [1, 1, 2, 3, 3, 4, 5, 5, 7, 9]

Input: 3, [[1, 4, 7, 9], [2, 6, 7, 10, 11, 13, 15], [3, 8, 12, 13, 16]]
Output: [1, 2, 3, 4, 6, 7, 7, 8, 9, 10, 11, 12, 13, 13, 15, 16]

Time Taken: 30 min
Method: Heap
Time Complexity: O(nlogn)
Space Complexity: O(n)
 */ 

public static List<Integer> mergeArrays(int k, List<List<Integer>> inputArrayLists){
    Heap newHeap = new Heap();
    ArrayList<Integer> output = new ArrayList<>();
    //put top of each array in min heap
    int[] arrayIndexlist = new int[k];
    int arrayIndex = 0;
    for(int i = 0; i< k; i++){
        newHeap.insert(inputArrayLists.get(i).get(arrayIndexlist[i])); //insert top of each array into min heap
    }
    while(!(newHeap.isEmpty())){
        output.add(newHeap.top());
        newHeap.remove();
        arrayIndex++;
        for(int i = 0; i< k; i++ ){
            if(arrayIndex < inputArrayLists.get(i).size()){
                newHeap.insert(inputArrayLists.get(i).get(arrayIndex));
            }
        }
    }
    return output;
    //move on to next element in array list 
    //put min heap into new arraylist
    //
}
public static void main(String[] args) {
    //List<List<Integer>> arrays2 = new ArrayList<>();

    List<List<Integer>> arrays2 = new ArrayList<>();
    arrays2.add(Arrays.asList(1, 4, 7, 9));
    arrays2.add(Arrays.asList(2, 6, 7, 10, 11, 13, 15));
    arrays2.add(Arrays.asList(3, 8, 12, 13, 16));

    System.out.println(mergeArrays(3, arrays2));
}
}

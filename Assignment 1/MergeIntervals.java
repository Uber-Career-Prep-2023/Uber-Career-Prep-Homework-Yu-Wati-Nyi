import java.util.ArrayList;
import java.util.Arrays;
/**
 * Yu Wati Nyi
 * Question 8
 * Time Complexity: 
 * Space Complexity: 
 */

public class MergeIntervals {
/**
 * Given a list of integer pairs representing the low and high end of an 
 * interval, inclusive, return a list in which overlapping intervals are merged
 */
public String InttoString(ArrayList<int[]> input){
    StringBuilder sb = new StringBuilder();

    for(int[] a: input){
        String b = a.toString();
        sb.append(b);
    }

    String newString = sb.toString();
    return newString;
 }

public ArrayList<int[]> mergeIntervals(ArrayList<int[]> inputList){

    for(int i = 0; i< inputList.size(); i++){
        for(int j =i+1; j< inputList.size(); j++){

            int k = inputList.get(i)[0];
            int l = inputList.get(i)[1];
            int m = inputList.get(j)[0];
            int n = inputList.get(j)[1];

            //m k n l
            if(m<= k && k<=n && n<=l){
                //make n into l
                inputList.get(j)[1] = l;
                inputList.remove(i);
                break;

            }
            //k m l n
            if(k<=m && m<=l && l<=n){
                //make m into k
                inputList.get(j)[0] = k;
                //if it is not already removed
                inputList.remove(i);
                break;

            }
            //m k l n
            if(m<=k && l<=n){
                inputList.remove(i);
                break;
            }
            //k m n l
            if(k<=m && l >=n){
                //make m into k
                inputList.get(j)[0] = k;
                //make n into l
                inputList.get(j)[1] = l;
                inputList.remove(i);
                break;
            }
            continue;
            //else do nothingk,
        }
    }
    return inputList;
}

//main method
public static void main(String[] args){

    MergeIntervals solution8 = new MergeIntervals();
    ArrayList<int[]> solutionArrayList = new ArrayList<>();
    int[] first = {5, 8};
    int[] sec = {6, 10};
    int[] third = {2, 4};
    int[] fourth = {3, 6};
    //int[] fifth =  {9,12};
    solutionArrayList.add(first);
    solutionArrayList.add(sec);
    solutionArrayList.add(third);
    solutionArrayList.add(fourth);
    //solutionArrayList.add(fifth);

    ArrayList<int[]> ans = solution8.mergeIntervals(solutionArrayList);

    //String ans = solution8.InttoString(solutionArrayList);
    
    for (int i[] : ans) {
        System.out.println(Arrays.toString(i));
    }

    

    
    
    
    
    System.out.println();

}
/**
 * time: 1hr
 * Note:
 * does not pass tests
 */
}

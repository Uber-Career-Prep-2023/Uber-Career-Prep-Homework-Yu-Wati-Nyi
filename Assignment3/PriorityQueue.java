import java.util.ArrayList;

public class PriorityQueue {
    /*
     * functions like a queue except that elements are removed in order of priority rather than
     * insertion. Typically implemented as a meax heap that stores pairs of elements and numeric weights.
     * Weights used as values in the heap
     * use heap as the underlying data structure
     * priority queue stores string elements with integer priorities
     * start by copy-pasting your heap implementatation from question 2 and making modifications
     */
    private static ArrayList<Integer> weight; //the underlying array
    private static ArrayList<String> arr;
    //private static HashMap<String, Integer> arr;
   
    //returns the hightes priority (first) element in the PQ
    public static String top(){ 
        return arr.get(0);
    }

    //adds string x to the PQ with priority weight
    public static void insert(String x, int w){
        //put the string and weight at the end of both lists
        arr.add(x);
        weight.add(w);
        int pos = arr.size() - 1; //hold position of the inserted string
        if(pos > 0 && w < weight.get((pos - 1)/2)){ //if the number at the front is bigger 
            //swap
            int parentPos = (pos -1)/2; //get the position of parent
            int parentWeight = weight.get(parentPos); //hold parent's value
            String parentString = arr.get(parentPos);

            arr.set(parentPos, x);
            weight.set(parentPos, w);
            arr.set(pos, parentString);
            weight.set(pos, parentWeight);
            pos = parentPos; //update position of the inserted element
        }

    }

    // removes the highest priority (first) element in the PQ
    public static void remove(){
        arr.remove(0);
        weight.remove(0);
    }

    public static void printPQ(){
        System.out.println(arr);
    }

    public static void main(String[] args) {
        weight = new ArrayList<>();
        arr = new ArrayList<>();

        insert("Hello", 10);
        insert("hi", 8);
        insert("the", 12);

        remove();

        printPQ();
        
    }

}

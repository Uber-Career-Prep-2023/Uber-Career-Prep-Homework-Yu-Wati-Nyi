import java.util.ArrayList;

public class Heap { //write a min heap
    private static ArrayList<Integer> arr; // the underlying array

    public Heap(){
        arr = new ArrayList<>();
    }

    public int top(){ // returns the min(top) element in the heap
        return arr.get(0);
    }

    public void insert(int x){ // adds int x to the heap in the appropriate position
        arr.add(x);//put the number at the end. 
        int pos = arr.size() - 1; //hold position of the inserted number
        if(pos > 0 && x < arr.get((pos - 1)/2)){ //if the number at the front is bigger 
            //swap
            int parentPos = (pos -1)/2; //get the position of parent
            int parent = arr.get(parentPos); //hold parent's value
            arr.set(parentPos, x);
            arr.set(pos, parent);
            pos = parentPos; //update position of the inserted element
        }
    }

    public void heapify(int nodePos){

        //nodePos = 0;
        int min = nodePos; //initi
        int leftChildPos = 2*nodePos + 1;
        int rightChildPos = 2*nodePos + 2;

        //if left child is smaller than root
        if( leftChildPos < arr.size() && arr.get(leftChildPos) < arr.get(min)){
            min = leftChildPos;
        }
        //if rigt child is smaller than root
        if(rightChildPos < arr.size() && arr.get(rightChildPos) < arr.get(min)){
            min = rightChildPos;
        }
        //if min is not root
        if(min != nodePos){
            int currentRoot = arr.get(nodePos); 
            arr.set(nodePos, arr.get(min));
            arr.set(min, currentRoot);
            heapify(min);

        }
    }
    public Boolean isEmpty(){
        return arr.isEmpty();
    }

    public void remove(){ //removes the min(top) element in the heap
        arr.set(0, arr.get(arr.size()-1));//replace top with leaf

        arr.remove(arr.size()-1);

        //sort the array
        heapify(0);

    }
    public void printHeap(){
        System.out.println(arr);
    }
    public static void main(String[] args) {
        
        Heap newHeap = new Heap();
        newHeap.insert(1);
        newHeap.insert(3);
        newHeap.insert(6);
        newHeap.insert(5);
        newHeap.insert(9);
        newHeap.printHeap();
        newHeap.remove();
        newHeap.printHeap();
    }
}

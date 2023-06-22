import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslands{
    /*
     * Given a binary matrix in which 1s represent land and 0s represent water
     * Return the number of islands 
     * (contiguos 1s surrounded by 0s or the edge of the matrix)
     * INCOMPLETE
     * Method: BFS
     */
    private static ArrayList<ArrayList<Integer>> islands;
    public static void addEdges(int row, int column){
        if (row > islands.size()-1 ){
            while(islands.size()<= row){
                islands.add(new ArrayList<>());
            }
            
        }
        if(column > islands.get(row).size()-1){
            while(islands.get(row).size()<=column){
                islands.get(row).add(0);
            }
        }
        islands.get(row).set(column,1);           
    }
    public static void islandBFS(int row, ArrayList<ArrayList<Integer>> islands){
        Queue<Integer> rowQueue = new LinkedList<>();
        Queue<Integer> colQueue = new LinkedList<>();

        
        while(!rowQueue.isEmpty() && !colQueue.isEmpty()){
            Integer land = rowQueue.poll();
            Integer land2 = colQueue.poll();
            //return number
            ArrayList<Integer> r = islands.get(row);

            for(Integer l: r){
                if(l == 1){
                    rowQueue.add(row);
                    colQueue.add(islands.indexOf(l));
                    l=0;
                }
            }           
        }
    }
    // public static int numberOfIslands(ArrayList<ArrayList<Integer>> islands){

    // }
    public static void main(String[] args) {
        
    }
}
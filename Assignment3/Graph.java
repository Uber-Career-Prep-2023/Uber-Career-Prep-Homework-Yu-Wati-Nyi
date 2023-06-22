import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

public class Graph {
    /**
     * given array of pairs of values representing edges in an unweighted graph
     * pairs represent directed edges
     * if another direction for the same pair is also provided, 
     * then there is an undirected edge between A and B
     * Each node of the graph stores and integer
     * Implement a basic DFS and BFS searching for a target value
     * and topological sort (using either DFS or Kahn's algo)
     */
    
    public static ArrayList<ArrayList<Integer>> adjancyList;

    public Graph(){
        adjancyList = new ArrayList<ArrayList<Integer>>();
    }
     //add edges
    public void addEdges(int num, int num2){

        if (num > adjancyList.size()-1){
            while(adjancyList.size()<= num){
                adjancyList.add(new ArrayList<>());
            }
            
        }
        adjancyList.get(num).add(num2);
        
    }

    public  void printGraph(){

        for(int i = 0; i< adjancyList.size(); i++){
            adjancyList.get(i).sort(Comparator.naturalOrder());
            System.out.print(i + " : ");
            for(int j = 0; j< adjancyList.get(i).size(); j++){
                System.out.print(adjancyList.get(i).get(j) + " -> ");
                
            }
            System.out.println(" ");
        }
    }

    /*
     * 0:
     * 1: 2 -> 3
     * 2: 0 -> 3
     * 3: 2 ->
     */

     //find target value with DFS
     //does not work if 0 is the source, the starting point
    public static Boolean dfs(int target, int source, ArrayList<ArrayList<Integer>> graph){

        Stack<Integer> stack = new Stack<>();//initialize stack
        int[] visited = new int[graph.size()]; //initialize 0,1 array

        stack.push(source);
        visited[source] = 1;

        while(!stack.isEmpty()){
            Integer node = stack.pop();
            if(node == target){
                return true;
            }
            //System.out.println(node);

            ArrayList<Integer> childList = graph.get(node);

            for(Integer child: childList){
                if(visited[child] == 0){
                    stack.push(child);
                    visited[child] = 1;
                    System.out.println(child);
                }
            }
        }

        return false;
    }
 

     //find target value with BFS
    public static Boolean bfs(int target, int start, ArrayList<ArrayList<Integer>> graph){
        Queue<Integer> queue = new LinkedList<>();
        int[] visited = new int[graph.size()];

        queue.add(start);
        visited[start] = 1;

        while(!queue.isEmpty()){
            Integer node = queue.poll();
            if(node == target){
                return true;
            }

            ArrayList<Integer> childList = graph.get(node);

            for(Integer child: childList){
                if(visited[child] == 0){
                    queue.add(child);
                    visited[child] = 1;
                }
            }
        }
        
        return false;
    }

    //topological sort using dfs
    public static void topologicalPrint(int start, ArrayList<ArrayList<Integer>> graph){
        Queue<Integer> queue = new LinkedList<>();
        int[] visited = new int[graph.size()];

        queue.add(start);
        visited[start] = 1;

        while(!queue.isEmpty()){
            Integer node = queue.poll();
            System.out.println(node);

            ArrayList<Integer> childList = graph.get(node);

            for(Integer child: childList){
                if(visited[child] == 0){
                    queue.add(child);
                    visited[child] = 1;
                }
            }
        }

    }
     
     //main
     public static void main(String[] args) {

        Graph newRep = new Graph();

        newRep.addEdges(1, 2);
        newRep.addEdges(2, 3);
        newRep.addEdges(1, 3);
        newRep.addEdges(3, 2);
        newRep.addEdges(2, 0);
        newRep.printGraph();
        
        System.out.println(dfs(1,1,adjancyList)); //only works for
        //dfs(3,1,adjancyList);
        topologicalPrint(1, adjancyList);
        //System.out.println(bfs(5,1,adjancyList));

        
     }
    
}

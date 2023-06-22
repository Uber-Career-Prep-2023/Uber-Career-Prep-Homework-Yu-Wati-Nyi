import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

public class RoadNetworks {
/*
Given a list of towns and a list of pairs representing roads between towns, return the number of road networks. (For example, a state in which all towns are connected by roads has 1 road network, and a state in which none of the towns are connected by roads has 0 road networks.)

Examples:
Input: ["Skagway", "Juneau", "Gustavus", "Homer", "Port Alsworth", "Glacier Bay", "Fairbanks", "McCarthy", "Copper Center", "Healy"], 
[("Anchorage", "Homer"), ("Glacier Bay", "Gustavus"), ("Copper Center", "McCarthy"), ("Anchorage", "Copper Center"), ("Copper Center", "Fairbanks"), ("Healy", "Fairbanks"), ("Healy", "Anchorage")]

Output: 2 (Networks are Gustavus-Glacier Bay and Anchorage-Fairbanks-McCarthy-Copper Center-Homer-Healy)

Input: ["Kona", "Hilo", "Volcano", "Lahaina", "Hana", "Haiku", "Kahului", "Princeville", "Lihue", "Waimea"], [("Kona", "Volcano"), ("Volcano", "Hilo") ("Lahaina", "Hana"), ("Kahului", "Haiku"), ("Hana", "Haiku"), ("Kahului", "Lahaina"), ("Princeville", "Lihue"), ("Lihue", "Waimea")]

Output: 2 (Networks are Kona-Hilo-Volcano, Haiku-Kahului-Lahaina-Hana, and Lihue-Waimea-Princeville)

Time Taken: 4o min
Method: DFS Traversal
Time Complexity: O(nlogn) there are three nested loops
Space Complexity: O(N)
 */
public static class Pair{
    String a;
    String b;
    public Pair(String area1, String area2){
        a = area1;
        b = area2;
    }
}    
public static HashMap<String, ArrayList<String>> roadnet = new HashMap<>();
public static HashMap<String, Boolean> visited = new HashMap<>();
public static ArrayList<String> hasRoadin = new ArrayList<>();

public static void addEdges(Pair path){
    if (!roadnet.containsKey(path.a)){
        
        ArrayList<String> newpath = new ArrayList<>();
        newpath.add(path.b);
        roadnet.put(path.a, newpath);
        hasRoadin.add(path.b);
        if(!visited.containsKey(path.a)){
            visited.put(path.a, false);
        }
    }
    else{
        roadnet.get(path.a).add(path.b);
        hasRoadin.add(path.b);
    }
    
      
}

public static void dfsUtil(String start, HashMap<String, ArrayList<String>> road){

    Stack<String> stack = new Stack<>();
    

    stack.push(start);
    //visited.replace(start, true);

    while(!stack.isEmpty()){
        String place = stack.pop();

        
        if((road.get(place)!= null)){
            ArrayList<String> pathways = road.get(place);
            for(String p : pathways){
                stack.push(p);
                visited.replace(p, true);
            }
            

        }

    }

}

public static int roadNetworks(String[] input, Pair[] input2){

   
    int count = 0;

    for(String l : input){
        visited.put(l, false);
    }

    for(Pair in: input2){
        addEdges(in);
    }

    for(String s: input){
        if ((visited.get(s)==false) && (roadnet.get(s) != null) && (!hasRoadin.contains(s))){
            count ++;
            dfsUtil(s, roadnet);
        }
    }
    return count;

    
}


public static void main(String[] args) {
    String[] input1 = {"Skagway", "Juneau", "Gustavus", "Homer", "Port Alsworth", "Glacier Bay", "Fairbanks", "McCarthy", "Copper Center", "Healy"};
    Pair[] input2 = {new Pair("Anchorage", "Homer"), new Pair("Glacier Bay", "Gustavus"), new Pair("Copper Center", "McCarthy"), new Pair("Anchorage", "Copper Center"), new Pair("Copper Center", "Fairbanks"), new Pair("Healy", "Fairbanks"), new Pair("Healy", "Anchorage")};

    String[] test = {"Kona", "Hilo", "Volcano", "Lahaina", "Hana", "Haiku", "Kahului", "Princeville", "Lihue", "Waimea"};
    Pair[] test2 = {new Pair("Kona", "Volcano"), new Pair("Volcano", "Hilo"), new Pair("Lahaina", "Hana"), new Pair("Kahului", "Haiku"), new Pair("Hana", "Haiku"), new Pair("Kahului", "Lahaina"), new Pair("Princeville", "Lihue"), new Pair("Lihue", "Waimea")};
    // for(Pair in: input2){
    //     addEdges(in);
    // }
    // System.out.println(roadnet);
    System.out.println(roadNetworks(input1, input2));
    System.out.println(roadNetworks(test, test2));
    //roadNetworks(input1, input2);
    

}


}

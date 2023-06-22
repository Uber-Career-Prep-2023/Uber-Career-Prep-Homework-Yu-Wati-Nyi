import java.util.ArrayList;
import java.util.HashMap;

import javax.crypto.spec.RC2ParameterSpec;
import javax.sound.sampled.SourceDataLine;

public class AlternatingPath {
/*
Given an origin and a destination in a directed graph in which edges can be blue or red, determine the length of the shortest path from the origin to the destination in which the edges traversed alternate in color. Return -1 if no such path exists.

Examples:
[(A, B, "blue"), (A, C, "red"), (B, D, "blue"), (B, E, "blue"), (C, B, "red"), (D, C, "blue"), (A, D, "red"), (D, E, "red"), (E, C, "red")]

Input: origin = A, destination = E
Output: 4 (path: A→D (red), D→C (blue), C→B (red), B→E (blue))

Input: origin = E, destination = D
Output: -1 (only path is: E→C (red), C→B (red), B→D (blue))

INCOMPLETE

 */

public static class Triple{
    String a;
    String b;
    String c;
    public Triple(String aa, String bb, String cc){
        a = aa;
        b = bb;
        c = cc;
        
    }
}
public static ArrayList<ArrayList<String>> adjacencyMatrix = new ArrayList<>();
public static HashMap<String, Integer> letToNum = new HashMap<>();

//initialize hashmap

public static void addtoMap(){
    letToNum.put("A", 1);
    letToNum.put("B", 2);
    letToNum.put("C", 3);
    letToNum.put("D", 4);
    letToNum.put("E", 5);
}
public static void addEdges(Triple t){
    int rowVal = letToNum.get(t.a);
    int colVal = letToNum.get(t.b);
    int rowSize = adjacencyMatrix.size();
    //int colSize =  adjacencyMatrix.get(letToNum.get(t.a)).size();

    if (rowVal > rowSize-1){
        while(rowSize<= rowVal){
            adjacencyMatrix.add(new ArrayList<>());
        }
        
        
    }
    if(colVal > adjacencyMatrix.get(letToNum.get(t.a)).size()-1){
        while(adjacencyMatrix.get(letToNum.get(t.a)).size() <= colVal){
            adjacencyMatrix.get(rowVal).add("null");
        }
    }
    adjacencyMatrix.get(rowVal).set(colVal, t.c);
}

public static int alternatingPath(String origin, String destination, Triple[] graphEdges){
    
}   
public static void main(String[] args) {
    Triple[] input = {new Triple("A", "B", "blue"), new Triple("A", "C", "red"), new Triple("B", "D", "blue"), new Triple("B", "E", "blue"), new Triple("C", "B", "red"), new Triple("D", "C", "blue"), new Triple("A", "D", "red"), new Triple("D", "E", "red"), new Triple("E", "C", "red")};

    addtoMap();
    for(Triple t: input){
        addEdges(t);
    }

    System.out.println(adjacencyMatrix);
}
}

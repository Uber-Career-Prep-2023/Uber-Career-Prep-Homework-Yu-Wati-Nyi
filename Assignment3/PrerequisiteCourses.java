import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

public class PrerequisiteCourses {
/*
Given a list of courses that a student needs to take to complete their major and a map of courses to their prerequisites, return a valid order for them to take their courses assuming they only take one course for their major at once.

Examples:
Input: ["Intro to Programming", "Data Structures", "Advanced Algorithms", "Operating Systems", "Databases"], { "Data Structures": ["Intro to Programming"], "Advanced Algorithms": ["Data Structures"], "Operating Systems": ["Advanced Algorithms"], "Databases": ["Advanced Algorithms"] }
Output: ["Intro to Programming", "Data Structures", "Advanced Algorithms", "Operating Systems", "Databases"] or 
["Intro to Programming", "Data Structures", "Advanced Algorithms", "Databases", "Operating Systems"]

Input: ["Intro to Writing", "Contemporary Literature", "Ancient Literature", "Comparative Literature", "Plays & Screenplays"], { "Contemporary Literature": ["Intro to Writing"], "Ancient Literature": ["Intro to Writing"], "Comparative Literature": ["Ancient Literature", "Contemporary Literature"], "Plays & Screenplays": ["Intro to Writing"] }
Output: ["Intro to Writing", "Plays & Screenplays", "Contemporary Literature", "Ancient Literature", "Comparative Literature"] or
["Intro to Writing", "Contemporary Literature", "Plays & Screenplays", "Ancient Literature", "Comparative Literature"] or
["Intro to Writing", "Contemporary Literature", "Ancient Literature", "Plays & Screenplays", "Comparative Literature"] or 
["Intro to Writing", "Ancient Literature", "Contemporary Literature",  "Plays & Screenplays", "Comparative Literature"] or 
["Intro to Writing", "Ancient Literature",  "Plays & Screenplays",  "Contemporary Literature", "Comparative Literature"] or
["Intro to Writing", "Plays & Screenplays", "Ancient Literature",  "Contemporary Literature", "Comparative Literature"] or 
["Intro to Writing", "Ancient Literature",  "Contemporary Literature", "Comparative Literature", "Plays & Screenplays"] or 
["Intro to Writing", "Contemporary Literature",  "Ancient Literature", "Comparative Literature", "Plays & Screenplays"] 

Time Taken: 40 minutes
Method: DFS Traversal Topological

 */  

public static HashMap<String, ArrayList<String>> graph = new HashMap<>();
public static HashMap<String, Boolean> visited = new HashMap<>();

public static void addEdges(String course, String prerequisite){
    if (!graph.containsKey(prerequisite)){
        
        ArrayList<String> newpath = new ArrayList<>();
        
        graph.put(prerequisite, newpath);
        
        visited.put(prerequisite, false);
        
    }
    graph.get(prerequisite).add(course);
    if(!visited.containsKey(course)){
        visited.put(course, false);
    }
        
}
public static ArrayList<String> dfsUtil(String start, ArrayList<String> courseList, HashMap<String, ArrayList<String>> inputGraph){
    Stack<String> stack = new Stack<>();
    stack.push(start);
    while(!stack.isEmpty()){
        String course = stack.pop();
        courseList.add(course);

        if(!(inputGraph.get(course).equals(null))){
            ArrayList<String> post = inputGraph.get(course);
            String c = post.get(0);
            stack.push(c);
            visited.replace(c, true);
        }
    }
    return courseList;
}
public static ArrayList<String> prequisiteCourses(String[] inputList, HashMap<String, ArrayList<String>> inputGraph ){
    ArrayList<String> courseList = new ArrayList<>();

    for(String l : inputList){
        visited.put(l, false);
    }

    for(String s: inputList){
        if ((visited.get(s)==false) && (inputGraph.get(s) != null)){
            dfsUtil(s, courseList, inputGraph);
        }
    }
    return courseList;
}
public static void main(String[] args) {
    addEdges("Data Structures", "Intro to Programming");
    addEdges("Advanced Algorithms", "Data Structures");
    addEdges("Operating Systems", "Advanced Algorithms");
    addEdges("Databases","Advanced Algorithms");

    String[] inputList = {"Intro to Programming", "Data Structures", "Advanced Algorithms", "Operating Systems", "Databases"};

    System.out.println(prequisiteCourses(inputList, graph));
    
}
}

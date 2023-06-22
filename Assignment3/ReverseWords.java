import java.util.Stack;

public class ReverseWords {
/*
Given a string, return the string with the order of the space-separated words reversed

Examples:
Input: "Uber Career Prep"
Output: "Prep Career Uber"

Input: "Emma lives in Brooklyn, New York."
Output: "York. New Brooklyn, in lives Emma"

time taken: 7 minutes
Method: stack
Time complexity: O(n)
Space Complexity: O(n)
 */ 

public static String reverseWords(String input){
    Stack<String> stack = new Stack<>();
    String output = "";

    String[] inputArray = input.split(" ");
    for(String s: inputArray){
        stack.push(s);
    }

    while(!(stack.isEmpty())){
        String word = stack.pop();
        output = output + word + " ";
    }
    return output;
}

public static void main(String[] args) {
    System.out.println(reverseWords("Uber Career Prep"));
    System.out.println(reverseWords("Emma lives in Brooklyn, New York."));
}
 
}

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class VacationDestinations {
/*
Given an origin city, a maximum travel time k, 
and pairs of destinations that can be reached directly from each other with corresponding travel times in hours, 
return the number of destinations within k hours of the origin. 
Assume that having a stopover in a city adds an hour of travel time.

Examples:
Input: [("Boston", "New York", 4), 
("New York", "Philadelphia.", 2), 
("Boston", "Newport", 1.5), 
("Washington, D.C.", "Harper's Ferry", 1), 
("Boston", "Portland", 2.5), ("Philadelphia", "Washington, D.C.", 2.5)]

Origin = "New York", k=5
Output: 2 (["Boston", "Philadelphia"])

Origin = "New York", k=7
Output: 2 (["Boston", "Philadelphia", "Washington, D.C", "Newport"])

Origin = "New York", k=8
Output: 2 (["Boston", "Philadelphia", "Washington, D.C", "Newport", "Harper's Ferry", "Portland"])

INCOMPLETE
 */ 

    public static class Destination {
        String src;
        String dest;
        double travelTime;

        public Destination(String src, String dest, double travelTime) {
            this.src = src;
            this.dest = dest;
            this.travelTime = travelTime;
        }
    }

    public static int countDestinations(String origin, double k, List<Destination> destinations) {
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        int count = 0;


    }

    public static void main(String[] args) {
        List<Destination> destinations = new ArrayList<>();
        destinations.add(new Destination("Boston", "New York", 4));
        destinations.add(new Destination("New York", "Philadelphia", 2));
        destinations.add(new Destination("Boston", "Newport", 1.5));
        destinations.add(new Destination("Washington, D.C.", "Harper's Ferry", 1));
        destinations.add(new Destination("Boston", "Portland", 2.5));
        destinations.add(new Destination("Philadelphia", "Washington, D.C.", 2.5));

        System.out.println(countDestinations("New York", 5, destinations));
        // Output: 2

        System.out.println(countDestinations("New York", 7, destinations));
        // Output: 3

        System.out.println(countDestinations("New York", 8, destinations));
        // Output: 5
    }
}




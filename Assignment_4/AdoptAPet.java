import java.util.PriorityQueue;
import java.util.Queue;

public class AdoptAPet {
    /*
     * An animal shelter that houses cats and dogs wants to ensure no pet has to wait too long for a forever home. 
     * Therefore, anyone who comes to adopt a pet can pick the species (cat or dog) but not the specific animal; 
     * they are assigned the animal of that species that has been in the shelter longest. 
     * If there are no animals available of the desired species, they must take the other species. 
     * You are given a list of pets in the shelter with their names, species, and time in the shelter at the start of a week. 
     * You receive a sequence of incoming people (to adopt pets) and animals (new additions to the shelter) one at a time. 
     * Print the names and species of the pets as they are adopted out.

        Example (input and output forms one sequence of sample input):
        Initial Input:
        Sadie, dog, 4 days
        Woof, cat, 7 days
        Chirpy, dog, 2 days
        Lola, dog, 1 day

        Input: Bob, person, dog
        Output: Sadie, dog

        Input: Floofy, cat
        Output:

        Input: Sally, person, cat
        Output: Woof, cat

        Input: Ji, person, cat
        Output: Floofy, cat

        Input: Ali, person, cat
        Output: Chirpy, dog

      *************************************************************************
      Assumptions: 
      Queries are happening on the same day and pets that are just adopted have 0 days. 

      Method: Multiple Query problems (maintian a queue or two)

      Time Complexity: O(n) for keeping priority queue

      Space Complexity: O(n) for keeping priority queue

      Time Taken: 40 minutes

     */

   public static class Pets{
      String name;
      String species;
      int days; 
      public Pets(String[] input) {
         name = input[0];
         species = input[1];

         String[] arr = input[2].split(" ");
         days = Integer.parseInt(arr[0]);
         

      }
   }

   public static Queue<Pets> dogs = new PriorityQueue<>((a, b) -> b.days - a.days);
   public static Queue<Pets> cats = new PriorityQueue<>((a, b) -> b.days - a.days);

   public static void addPet(String[] input){

      Pets newPet = new Pets(input);

      if(newPet.species == "cat"){
         cats.offer(newPet);
      }
      if(newPet.species == "dog"){
         dogs.offer(newPet);
      }
      

   }

   public static String adoptingOut(String type){
      
      if(type == "cat" && (!cats.isEmpty()) || dogs.isEmpty()){
         Pets cat = cats.poll();
         return cat.name + ", " + cat.species;
      }
      if(type == "dog" && (!dogs.isEmpty()) || cats.isEmpty()){
         Pets dog = dogs.poll();
         return dog.name+ ", " + dog.species;
      }
      return "";
   }

   public static String adoptAPet(String[] input){

      if(input[1] == "person"){
         return adoptingOut(input[2]);
      }
      else{
         addPet(input);
         return " ";
      }
      
   }

   public static void main(String[] args) {
      
      
      addPet(new String[]{"Sadie", "dog", "4 days"});
      addPet(new String[]{"Woof", "cat", "7 days"});
      addPet(new String[] {"Chirpy", "dog", "2 days"});
      addPet(new String[]{"Lola", "dog", "1 day"}) ;

      //input 1
      String[] input1 = {"Bob", "person", "dog"};

      System.out.println(adoptAPet(input1));

      //input 2 
      String[] input2 = {"Floofy", "cat", "0 days"};

      System.out.println(adoptAPet(input2));

      //input 3   
      String[] input3 = {"Sally", "person", "cat"};

      System.out.println(adoptAPet(input3));
      //input 4
      String[] input4 = {"Ji", "person", "cat"};

      System.out.println(adoptAPet(input4));
      //input 5
      String[] input5 = {"Ali", "person", "cat"};

      System.out.println(adoptAPet(input5));
   }
}

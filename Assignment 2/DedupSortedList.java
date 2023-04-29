public class DedupSortedList {
    // given a sorted singly linked list, remove any duplicates so that no value appears more than once
    /**
     * time taken: 30 min
     * time complexity : O(N)
     * space complexity: O(N)
     * Reset, catch up two pointer
     */

    /*
     * Node class
     */
    public static class Node{
        int data;
        Node next;

        //Constructor to create a new node
        Node(int d){
            data = d;
            next = null;
        }

    }

    public static void dedupsortedlist(Node newNode){
        
        if(newNode == null){
            return;
        }
        //new pointer
        Node head = newNode;
        while(head.next != null){
            
            while(head.data == head.next.data){
                head.next = head.next.next;
            }
            head = head.next;
        }

        

        newNode = head;


    }

    //print linked list for testing
    public static void printList(Node newNode){
        Node curr = newNode;
        while(curr != null){
            System.out.print(curr.data + "->");
            curr = curr.next;
        }
        System.out.println("Null");
    }

    public static void main(String[] args) {
        Node newList = new Node(1);
        newList.next = new Node(2);
        newList.next.next = new Node(3);
        newList.next.next.next = new Node(4);
        newList.next.next.next.next = new Node(4);
        newList.next.next.next.next.next = new Node(4);
        newList.next.next.next.next.next.next = new Node(5);
        newList.next.next.next.next.next.next.next = new Node(6);
        newList.next.next.next.next.next.next.next.next = new Node(7);

        printList(newList);
        dedupsortedlist(newList);
        printList(newList);
    }

}

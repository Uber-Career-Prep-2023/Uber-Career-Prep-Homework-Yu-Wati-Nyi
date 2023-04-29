public class SinglyLinkedList {
    
    private Node head;

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

    public SinglyLinkedList(){
        head = null;
    }


    //creates new Node with data val at the front; returns new head
    public Node insertAtFront(int val){
        
        Node newNode = new Node(val);

        newNode.next = head;

        head = newNode;

        return head;
    }


    public void insertAtBack(int val){

        Node newNode = new Node(val);

        if(head == null){
            head = new Node(val);
            return;
        }

        newNode.next = null;

        Node last = head;
        while(last.next != null){
            last = last.next;
        }

        last.next = newNode;
        return;
    }

    //creates a new Node with data val after Node loc
    public void insertAfter(int val, Node loc){

        Node newNode = new Node(val);
        
        newNode.next = loc.next; //next of curr node is now next of new Node

        loc.next = newNode; //next of the current node is now the new node
        
        return; 
    }

    //remove first Node; return new head
    public Node deleteFront(){
        if(head == null){ //if head of linked list is null
            return head; //do nothing
        }

        head = head.next; //change pointer

        return head;
    }

    //removes last Node
    public void deleteBack(){
        if(head == null){ //if head of linkedlist is null
            return;  //do nothing
        }

        Node curr = head; //extra pointer

        while(curr.next.next != null){
            curr = curr.next;
        }

        curr.next = null; 

    }

    //deletes Node loc; returns head
    public Node deleteNode(Node loc){

        if(head == null){
            return head;
        }

        Node curr = head;
    
        while(curr.next.data != loc.data){
            curr = curr.next;
        }
        
        curr.next = curr.next.next;
            
        return head;
        
    }

    //reverses the linked list iteratively
    public Node reverserIterative(){

        if(head == null){ //if head is null do nothing
            return head;
        }


        Node prev = null; //pointer for node previous to head to be initialized
        Node current = head; //pointer at head
        Node next = null; //pointer at node after head to be initialized

        while(current!= null){
            next = current.next; //update pointer next to be current.next
            current.next = prev; //update next of current to be previous 
            prev = current; //update prev to be current
            current = next; //update current to be next
        }

        head = prev; 

        return head;
    }

    //reverses the linked list recursively
    public Node reverseRecursive(Node node){ //not working
        /*
         * seperate head from the rest, continue till null
         * call back recursion
         */

        Node rest = head;
        if(node == null || node.next == null){
            return node;
        }

        rest = reverseRecursive(node.next);
        node.next.next = node;
        node.next = null;

        return rest;


    }

    public int length(){
         
        int countLength = 1;
        if(head == null){
            return 0;
        }
        while(head.next != null){
            head = head.next;
            countLength++;
        }
        return countLength;
    }




    // public Node deleteNode(Node first, Node loc){

    //     if(first == null){
    //         return first;
    //     }
    //     if(loc == null){
    //         return first;
    //     }

    //     while()

    // }

    //print linked list for testing
    public void printList(Node first){
        Node curr = first;
        while(curr != null){
            System.out.print(curr.data + "->");
            curr = curr.next;
        }
        System.out.println("Null");
    }


    //main method
    public static void main(String[] args) {
        
        

        SinglyLinkedList sllist = new SinglyLinkedList();


        sllist.insertAtBack( 1);
        //System.out.println(sllist.length());
        sllist.insertAtBack( 2);
        //System.out.println(sllist.length());
        sllist.insertAtFront( 0);
        //System.out.println(sllist.length());
        //sllist.insertAfter( 3, insertAfter);
        //System.out.println(sllist.length()); 
        //sllist.deleteFront();
        //sllist.deleteBack();
        sllist.insertAtBack( 4);
        sllist.insertAtBack( 5);
        //sllist.deleteNode(insertAfter);
        sllist.reverserIterative();
        //sllist.reverseRecursive(sllist.head);

        //Node newnode = new Node(1); //error if there is a nested class, worked after putting the class outside


        sllist.printList(sllist.head);
     }
}

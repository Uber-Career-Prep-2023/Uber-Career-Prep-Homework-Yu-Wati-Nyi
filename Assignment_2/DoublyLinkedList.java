public class DoublyLinkedList {
    
    
    private Node head;

    /*
        * Node class
        */
    public static class Node{
        int data;
        Node next;
        Node prev;

        //Constructor to create a new node
        Node(int d){
            data = d;
            next = null;
            prev = null;
        }
    }

    public DoublyLinkedList(){
        head = null;
    }


    //creates new Node with data val at the front; returns new head
    public Node insertAtFront(int val){
        
        Node newNode = new Node(val); //create new node 

        newNode.next = head; //put head behind new node

        if(head != null){ //as long as head is not null
            head.prev = newNode; //new node is infront of head
        }

        head = newNode; //update pointer

        return head; 
    }


    public void insertAtBack(int val){

        Node newNode = new Node(val); //create new node

        if(head == null){ //if head is null
            head = new Node(val); //head is new node
            return;
        }

        newNode.next = null; //update next of newNode
        newNode.prev = head; //update prev of newNode

        Node last = head; //new pointer starting head
        while(last.next != null){ 
            last = last.next; //find last node
        }

        last.next = newNode; //put new node behind last node
        return;
    }

    //creates a new Node with data val after Node loc
    public void insertAfter(int val, Node loc){

        Node newNode = new Node(val); //create new node
        
        newNode.next = loc.next; //next of curr node is now next of new Node

        newNode.prev = loc; //update prev of newNode to loc

        loc.next = newNode; //next of the current node is now the new node
        
        return; 
    }

    //remove first Node; return new head
    public Node deleteFront(){
        if(head == null){ //if head of linked list is null
            return head; //do nothing
        }

        head = head.next; //change pointer
        head.prev = null; //update prev

        return head;
    }

    //removes last Node
    public void deleteBack(){
        if(head == null){ //if head of linkedlist is null
            return;  //do nothing
        }

        Node curr = head; //extra pointer

        while(curr.next.next != null){ //find second last node
            curr = curr.next; 
        }

        curr.next = null; //update next of second last node

    }

    //deletes Node loc; returns head
    public Node deleteNode(Node loc){ //delete the node in the linkedlist?

        if(loc == null){
            return head;
        }
        if(head == null){
            return head;
        }

        //Node curr = head; //new pointer at head

        Node prev = loc.prev; //pointer at prev of loc

        prev.next = loc.next; //update next of pointer at prev to be node the next of loc

            
        return head;
        
    }

    //reverses the linked list iteratively
    public Node reverserIterative(){

        if(head == null){
            return head;
        }

        
        Node prev = null;
        Node current = head;
        Node next = null;

        while(current!= null){

            next = current.next; //update pointer next

            current.next = prev; //change the next node of current to be prev

            prev = current; //update pointer prev to current node

            current.prev = next; //change the previous node of current to be next

            current = next; //move to next node
            
        }

        head = prev; //return list 

        return head;
    }

    //reverses the linked list recursively
    public Node reverseRecursive(Node node){

        

        if(node == null){
            return node;
        }
        if(node.next == null){
            return node;
        }

        Node rest = reverseRecursive(node.next);
        node.next.next = node;

        node.next = null;

        head = node;

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
        

        DoublyLinkedList dllist = new DoublyLinkedList();
        

        dllist.insertAtBack( 1);
        //System.out.println(sllist.length());
        dllist.insertAtBack( 2);
        //System.out.println(sllist.length());
        dllist.insertAtFront( 0);
        dllist.insertAtBack(3);
        dllist.insertAtBack(4);
        dllist.insertAtBack(5);
        //dllist.deleteBack();
        //dllist.deleteFront();

        dllist.reverserIterative();


        dllist.printList(dllist.head);

    }

    
}

public class MoveNthLastToFront {
    //Given a singly linked list, move the nth from the last element to the front of the list.
    /**
     * time taken: 40 minutes
     * time complexity: O(N)
     * space complexity: O(N)
     * Fixed-Distance Two-Pointer
     */
    
    //node clas
    public static class Node{
        int data;
        Node next;

        public Node(int d){
            data = d;
            next = null;
        }
    }

    public static Node moveNthLasttoFront(Node newNode, int k){

        int count = 0;

        if(newNode == null){
            return newNode;
        }
        //new head pointer
        Node head = newNode;
        
        //pointer number 2 
        Node pointer = head;
        while(count != k){
            
            pointer = pointer.next;
            count++;
            
        }

        //pointer number 3
        Node nthNode;
        //find the nth from the last node
        while(pointer.next != null){
            pointer = pointer.next;
            head = head.next;

        }
        nthNode = head.next;

        head.next = head.next.next;

        head = newNode;

        nthNode.next = head;

        newNode = nthNode;

        return newNode;

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
        newList.next.next.next.next = new Node(5);
        newList.next.next.next.next.next = new Node(6);
        newList.next.next.next.next.next.next = new Node(7);
        newList.next.next.next.next.next.next.next = new Node(8);
        newList.next.next.next.next.next.next.next.next = new Node(9);

        printList(newList);
        
        printList(moveNthLasttoFront(newList, 2));

    }
}

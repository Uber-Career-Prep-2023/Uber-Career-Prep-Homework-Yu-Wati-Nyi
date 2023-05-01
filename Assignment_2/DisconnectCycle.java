public class DisconnectCycle {
    //Given a singly linked list, disconnect the cycle, if one exists.
    /*
     * time taken: 15 minutes
     * time complexity: O(N) depends on how long the linked list is
     * space complexity: O(1)
     * 
     * Fast_slow
     */

    public static class Node{
        int data;
        Node prev;
        Node next;

        public Node(int d){
            data = d;
            prev = null;
            next = null;
        }
    }

    public static void disconnectCycle(Node newNode){

        if(newNode == null){
            return;
        }
        Node head = newNode;
        //two pointers at head
        Node fast = head;
        Node slow = head;

        while(fast.next != slow){
            fast = fast.next.next;
            slow = slow.next; 
        }
        fast.next = null;
        
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

        Node connection = new Node(6);

        newList.next.next.next.next.next = connection;
        newList.next.next.next.next.next.next = new Node(3);
        newList.next.next.next.next.next.next.next = new Node(2);
        newList.next.next.next.next.next.next.next.next = connection;

        //printList(newList);
        disconnectCycle(newList);
        printList(newList);

        
        
        

    }

}

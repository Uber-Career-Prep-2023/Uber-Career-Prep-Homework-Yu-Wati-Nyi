public class isPalindrome {
    //Given a doubly linked list, determine if it is a palindrome.
    /**
     * time commitment: 40 min
     * Time complexity: O(N)
     * Space comlexity: O(N) -> goes through the linked list twice
     * 
     * Doubly Linked List Forward- Backward Two-Pointer
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

    public static boolean palindrome(Node newNode){
        
        Node head = newNode;

        if(head == null || head.next == null){
            return true;
        }
        //get tail to the end

        Node tail = newNode;
        Node tprev = null;
        Node tnext = null;

        while(tail.next!= null){

            tprev = tail;
            tnext = tail.next;
            
            tail.next = tnext;    

            tail = tail.next;
            tail.prev = tprev;
        }

        while(head != tail && head.next != null && tail.prev != null){
            if(head.data != tail.data){
                return false;
            }
            head = head.next;
            tail = tail.prev;
            
        }
        return true;
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
        newList.next.next.next.next.next = new Node(4);
        newList.next.next.next.next.next.next = new Node(3);
        newList.next.next.next.next.next.next.next = new Node(2);
        newList.next.next.next.next.next.next.next.next = new Node(1);

        printList(newList);

        System.out.println(palindrome(newList));
        
        

    }
}

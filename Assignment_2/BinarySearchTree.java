public class BinarySearchTree {

    public Node root;
    //public final Node root; //adding final make reference not to modify the global variable

    public static class Node{
        int key;
        Node left;
        Node right;
        public Node(int val){
            key = val;
            // left = null;
            // right = null;
        }
        
    };


    //returns the minimum value in the BST
    public int min(){ //return the right most node

        while(root.left != null){
          root = root.left;  
        }

        return root.key;
    }

    //returns the maximum value in the BST
    public int max(){ //return the left most node

        while(root.right != null){
            root = root.right;
        }
        return root.key;
    }

    //returns a boolean indicating whether val is present
    //in the BST
    //For simplicity do not allow duplicates. If vall is already present, insert is a no-op
    public boolean contains(Node current, int val){

        if(current == null){
            return false;
        }

        if(val == current.key){
            return true;
        }

        boolean isInLeft = contains(current.left, val);
    
        if(isInLeft){
            return true;
        }

        boolean isInRight = contains(current.right, val);
    
        return isInRight;
    }

    //creates a new Node with data val in the appropriate location
    public void insert(int val){
        
        Node node = new Node(val);
        if(root == null){
            root = node;
            return;
        }
        Node prev = null;
        Node temp = root;
        while(temp != null){
            if(temp.key > val){
                prev = temp;
                temp = temp.left;
            }
            else if(temp.key < val){
                prev = temp;
                temp = temp.right;
            }
        }
        if(prev.key > val){
            prev.left = node;
        }
        else{
            prev.right = node;
        }


    }
    //deletes the Node wiht data val, if it exists
    public int delete(int val){
        return 0;
    }

    public void inOrderTraversal(Node current){
        
        if(current != null){
            inOrderTraversal(current.left);
            System.out.println(current.key + " ");
            inOrderTraversal(current.right);
        }
        //System.out.println("null");

    }


    
    public static void main(String[] args) {
        
        BinarySearchTree bstfirst = new BinarySearchTree();

        bstfirst.insert(1);
        bstfirst.insert(2);
        bstfirst.insert(3);
        bstfirst.insert(4);
        bstfirst.insert(5);
        bstfirst.insert(6);
        bstfirst.insert(7);
        bstfirst.insert(8);

        bstfirst.inOrderTraversal(bstfirst.root);

        boolean isThere = bstfirst.contains(bstfirst.root, 5);
        System.out.println(isThere);
        System.out.println(bstfirst.min());
        System.out.println(bstfirst.max());

       
    }

}

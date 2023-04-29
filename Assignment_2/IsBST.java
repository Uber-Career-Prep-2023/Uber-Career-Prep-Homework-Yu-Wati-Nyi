public class IsBST {
    /*
     * Given a binary tree, determine if it is a binary search tree
     * time taken: 25 min
     * time complexity: O(N) each node of the tree is only visited once
     * space complexity: O(N) space taken is the height of the given tree
     * method: Fixed Distance Two Pointer, Linked List Recursion, Depth-First Search InOrder
     */
    public static class TreeNode{
        int key;
        TreeNode root;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val){
            key = val;
            root = null;
            left = null;
            right = null;
        }
    }
    public static boolean isBinarySearchTree(TreeNode node){

        TreeNode temp = node;
        TreeNode left = temp.left;
        TreeNode right = temp.right;
    
        if(temp.left == null || temp.right == null){
            return true;
        }
        if(left.key >= temp.key){
            return false;
        }
        if(right.key <= temp.key){
            return false;
        }else{
        
        isBinarySearchTree(temp.left);
        isBinarySearchTree(temp.right);
        return true;
        }
    }

    public static void printInOrder(TreeNode node){
        if(node != null){
            
            printInOrder(node.left);
            System.out.print(node.key + "->");
            printInOrder(node.right);
        } 
        //System.out.print("null"); 
    }
    public static void main(String[] args) {
        TreeNode treeRootBST = new TreeNode(8);

        treeRootBST.left = new TreeNode(3);
        treeRootBST.left.left = new TreeNode(1);
        treeRootBST.left.right = new TreeNode(6);

        treeRootBST.right = new TreeNode(10);
        treeRootBST.right.right = new TreeNode(14);

        
        TreeNode oldRoot = new TreeNode(0);
        oldRoot.left = new TreeNode(2);
        oldRoot.right = new TreeNode(3);
        oldRoot.left.left = new TreeNode(4);
        oldRoot.left.right = new TreeNode(5);       

        printInOrder(treeRootBST);
        System.out.println(" ");
        System.out.println(isBinarySearchTree(treeRootBST));
        printInOrder(oldRoot);
        System.out.println(" ");
        System.out.println(isBinarySearchTree(oldRoot));
        

    }

}

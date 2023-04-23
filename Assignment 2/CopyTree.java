public class CopyTree {
    /*
     * Given a binary tree, create a deep copy. Return the root of the new tree
     * time: 40 min
     * Time Complexity: O(N) each node in the tree is visited only once by recursion traversal
     * Space Complexity: O(N) the space taken is the N height of the tree given
     */

    //TreeNode root;

    public static class TreeNode{
        TreeNode root;
        int key;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val){
            root = null;
            key = val;
            left = null;
            right = null;
        }
        
    };

    // public CopyTree(BinarySearchTree tree){
    //     root = tree.root;
    // }

    public static TreeNode copyTree(TreeNode oldRoot){ //read tree
        if(oldRoot == null){
            return null;
        }
        TreeNode newTreeNode = new TreeNode(oldRoot.key);
        newTreeNode.left = copyTree(oldRoot.left);
        newTreeNode.right = copyTree(oldRoot.right);

        
        
        //pointer at original tree
        //pointer at new tree
        //read node and insert in new tree
        return newTreeNode;


    }

    public static void printInOrder(TreeNode node){
        if(node != null){
            System.out.print(node.key + "->");
            printInOrder(node.left);
            printInOrder(node.right);
        }       
    }
    public static void main(String[] args) {

        //CopyTree newTree = new CopyTree();
       
        TreeNode oldRoot = new TreeNode(0);
        oldRoot.left = new TreeNode(2);
        oldRoot.right = new TreeNode(3);
        oldRoot.left.left = new TreeNode(4);
        oldRoot.left.right = new TreeNode(5);

        System.out.println("Old Tree");
        printInOrder(oldRoot);

        TreeNode newTree = copyTree(oldRoot);
        System.out.println(" ");
        System.out.println("New Tree");
        printInOrder(newTree);
    }
    
}

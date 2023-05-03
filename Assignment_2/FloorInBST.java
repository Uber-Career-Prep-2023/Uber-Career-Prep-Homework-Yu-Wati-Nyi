public class FloorInBST {
    //Given a target numeric value and a binary search tree, return the floor (greatest element less than or equal to the target) in the BST.
    /**
     * time taken: 1.5 hour
     * time complexity: O(N)
     * space complexity: O(N)
     * 
     * Binary Search Tree, Inorder Breadth first search Traversal
     */
    
    //create TreeNode class
    public static class TreeNode{
        int key;
        TreeNode left;
        TreeNode right;

        public TreeNode(int data){
            key = data;
            left = null;
            right = null;
        }
    }

    public static int floorBST(TreeNode newRoot, int target){

        //base case: if target is the same as root
        if(newRoot == null ||newRoot.key == target){
            return newRoot.key;
        }
        //if target is bigger than current root
        if(newRoot.key< target){
            //traverse to the right 
            return floorBST(newRoot.right, target);
        }
        //if target is between the current root and the root.right
        if(target < newRoot.right.key && target > newRoot.key){
            return newRoot.key;
        }
        //if the target is between the current root and root.left
        if(target > newRoot.left.key && target < newRoot.key){
            return newRoot.left.key;
        }
        //traverse to the left
        return floorBST(newRoot.left, target);
        
    }


   
    public static void main(String[] args) {
        TreeNode treeRootBST = new TreeNode(10);

        treeRootBST.left = new TreeNode(8);
        treeRootBST.left.right = new TreeNode(9);

        treeRootBST.right = new TreeNode(16);
        treeRootBST.right.left = new TreeNode(13);
        treeRootBST.right.right = new TreeNode(17);
        treeRootBST.right.right.right = new TreeNode(20);

        
        System.out.println(floorBST(treeRootBST, 15));
    }
}

import java.util.ArrayList;

public class LeftView {
    //Given a binary tree, create an array of the left view (leftmost elements in each level) of the tree.
    /**
     * time-taken: 1.5 hour
     * time complexity: O(N)
     * space complexity: O(N)
     * 
     * Pre-order Traversal
     */
    public static class TreeNode{
        int key;
        TreeNode left;
        TreeNode right;

        public TreeNode(int d){
            key = d;
            left = null;
            right = null;
        }

    }

    public static ArrayList<Integer> leftView(TreeNode newRoot){

        ArrayList<Integer> leftMostTree = new ArrayList<Integer>();

        return leftViewHelper(newRoot, leftMostTree);
    }
    
    
    public static ArrayList<Integer> leftViewHelper(TreeNode newRoot, ArrayList<Integer> newList){

        //new pointer at root
        TreeNode root = newRoot;
        
        if(root == null){
            return newList;
        }

        newList.add(root.key);

        if(root.left != null){
            leftViewHelper(root.left, newList);
        }
        if(root.left == null && root.right != null){
            leftViewHelper(root.right, newList);
        }
        
        return newList;
        
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

        
        System.out.println(leftView(treeRootBST));
    }
}

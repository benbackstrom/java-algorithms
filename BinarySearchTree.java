import java.util.*;

public class BinarySearchTree {

    public static void main(String[] args) {
        {
            // Valid case
            TreeNode node1 = new TreeNode(1);
            TreeNode node2 = new TreeNode(2);
            TreeNode node3 = new TreeNode(3);
            TreeNode node4 = new TreeNode(4);
            TreeNode node5 = new TreeNode(5);
            TreeNode node6 = new TreeNode(6);
            TreeNode node7 = new TreeNode(7);

            node5.left = node3;
            node5.right = node7;
            node3.left = node2;
            node3.right = node4;
            node7.left = node6;

            System.out.println("Valid tree test: ");
            System.out.println(validBST(node5));
        }

        System.out.println();

        {
            // Invalid case
            TreeNode node1 = new TreeNode(1);
            TreeNode node2 = new TreeNode(2);
            TreeNode node3 = new TreeNode(3);
            TreeNode node4 = new TreeNode(4);
            TreeNode node5 = new TreeNode(5);
            TreeNode node6 = new TreeNode(6);
            TreeNode node7 = new TreeNode(7);

            node5.left = node4;
            node5.right = node6;
            node4.left = node2;
            node4.right = node3;
            node6.left = node7;

            System.out.println("Invalid tree test: ");
            System.out.println(validBST(node5));
        }
    }

    public static boolean validBST(TreeNode root) {
        if (root == null)
            return true;
        
        return isValid(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    
    private static boolean isValid(TreeNode current, long leftBound, long rightBound) {
        boolean leftIsValid  = current.left == null  || 
            current.val > current.left.val 
            && current.left.val > leftBound
            && isValid(current.left, leftBound, current.val);
        boolean rightIsValid = current.right == null || 
            current.val < current.right.val 
            && current.right.val < rightBound
            && isValid(current.right, current.val, rightBound);
        
        return leftIsValid && rightIsValid;
    }

    public static class TreeNode {
        public TreeNode left;
        public TreeNode right;
        public int val;

        public TreeNode(int value) {
            val = value;
        }
    }
}
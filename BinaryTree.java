import java.util.*;

class BinaryTree {

    public static void main(String[] args) {
        {
            TreeNode depthFirstRoot = new TreeNode(5);
    
            TreeNode depthFirst1 = new TreeNode(1);
            TreeNode depthFirst4 = new TreeNode(4);
            depthFirstRoot.left = depthFirst1;
            depthFirstRoot.right = depthFirst4;
    
            TreeNode depthFirst2 = new TreeNode(2);
            TreeNode depthFirst3 = new TreeNode(3);
            depthFirst4.left = depthFirst2;
            depthFirst4.right = depthFirst3;
    
            List<Integer> results = new LinkedList<>();
            depthFirstTraversal(depthFirstRoot, results);
    
            System.out.println("Depth first traversal results: ");
            for (Integer value : results)
                System.out.print(value + " ");
    
            System.out.println();
            System.out.println();
        }

        {
            TreeNode depthFirstRoot = new TreeNode(5);
    
            TreeNode depthFirst1 = new TreeNode(1);
            TreeNode depthFirst4 = new TreeNode(4);
            depthFirstRoot.left = depthFirst1;
            depthFirstRoot.right = depthFirst4;
    
            TreeNode depthFirst2 = new TreeNode(2);
            TreeNode depthFirst3 = new TreeNode(3);
            depthFirst4.left = depthFirst2;
            depthFirst4.right = depthFirst3;
    
            List<Integer> results = new LinkedList<>();
            depthFirstTraversalRecursive(depthFirstRoot, results);
    
            System.out.println("Depth first traversal results: ");
            for (Integer value : results)
                System.out.print(value + " ");
    
            System.out.println();
            System.out.println();
        }

        {
            TreeNode breadthFirstRoot = new TreeNode(1);
    
            TreeNode breadthFirst2 = new TreeNode(2);
            TreeNode breadthFirst3 = new TreeNode(3);
            breadthFirstRoot.left = breadthFirst2;
            breadthFirstRoot.right = breadthFirst3;
    
            TreeNode breadthFirst4 = new TreeNode(4);
            TreeNode breadthFirst5 = new TreeNode(5);
            breadthFirst3.left = breadthFirst4;
            breadthFirst3.right = breadthFirst5;
    
            List<Integer> results = new LinkedList<>();
            breadthFirstTraversal(breadthFirstRoot, results);
    
            System.out.println("Breadth first traversal results: ");
            for (Integer value : results)
                System.out.print(value + " ");
    
            System.out.println();
            System.out.println();
        }
    }

    public static void depthFirstTraversal(TreeNode node, List<Integer> values) {
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode current = node;

        while (current != null) {
            if (current.left != null && !current.left.visited) {
                stack.addLast(current);
                current = current.left;
                continue;
            }
            
            if (current.right != null && !current.right.visited) {
                stack.addLast(current);
                current = current.right;
                continue;
            }

            values.add(current.value);
            current.visited = true;
            current = stack.pollLast();
        }
    }

    public static void depthFirstTraversalRecursive(TreeNode node, List<Integer> values) {
        if (node == null)
            return;
        
        depthFirstTraversalRecursive(node.left, values);
        depthFirstTraversalRecursive(node.right, values);
        values.add(node.value);
    }

    public static void breadthFirstTraversal(TreeNode root, List<Integer> values) {
        if (root == null)
            return;
        
        Deque<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (queue.size() > 0) {
            Deque<TreeNode> tempQueue = new LinkedList<>();

            while (queue.size() > 0) {
                TreeNode node = queue.removeFirst();
                values.add(node.value);

                if (node.left != null)
                    tempQueue.add(node.left);

                if (node.right != null)
                    tempQueue.add(node.right);
                
                queue = tempQueue;
            }
        }
    }

    public static class TreeNode {
        public final int value;
        public boolean visited;
        public TreeNode left;
        public TreeNode right;

        TreeNode(int val) { 
            this.value = val; 
        }
    }
}
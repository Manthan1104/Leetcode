/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
         List<List<Integer>> result = new ArrayList<>();

        // If the tree is empty, return an empty list
        if (root == null) return result;

        // Queue to store nodes for BFS (level order traversal)
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        // Boolean flag to control traversal direction
        boolean leftToRight = true;

        // Loop until all levels are processed
        while (!q.isEmpty()) {
            // Get the number of nodes at the current level
            int size = q.size();

            // Temporary array to store current level's values in zigzag order
            Integer[] level = new Integer[size];

            // Process each node in the current level
            for (int i = 0; i < size; i++) {
                // Get the front node from the queue
                TreeNode node = q.poll();

                // Determine index where this value should be stored
                int index = leftToRight ? i : size - 1 - i;
                level[index] = node.val;

                // Add left child to queue if it exists
                if (node.left != null) q.offer(node.left);
                // Add right child to queue if it exists
                if (node.right != null) q.offer(node.right);
            }

            // Flip traversal direction for the next level
            leftToRight = !leftToRight;

            // Add current level to the final result
            result.add(Arrays.asList(level));
        }

        // Return the zigzag traversal result
        return result;
    }
}
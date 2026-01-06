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
    public int maxLevelSum(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        int max = root.val;
        queue.offer(root);
        int maxLevel = 1;
        int currentLevel = 1;
        while(!queue.isEmpty()){
            int queueSize = queue.size();
            int sum = 0;
            for(int i=0;i<queueSize;i++){
                TreeNode val = queue.poll();
                if(val.left!=null){
                    queue.offer(val.left);
                }
                if(val.right!=null){
                    queue.offer(val.right);
                }
                sum+= val.val;
            }
            if(sum>max){
                max = sum;
                maxLevel = currentLevel;
            }
            currentLevel++;
        }
        return maxLevel;
    }
}
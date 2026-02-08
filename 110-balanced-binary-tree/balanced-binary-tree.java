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
    public boolean isBalanced(TreeNode root) {
        if(height(root)!=-1) return true;
        else return false;
    }

    public int height(TreeNode root){
         if(root==null)return 0;
        int lhs=height(root.left);
        int rhs=height(root.right);
        if(lhs==-1)return -1;
         if(rhs==-1)return -1;

        if(Math.abs(lhs-rhs)>1)return -1;
        return 1+Math.max(lhs,rhs);
    }
}
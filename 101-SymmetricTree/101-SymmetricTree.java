// Last updated: 4/24/2026, 10:36:05 AM
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
    public boolean isSymmetric(TreeNode root) {

        return naive(root);
    }

    public boolean naive(TreeNode root){
        if(root == null) return true;
        return isMirror(root.left, root.right);
    }

    public boolean isMirror(TreeNode T1, TreeNode T2){
        if(T1 == null && T2 == null) return true;
        if(T1 == null || T2 == null) return false;
        if(T1.val != T2.val) return false;

        return isMirror(T1.left, T2.right) && isMirror(T1.right, T2.left);
    }
}
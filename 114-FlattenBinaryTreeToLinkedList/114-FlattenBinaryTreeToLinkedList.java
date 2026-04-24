// Last updated: 4/24/2026, 10:35:53 AM
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
    public void flatten(TreeNode root) {
        if(root == null) return;
        TreeNode node = root;
        if(node.left!=null){
            node = node.left;
            while(node.right != null){
                node = node.right;
            }
            node.right = root.right;
            root.right = root.left;
            root.left = null;
        }
        
        flatten(root.right);
    }
}
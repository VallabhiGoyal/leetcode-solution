// Last updated: 4/24/2026, 10:33:22 AM
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
    public boolean findTarget(TreeNode root, int k) {
        if(root == null) return false;
        HashSet<Integer> set = new HashSet<>();
        return helper(root, k, set);
    }

    public boolean helper(TreeNode root, int k, Set<Integer> set){
        if(root == null) return false;
        
        if(k-root.val!=root.val && set.contains(k-root.val)) return true;
        set.add(root.val);

        return helper(root.left, k, set) || helper(root.right, k, set);
    }
}
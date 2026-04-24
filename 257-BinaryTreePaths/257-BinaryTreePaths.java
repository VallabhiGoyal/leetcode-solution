// Last updated: 4/24/2026, 10:34:43 AM
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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<>();
        if(root == null) return list;
        paths(root, new ArrayList<>(), list);
        return list;
    }

    private void paths(TreeNode root, List<String> currPath, List<String> list){
        if(root == null) return;
        
        currPath.add(String.valueOf(root.val));
        
        if(root.left == null && root.right == null){
            list.add(String.join("->",currPath));
        }else{
            paths(root.left, currPath, list);
            paths(root.right, currPath, list);
        }

        currPath.remove(currPath.size()-1);
    }
}
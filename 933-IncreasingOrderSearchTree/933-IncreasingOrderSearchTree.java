// Last updated: 4/24/2026, 10:32:43 AM
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
    public TreeNode increasingBST(TreeNode root) {
        if(root == null) return root;
        List<Integer> list = new ArrayList<>();
        inorder(root, list);
        return createBST(list);
    }

    private void inorder(TreeNode root, List<Integer> list){
        if(root == null) return;
        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }

    private TreeNode createBST(List<Integer> list){
        if(list.isEmpty()) return null;
        TreeNode root = new TreeNode(list.get(0));
        TreeNode temp = root;

        for(int i = 1; i<list.size(); i++){
            temp.right = new TreeNode(list.get(i));
            temp = temp.right;
        }

        return root;
    }
}
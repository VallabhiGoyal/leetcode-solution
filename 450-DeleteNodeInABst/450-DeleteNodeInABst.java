// Last updated: 4/24/2026, 10:33:54 AM
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
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) return root;

        if(root.val == key){
            //0 child
            if(root.left == null && root.right == null){
                return null;
            }

            //1 child
            if(root.left == null){
                return root.right;
            }
            if(root.right == null){
                return root.left;
            }

            //2 child
            TreeNode temp = root.left;
            while(temp.right != null){
                temp = temp.right;
            }
            root.val = temp.val;
            root.left = deleteNode(root.left, temp.val);
        }else if(root.val > key){
            root.left = deleteNode(root.left, key);
        }else{
            root.right = deleteNode(root.right, key);
        }
        return root;
    }

}
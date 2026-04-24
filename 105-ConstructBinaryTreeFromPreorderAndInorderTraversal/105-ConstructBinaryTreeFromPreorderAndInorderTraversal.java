// Last updated: 4/24/2026, 10:36:00 AM
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
    static int index;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        index = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        int n = preorder.length;
        if(n == 0) return null;

        for(int i = 0; i<n; i++){
            map.put(inorder[i], i);
        }

        return helper(preorder, inorder, 0, preorder.length -1, map);
    }

    private TreeNode helper(int[] preorder, int[] inorder, int left, int right, HashMap<Integer, Integer> map){
        if(left> right){
            return null;
        }

        int rootVal = preorder[index++];

        int indexIn = map.get(rootVal);
        TreeNode root = new TreeNode(rootVal);

        root.left = helper(preorder, inorder, left, indexIn - 1, map);
        root.right = helper(preorder, inorder,indexIn + 1 ,right, map);
        
        return root;
    }

}
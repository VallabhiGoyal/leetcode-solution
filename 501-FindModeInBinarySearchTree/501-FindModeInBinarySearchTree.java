// Last updated: 4/24/2026, 10:33:48 AM
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
    private Integer prev = null;
    private int count = 0;
    private int maxCount = 0;
    private List<Integer> modes = new ArrayList<>();

    public int[] findMode(TreeNode root) {
        inorder(root);

        int size = modes.size();
        int[] arr = new int[size];
        for(int i = 0; i<size; i++){
            arr[i] = modes.get(i);
        } 
        return arr;
    }

    private void inorder(TreeNode root){
        if(root == null) return;

        inorder(root.left);

        if(prev == null || root.val != prev){
            count = 1;
        }else{
            count++;
        }

        if(count>maxCount){
            modes.clear();
            modes.add(root.val);
            maxCount = count;
        }else if(count == maxCount){
            modes.add(root.val);
        }

        prev = root.val;

        inorder(root.right);
    }
}
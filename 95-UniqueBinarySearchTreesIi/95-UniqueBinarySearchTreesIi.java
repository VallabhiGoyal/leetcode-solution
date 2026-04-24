// Last updated: 4/24/2026, 10:36:10 AM
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
    public List<TreeNode> generateTrees(int n) {
        return generate(1,n);
    }

    private List<TreeNode> generate(int start, int end){
        List<TreeNode> result = new ArrayList<>();

        if(start > end){
            result.add(null);
            return result;
        }

        for(int i = start; i<=end; i++){
            List<TreeNode> leftTree = generate(start, i-1);
            List<TreeNode> rightTree = generate(i+1, end);


            for(TreeNode left : leftTree){
                for(TreeNode right : rightTree){
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    result.add(root);
                }
            }
            
        }        
        
        return result;
    }
}
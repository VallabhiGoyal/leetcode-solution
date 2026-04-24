// Last updated: 4/24/2026, 10:32:16 AM
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
    public int maxLevelSum(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int max = root.val;
        int maxLevel = 0;
        int ansLevel = 1;
        while(!queue.isEmpty()){
            int sum = 0;
            int queueSize = queue.size();
            maxLevel++;

            for(int i = 0; i<queueSize; i++){
                TreeNode curr = queue.poll();
                sum+=curr.val;
                
                if(curr.left != null){
                    queue.offer(curr.left);
                }
                if(curr.right != null){
                    queue.offer(curr.right);
                }
            }

            if(sum>max){
                max = sum;
                ansLevel = maxLevel;
            }
        }

        return ansLevel;
    }
}
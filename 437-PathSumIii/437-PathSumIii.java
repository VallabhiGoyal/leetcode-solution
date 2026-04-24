// Last updated: 4/24/2026, 10:34:00 AM
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
    public int pathSum(TreeNode root, int targetSum) {
        if(root == null) return 0;
        Map<Long, Long> map = new HashMap<>();
        map.put(0L,1L);
        return countPaths(root, 0, map, targetSum);
    }

    private int countPaths(TreeNode root, long currSum, Map<Long, Long> map, int target){
        if(root == null) return 0;
        int count = 0;
        currSum += root.val;
        long previousSum = currSum - target;
        count += map.getOrDefault(previousSum, 0L);
        map.put(currSum, map.getOrDefault(currSum , 0L) + 1L);
        count += countPaths(root.left, currSum, map, target);
        count += countPaths(root.right, currSum, map, target);
        map.put(currSum, map.get(currSum) -1);
        return count;
    }
}
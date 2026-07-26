// Last updated: 7/26/2026, 7:10:55 AM
1/**
2 * Definition for a binary tree node.
3 * public class TreeNode {
4 *     int val;
5 *     TreeNode left;
6 *     TreeNode right;
7 *     TreeNode() {}
8 *     TreeNode(int val) { this.val = val; }
9 *     TreeNode(int val, TreeNode left, TreeNode right) {
10 *         this.val = val;
11 *         this.left = left;
12 *         this.right = right;
13 *     }
14 * }
15 */
16class Solution {
17    public int pathSum(TreeNode root, int targetSum) {
18        if(root == null) return 0;
19        Map<Long, Long> map = new HashMap<>();
20        map.put(0L,1L);
21        return countPaths(root, 0, map, targetSum);
22    }
23
24    private int countPaths(TreeNode root, long currSum, Map<Long, Long> map, int target){
25        if(root == null) return 0;
26        int count = 0;
27        currSum += root.val;
28        long previousSum = currSum - target;
29        count += map.getOrDefault(previousSum, 0L);
30        map.put(currSum, map.getOrDefault(currSum , 0L) + 1L);
31        count += countPaths(root.left, currSum, map, target);
32        count += countPaths(root.right, currSum, map, target);
33        map.put(currSum, map.get(currSum) -1);
34        return count;
35    }
36}
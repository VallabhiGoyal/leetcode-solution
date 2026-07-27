// Last updated: 7/27/2026, 5:40:19 AM
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
17    public TreeNode sortedArrayToBST(int[] nums) {
18        if(nums.length == 0) return null;
19        return sorted(nums, 0, nums.length-1);
20    }
21
22    private TreeNode sorted(int[] nums, int start, int end){
23        if(start>end) return null;
24
25        int mid = start + (end-start)/2;
26        TreeNode root = new TreeNode(nums[mid]);
27
28        root.left = sorted(nums, start, mid-1);
29        root.right= sorted(nums, mid+1, end);
30
31        return root;
32    }
33}
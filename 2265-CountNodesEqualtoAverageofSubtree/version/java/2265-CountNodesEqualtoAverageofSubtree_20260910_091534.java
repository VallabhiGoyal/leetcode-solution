// Last updated: 9/10/2026, 9:15:34 AM
1class Solution {
2    int ans = 0;
3
4    public int averageOfSubtree(TreeNode root) {
5        helper(root);
6        return ans;
7    }
8
9    public int[] helper(TreeNode root) {
10        if (root == null) {
11            return new int[]{0, 0};
12        }
13
14        int[] left = helper(root.left);
15        int[] right = helper(root.right);
16
17        int sum = left[0] + right[0] + root.val;
18        int count = left[1] + right[1] + 1;
19
20        int avg = sum / count;
21
22        if (avg == root.val) {
23            ans++;
24        }
25
26        return new int[]{sum, count};
27    }
28}
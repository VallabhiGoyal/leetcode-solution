// Last updated: 8/6/2026, 10:43:47 PM
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
17    int MAX = 0;
18
19    public int maxSumBST(TreeNode root) {
20        helper(root);
21        return MAX;
22    }
23
24    private Node helper(TreeNode root) {
25        if (root == null) {
26            return new Node(true, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);
27        }
28
29        Node left = helper(root.left);
30        Node right = helper(root.right);
31
32        if (left.isBST && right.isBST &&
33            root.val > left.max &&
34            root.val < right.min) {
35
36            int sum = root.val + left.sum + right.sum;
37            MAX = Math.max(MAX, sum);
38
39            int min = Math.min(root.val, left.min);
40            int max = Math.max(root.val, right.max);
41
42            return new Node(true, sum, min, max);
43        }
44
45        return new Node(false, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
46    }
47
48    class Node {
49        boolean isBST;
50        int sum;
51        int min;
52        int max;
53
54        Node(boolean isBST, int sum, int min, int max) {
55            this.isBST = isBST;
56            this.sum = sum;
57            this.min = min;
58            this.max = max;
59        }
60    }
61}
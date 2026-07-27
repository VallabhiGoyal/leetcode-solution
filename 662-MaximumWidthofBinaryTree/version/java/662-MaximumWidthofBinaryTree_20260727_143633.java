// Last updated: 7/27/2026, 2:36:33 PM
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
17    public int widthOfBinaryTree(TreeNode root) {
18        int max = 1;
19
20        Queue<Pair> q = new LinkedList<>();
21        q.add(new Pair(root, 0));
22        
23        while (!q.isEmpty()) {
24            int levelSize = q.size();
25
26            long first = q.peek().idx;
27            long last = first;
28
29            for (int i = 0; i < levelSize; i++) {
30                Pair curr = q.poll();
31
32                long idx = curr.idx - first;
33                last = idx;
34
35                if (curr.node.left != null) {
36                    q.offer(new Pair(curr.node.left, 2 * idx + 1));
37                }
38
39                if (curr.node.right != null) {
40                    q.offer(new Pair(curr.node.right, 2 * idx + 2));
41                }
42            }
43
44            max = Math.max(max, (int)(last + 1));
45        }
46
47        return max;
48    }
49
50    class Pair{
51        TreeNode node;
52        long idx;
53
54        Pair(TreeNode node, long idx){
55            this.node = node;
56            this.idx = idx;
57        }
58    }
59}
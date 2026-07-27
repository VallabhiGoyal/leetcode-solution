// Last updated: 7/27/2026, 5:41:16 AM
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
17    public List<List<Integer>> levelOrder(TreeNode root) {
18        List<List<Integer>> result = new ArrayList<>();
19
20        if(root == null) return result;
21        Queue<TreeNode> queue = new LinkedList<>();
22        queue.offer(root);
23
24        while(!queue.isEmpty()){
25            int levelSize = queue.size();
26            List<Integer> currLevel = new ArrayList<>(levelSize);
27            for(int i = 0; i<levelSize; i++){
28                TreeNode currentNode = queue.poll();
29                currLevel.add(currentNode.val);
30                if(currentNode.left!=null){
31                    queue.offer(currentNode.left);
32                }
33                if(currentNode.right!=null){
34                    queue.offer(currentNode.right);
35                }
36            }
37            result.add(currLevel);
38        }
39
40        return result;
41    }
42}
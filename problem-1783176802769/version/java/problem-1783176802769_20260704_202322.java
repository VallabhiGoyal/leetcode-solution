// Last updated: 7/4/2026, 8:23:22 PM
1class Solution {
2    public int maxValidPairSum(int[] nums, int k) {
3        int n = nums.length;
4
5        int max = 0;
6
7        PriorityQueue<Node> queue = new PriorityQueue<>((a, b) -> {
8            return b.val - a.val;
9        });
10        
11        for(int i = k; i<n; i++){
12            queue.add(new Node(nums[i], i));
13        }
14
15        for(int i = 0; i<=n-k; i++){
16
17            while(!queue.isEmpty() && queue.peek().idx - i < k) queue.remove();
18
19            if(!queue.isEmpty()){
20                max = Math.max(max, nums[i] + nums[queue.peek().idx]);
21            }
22        }
23
24        return max;
25    }
26
27    public class Node{
28        int val;
29        int idx;
30
31        Node(int val, int idx){
32            this.val = val;
33            this.idx = idx;
34        }
35    }
36}
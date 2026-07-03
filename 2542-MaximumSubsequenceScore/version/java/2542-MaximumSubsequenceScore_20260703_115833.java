// Last updated: 7/3/2026, 11:58:33 AM
1class Solution {
2    public long maxScore(int[] nums1, int[] nums2, int k) {
3        int n = nums1.length;
4
5        int[][] pair = new int[n][2]; 
6        for(int i = 0; i<n; i++){
7            pair[i][0] = nums1[i];
8            pair[i][1] = nums2[i];
9        }
10
11        Arrays.sort(pair, (a,b) -> b[1] - a[1]);
12
13        PriorityQueue<Integer> queue = new PriorityQueue<>();
14
15        long sum = 0;
16        long ans = 0;
17
18        for(int i = 0; i<n; i++){
19            queue.offer(pair[i][0]);
20            sum += pair[i][0];
21
22            if(queue.size() > k){
23                sum -= queue.poll();
24            }
25
26            if (queue.size() == k) {
27                ans = Math.max(ans, sum * pair[i][1]);
28            }
29        }
30
31        return ans;
32    }
33}
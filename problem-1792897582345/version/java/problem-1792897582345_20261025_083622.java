// Last updated: 10/25/2026, 8:36:22 AM
1class Solution {
2    public long maximizeSum(int[] nums, int k) {
3        int n = nums.length;
4
5        PriorityQueue<Integer> pq = new PriorityQueue<>();
6        int[] gain = new int[n];
7        for(int i = 0; i<n; i++){
8            int[] freq = new int[10];
9            int temp = nums[i];
10            while(temp != 0){
11                int remain = temp % 10;
12                freq[remain]++;
13                temp /= 10;
14            }
15            temp = 0;
16            for(int j = 9; j>=0; j--){
17                while(freq[j] != 0){
18                    temp = temp*10 + j;
19                    freq[j]--;
20                }
21            }
22            gain[i] = Math.max(temp - nums[i], 0); 
23            if(gain[i] > 0){
24                pq.add(gain[i]);
25            }
26            if(pq.size() > k) pq.poll();
27        }
28
29        long ans = 0;
30        for(int i = 0; i<n; i++){
31            ans += nums[i];
32        }
33
34        while(!pq.isEmpty()){
35            ans += pq.poll();
36        }
37
38        return ans;
39    }
40}
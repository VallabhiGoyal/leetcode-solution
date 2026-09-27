// Last updated: 9/27/2026, 8:51:33 AM
1class Solution {
2    public int maxSubarray(int[] nums) {
3        int n = nums.length;
4
5        int[] freq = new int[501];
6        int bad = 0;
7        int ans = 0;
8        
9        int j = 0;
10        for(int i = 0; i<n; i++){
11            int curr = nums[i];
12
13            while(j<i && !isValid(freq, curr)){
14                freq[nums[j++]]--;
15            }
16
17            freq[curr]++;
18            ans = Math.max(ans, i - j + 1);
19        }
20
21        return ans;
22    }
23
24    private boolean isValid(int[] freq, int curr){
25        for(int i = 1; i < 501; i++){
26            if(freq[i] == 0) continue;
27
28            int k = curr + i;
29            if(k <= 500 && freq[k] > 0) return false;
30            
31            k = curr - i;
32            if(k >= 1 && freq[k] > 0){
33                if(k != i) return false;
34
35                if(freq[i] >= 2) return false;
36            }
37
38        }
39
40        return true;
41    }
42}
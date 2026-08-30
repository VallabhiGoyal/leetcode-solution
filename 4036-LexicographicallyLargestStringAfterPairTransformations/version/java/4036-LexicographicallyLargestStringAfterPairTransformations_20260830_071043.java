// Last updated: 8/30/2026, 7:10:43 AM
1class Solution {
2    public String[] largestString(int[] nums) {
3        int n = nums.length;
4        
5        String[] ans = new String[n];
6
7        for(int i = 0; i<n; i++){
8            int curr = nums[i];
9            
10            StringBuilder sb = new StringBuilder();
11            if(((curr >> 26) & 1) == 1){
12                sb.append('z');
13                sb.append('z');
14            } 
15            for(int j = 25; j >= 0; j--){
16                int bit = (curr >> j) & 1;
17                if(bit == 1){
18                    sb.append((char)('a' + j));
19                }
20            }
21
22            ans[i] = sb.toString();
23        }
24
25        return ans;
26    }
27}
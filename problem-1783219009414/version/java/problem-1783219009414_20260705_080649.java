// Last updated: 7/5/2026, 8:06:49 AM
1class Solution {
2    public int maxDigitRange(int[] nums) {
3        int n = nums.length;
4
5        int[] freq = new int[10];
6        
7        for(int i = 0; i<n; i++){
8            int curr = nums[i];
9            int maxDigit = 0;
10            int minDigit = 9;
11            while(curr > 0){
12                int remain = curr % 10;
13                maxDigit = Math.max(remain, maxDigit);
14                minDigit = Math.min(remain, minDigit);
15                curr/=10;
16            }
17
18            int range = maxDigit - minDigit;
19            freq[range] += nums[i];
20        }
21
22        for(int i = 9; i>=0; i--){
23            if(freq[i] != 0){
24                return freq[i];
25            }
26        }
27
28        return 0;
29    }
30
31    
32}
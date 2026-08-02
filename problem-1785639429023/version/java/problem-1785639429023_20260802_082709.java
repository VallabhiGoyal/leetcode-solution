// Last updated: 8/2/2026, 8:27:09 AM
1class Solution {
2    public int countRatioSubarrays(int[] nums, int a, int b) {
3        int n = nums.length;
4
5        int[] preEven = new int[n];
6        int[] preOdd = new int[n];
7        
8        if(nums[0] % 2 == 0) preEven[0] = 1;
9        else preOdd[0] = 1;
10        for(int i = 1; i<n; i++){
11            preEven[i] = preEven[i-1];
12            preOdd[i] = preOdd[i-1];
13            
14            if(nums[i] % 2 == 0){
15                preEven[i]++;
16            }else{
17                preOdd[i]++;
18            }
19        }
20
21        int count = 0;
22        for(int i = 0; i<n; i++){
23            for(int j = i; j<n; j++){
24
25                int x;
26                int y;
27
28                if(i == 0){
29                    x = preEven[j];
30                    y = preOdd[j];
31                }else{
32                    x = preEven[j] - preEven[i-1];
33                    y = preOdd[j] - preOdd[i-1];
34                }
35
36                if(y > 0 &&  x * b <= y * a) count++;
37            }
38        }
39
40        return count;
41    }
42}
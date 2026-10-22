// Last updated: 10/22/2026, 6:36:07 AM
1class Solution {
2    public int minOperations(int[] nums) {
3        int n = nums.length;
4
5        if (n == 1) return 0;
6
7        // check inc 
8        int dec = -1;
9
10        for (int i = 1; i < n; i++) {
11            if (nums[i] != nums[i - 1] + 1) {
12                if (dec != -1) {
13                    dec = n + 1;
14                    break;
15                }
16                dec = i;
17            }
18        }
19
20        if (dec == -1) return 0;
21
22        if (dec < n) {
23            return Math.min(dec, 2 + (n - dec));
24        }
25
26        // check dec 
27        int inc = -1;
28
29        for (int i = 1; i < n; i++) {
30            if (nums[i] != nums[i - 1] - 1) {
31                if (inc != -1) {
32                    inc = n + 1;
33                    break;
34                }
35                inc = i;
36            }
37        }
38
39        if (inc == -1) return 1;
40
41        if (inc < n) {
42            return Math.min(inc, n - inc) + 1;
43        }
44
45        return -1;
46    }
47}
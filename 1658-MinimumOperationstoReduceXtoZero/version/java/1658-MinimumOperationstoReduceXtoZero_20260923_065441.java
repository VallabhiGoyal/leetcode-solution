// Last updated: 9/23/2026, 6:54:41 AM
1class Solution {
2    public int minOperations(int[] nums, int x) {
3        int n = nums.length;
4
5        int totalSum = 0;
6        for (int num : nums) {
7            totalSum += num;
8        }
9
10        int currSum = 0;
11        int i = 0;
12        int maxLen = -1;
13
14        for (int j = 0; j < n; j++) {
15            currSum += nums[j];
16
17            while (i < n && currSum > totalSum - x) {
18                currSum -= nums[i++];
19            }
20
21            if (currSum == totalSum - x) {
22                maxLen = Math.max(maxLen, j - i + 1);
23            }
24        }
25
26        if (maxLen == -1) return -1;
27
28        return n - maxLen;
29    }
30}
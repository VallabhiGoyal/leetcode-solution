// Last updated: 8/11/2026, 9:16:48 AM
1class Solution {
2    public int missingInteger(int[] nums) {
3        int n = nums.length;
4
5        int maxSum = nums[0];
6
7        for (int i = 1; i < n; i++) {
8            if (nums[i] == nums[i - 1] + 1) {
9                maxSum += nums[i];
10            } else {
11                break;
12            }
13        }
14
15        Arrays.sort(nums);
16
17        while (true) {
18            boolean found = false;
19
20            for (int num : nums) {
21                if (num == maxSum) {
22                    found = true;
23                    break;
24                }
25            }
26
27            if (!found) {
28                return maxSum;
29            }
30
31            maxSum++;
32        }
33    }
34}
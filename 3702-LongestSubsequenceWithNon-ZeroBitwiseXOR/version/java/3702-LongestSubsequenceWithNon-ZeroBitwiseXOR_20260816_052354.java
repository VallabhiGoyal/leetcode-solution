// Last updated: 8/16/2026, 5:23:54 AM
1class Solution {
2    public int longestSubsequence(int[] nums) {
3        int n = nums.length;
4
5        int xor = 0;
6        boolean hasNonZero = false;
7
8        for (int num : nums) {
9            xor ^= num;
10            if (num != 0) {
11                hasNonZero = true;
12            }
13        }
14
15        if (!hasNonZero) {
16            return 0;
17        }
18
19        if (xor != 0) {
20            return n;
21        }
22
23        return n - 1;
24    }
25}
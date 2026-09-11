// Last updated: 9/11/2026, 5:49:07 AM
1class Solution {
2    public int totalNumbers(int[] digits) {
3        boolean[] seen = new boolean[1000];
4        int ans = 0;
5
6        for (int i = 0; i < digits.length; i++) {
7            if (digits[i] == 0) continue;
8
9            for (int j = 0; j < digits.length; j++) {
10                if (j == i) continue;
11
12                for (int k = 0; k < digits.length; k++) {
13                    if (k == i || k == j) continue;
14
15                    if (digits[k] % 2 != 0) continue;
16
17                    int num = digits[i] * 100 + digits[j] * 10 + digits[k];
18
19                    if (!seen[num]) {
20                        seen[num] = true;
21                        ans++;
22                    }
23                }
24            }
25        }
26
27        return ans;
28    }
29}
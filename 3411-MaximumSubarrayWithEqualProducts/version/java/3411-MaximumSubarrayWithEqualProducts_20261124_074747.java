// Last updated: 11/24/2026, 7:47:47 AM
1class Solution {
2    public int maxLength(int[] nums) {
3        int n = nums.length;
4
5        int len = 1;
6
7        for (int i = 0; i < n; i++) {
8            long prod = 1;
9
10            for (int j = i; j < n; j++) {
11                prod *= nums[j];
12
13                long gcd = gcdArray(nums, i, j);
14                long lcm = lcmArray(nums, i, j);
15
16                if (prod == gcd * lcm) {
17                    len = Math.max(len, j - i + 1);
18                }
19            }
20        }
21
22        return len;
23    }
24
25    public long lcm(long a, long b) {
26        return a / gcd(a, b) * b;
27    }
28
29    public long lcmArray(int[] nums, int i, int j) {
30        long result = nums[i];
31
32        for (int idx = i + 1; idx <= j; idx++) {
33            result = lcm(result, nums[idx]);
34        }
35
36        return result;
37    }
38
39    public long gcd(long a, long b) {
40        while (b != 0) {
41            long temp = a % b;
42            a = b;
43            b = temp;
44        }
45
46        return a;
47    }
48
49    public long gcdArray(int[] nums, int i, int j) {
50        long result = nums[i];
51
52        for (int idx = i + 1; idx <= j; idx++) {
53            result = gcd(result, nums[idx]);
54
55            if (result == 1) return 1;
56        }
57
58        return result;
59    }
60}
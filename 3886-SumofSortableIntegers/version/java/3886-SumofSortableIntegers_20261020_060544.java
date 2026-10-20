// Last updated: 10/20/2026, 6:05:44 AM
1class Solution {
2    public int sortableIntegers(int[] nums) {
3        int n = nums.length;
4
5        int[] target = nums.clone();
6        Arrays.sort(target);
7
8        int ans = 0;
9
10        for (int i = 1; i * i <= n; i++) {
11            if (n % i != 0) {
12                continue;
13            }
14
15            if (isValid(nums, target, i)) {
16                ans += i;
17            }
18
19            int k = n / i;
20
21            if (k != i && isValid(nums, target, k)) {
22                ans += k;
23            }
24        }
25
26        return ans;
27    }
28
29    private boolean isValid(int[] nums, int[] target, int k) {
30        int n = nums.length;
31
32        for (int i = 0; i < n; i += k) {
33            if (!isRotation(nums, target, i, k)) {
34                return false;
35            }
36        }
37
38        return true;
39    }
40
41    private boolean isRotation(int[] nums, int[] target, int start, int k) {
42        int[] lps = new int[k];
43
44        for (int i = 1, j = 0; i < k; i++) {
45            while (j > 0 && target[start + i] != target[start + j]) {
46                j = lps[j - 1];
47            }
48
49            if (target[start + i] == target[start + j]) {
50                j++;
51            }
52
53            lps[i] = j;
54        }
55
56        for (int i = 0, j = 0; i < 2 * k - 1; i++) {
57            int num = nums[start + i % k];
58
59            while (j > 0 && num != target[start + j]) {
60                j = lps[j - 1];
61            }
62
63            if (num == target[start + j]) {
64                j++;
65            }
66
67            if (j == k) {
68                return true;
69            }
70        }
71
72        return false;
73    }
74}
75
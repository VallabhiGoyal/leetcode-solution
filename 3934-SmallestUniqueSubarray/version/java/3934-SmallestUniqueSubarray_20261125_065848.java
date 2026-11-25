// Last updated: 11/25/2026, 6:58:48 AM
1class Solution {
2    public int smallestUniqueSubarray(int[] nums) {
3        int n = nums.length;
4
5        int low = 0;
6        int high = n - 1;
7
8        while (low < high) {
9            int mid = low + (high - low) / 2;
10
11            if (helper(nums, mid)) {
12                high = mid;
13            } else {
14                low = mid + 1;
15            }
16        }
17
18        return low + 1;
19    }
20
21    public boolean helper(int[] nums, int len) {
22        int n = nums.length;
23
24        long MOD1 = 1_000_000_007L;
25        long MOD2 = 1_000_000_009L;
26
27        int p1 = 100003;
28        int p2 = 100019;
29
30        Map<Long, Integer> map = new HashMap<>();
31
32        long h1 = 0;
33        long h2 = 0;
34
35        for (int i = 0; i <= len; i++) {
36            h1 = (h1 * p1 + nums[i]) % MOD1;
37            h2 = (h2 * p2 + nums[i]) % MOD2;
38        }
39
40        long key = h1 * MOD2 + h2;
41        map.put(key, 1);
42
43        long power1 = 1;
44        long power2 = 1;
45
46        for (int i = 0; i < len; i++) {
47            power1 = (power1 * p1) % MOD1;
48            power2 = (power2 * p2) % MOD2;
49        }
50
51        for (int i = 1; i + len < n; i++) {
52
53            h1 = (((h1 - nums[i-1] * power1) % MOD1 + MOD1) % MOD1 * p1 + nums[i+len]) % MOD1;
54
55            h2 = (((h2 - nums[i-1] * power2) % MOD2 + MOD2) % MOD2 * p2 + nums[i+len]) % MOD2;
56
57            key = h1 * MOD2 + h2;
58
59            map.merge(key, 1, Integer::sum);
60        }
61
62        for (int value : map.values()) {
63            if (value == 1) return true;
64        }
65
66        return false;
67    }
68}
// Last updated: 11/4/2026, 9:23:10 PM
1class Solution {
2    TreeMap<Integer, Integer> left = new TreeMap<>();
3    TreeMap<Integer, Integer> right = new TreeMap<>();
4
5    int leftSize = 0, rightSize = 0;
6    long leftSum = 0, rightSum = 0;
7
8    void add(TreeMap<Integer, Integer> map, int val) {
9        map.put(val, map.getOrDefault(val, 0) + 1);
10    }
11
12    void remove(TreeMap<Integer, Integer> map, int val) {
13        int count = map.get(val);
14        if (count == 1) map.remove(val);
15        else map.put(val, count - 1);
16    }
17
18    void insert(int val) {
19        if (left.isEmpty() || val <= left.lastKey()) {
20            add(left, val);
21            leftSize++;
22            leftSum += val;
23        } else {
24            add(right, val);
25            rightSize++;
26            rightSum += val;
27        }
28        balance();
29    }
30
31    void erase(int val) {
32        if (left.containsKey(val)) {
33            remove(left, val);
34            leftSize--;
35            leftSum -= val;
36        } else {
37            remove(right, val);
38            rightSize--;
39            rightSum -= val;
40        }
41        balance();
42    }
43
44    void balance() {
45        while (leftSize > rightSize + 1) {
46            int val = left.lastKey();
47            remove(left, val);
48            add(right, val);
49            leftSize--;
50            rightSize++;
51            leftSum -= val;
52            rightSum += val;
53        }
54
55        while (leftSize < rightSize) {
56            int val = right.firstKey();
57            remove(right, val);
58            add(left, val);
59            rightSize--;
60            leftSize++;
61            rightSum -= val;
62            leftSum += val;
63        }
64    }
65
66    long getCost() {
67        long median = left.lastKey();
68        return median * leftSize - leftSum
69             + rightSum - median * rightSize;
70    }
71
72    public long minOperations(int[] nums, int x, int k) {
73        int n = nums.length;
74        long[] cost = new long[n];
75
76        left.clear();
77        right.clear();
78        leftSize = rightSize = 0;
79        leftSum = rightSum = 0;
80
81        for (int i = 0; i < n; i++) {
82            insert(nums[i]);
83
84            if (i >= x) {
85                erase(nums[i - x]);
86            }
87
88            if (i >= x - 1) {
89                cost[i - x + 1] = getCost();
90            }
91        }
92
93        long INF = Long.MAX_VALUE / 2;
94        long[][] dp = new long[n + 1][k + 1];
95
96        for (long[] row : dp) {
97            Arrays.fill(row, INF);
98        }
99
100        for (int i = 0; i <= n; i++) {
101            dp[i][0] = 0;
102        }
103
104        for (int i = 1; i <= n; i++) {
105            for (int j = 1; j <= k; j++) {
106                dp[i][j] = dp[i - 1][j];
107
108                if (i >= x && dp[i - x][j - 1] != INF) {
109                    dp[i][j] = Math.min(
110                        dp[i][j],
111                        dp[i - x][j - 1] + cost[i - x]
112                    );
113                }
114            }
115        }
116
117        return dp[n][k];
118    }
119}
120
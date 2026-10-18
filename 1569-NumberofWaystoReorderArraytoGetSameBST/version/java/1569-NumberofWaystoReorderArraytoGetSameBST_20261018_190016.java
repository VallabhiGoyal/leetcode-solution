// Last updated: 10/18/2026, 7:00:16 PM
1class Solution {
2    static int MOD = 1000000007;
3    long[][] dp;
4
5    public int numOfWays(int[] nums) {
6        int n = nums.length;
7
8        dp = new long[n + 1][n + 1];
9
10        for (int i = 0; i <= n; i++) {
11            dp[i][0] = 1;
12            dp[i][i] = 1;
13
14            for (int j = 1; j < i; j++) {
15                dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j]) % MOD;
16            }
17        }
18
19        List<Integer> list = new ArrayList<>();
20
21        for (int num : nums) {
22            list.add(num);
23        }
24
25        return (int) ((solve(list) - 1 + MOD) % MOD);
26    }
27
28    private long solve(List<Integer> nums) {
29        int n = nums.size();
30
31        if (n <= 2) {
32            return 1;
33        }
34
35        int root = nums.get(0);
36
37        List<Integer> left = new ArrayList<>();
38        List<Integer> right = new ArrayList<>();
39
40        for (int i = 1; i < n; i++) {
41            if (nums.get(i) < root) {
42                left.add(nums.get(i));
43            } else {
44                right.add(nums.get(i));
45            }
46        }
47
48        long leftWays = solve(left);
49        long rightWays = solve(right);
50
51        long ways = dp[n - 1][left.size()];
52        ways = (ways * leftWays) % MOD;
53        ways = (ways * rightWays) % MOD;
54
55        return ways;
56    }
57}
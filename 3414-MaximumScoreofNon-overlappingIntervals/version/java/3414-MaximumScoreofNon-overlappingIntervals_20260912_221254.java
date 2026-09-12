// Last updated: 9/12/2026, 10:12:54 PM
1class Solution {
2    public int[] maximumWeight(List<List<Integer>> intervals) {
3        int n = intervals.size();
4
5        int[][] arr = new int[n][4];
6
7        for (int i = 0; i < n; i++) {
8            arr[i][0] = intervals.get(i).get(0);
9            arr[i][1] = intervals.get(i).get(1);
10            arr[i][2] = intervals.get(i).get(2);
11            arr[i][3] = i;
12        }
13
14        Arrays.sort(arr, (a, b) -> {
15            if (a[0] != b[0]) return Integer.compare(a[0], b[0]);
16            return Integer.compare(a[1], b[1]);
17        });
18
19        long[][] dp = new long[n + 1][5];
20        List<Integer>[][] chosen = new ArrayList[n + 1][5];
21
22        for (int i = 0; i <= n; i++) {
23            for (int k = 0; k <= 4; k++) {
24                chosen[i][k] = new ArrayList<>();
25            }
26        }
27
28        for (int i = n - 1; i >= 0; i--) {
29            for (int k = 1; k <= 4; k++) {
30                dp[i][k] = dp[i + 1][k];
31                chosen[i][k] = new ArrayList<>(chosen[i + 1][k]);
32
33                int next = findNext(arr, i);
34
35                long take = arr[i][2] + dp[next][k - 1];
36
37                List<Integer> takeList = new ArrayList<>();
38                takeList.add(arr[i][3]);
39                takeList.addAll(chosen[next][k - 1]);
40
41                Collections.sort(takeList);
42
43                if (take > dp[i][k] ||
44                    (take == dp[i][k] && compare(takeList, chosen[i][k]) < 0)) {
45                    dp[i][k] = take;
46                    chosen[i][k] = takeList;
47                }
48            }
49        }
50
51        List<Integer> ans = chosen[0][4];
52        Collections.sort(ans);
53
54        int[] result = new int[ans.size()];
55        for (int i = 0; i < ans.size(); i++) {
56            result[i] = ans.get(i);
57        }
58
59        return result;
60    }
61
62    private int findNext(int[][] arr, int i) {
63        int low = i + 1;
64        int high = arr.length;
65
66        while (low < high) {
67            int mid = low + (high - low) / 2;
68
69            if (arr[mid][0] > arr[i][1]) {
70                high = mid;
71            } else {
72                low = mid + 1;
73            }
74        }
75
76        return low;
77    }
78
79    private int compare(List<Integer> a, List<Integer> b) {
80        int n = Math.min(a.size(), b.size());
81
82        for (int i = 0; i < n; i++) {
83            if (!a.get(i).equals(b.get(i))) {
84                return Integer.compare(a.get(i), b.get(i));
85            }
86        }
87
88        return Integer.compare(a.size(), b.size());
89    }
90}
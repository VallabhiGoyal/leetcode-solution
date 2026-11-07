// Last updated: 11/7/2026, 2:27:21 PM
1class Solution {
2    public int[] countServers(int n, int[][] logs, int x, int[] queries) {
3        Arrays.sort(logs, (a, b) -> a[1] - b[1]);
4
5        int m = queries.length;
6        int[][] q = new int[m][2];
7
8        for (int i = 0; i < m; i++) {
9            q[i][0] = queries[i];
10            q[i][1] = i;
11        }
12
13        Arrays.sort(q, (a, b) -> a[0] - b[0]);
14
15        int[] ans = new int[m];
16        Map<Integer, Integer> map = new HashMap<>();
17
18        int left = 0, right = 0;
19
20        for (int i = 0; i < m; i++) {
21            int start = q[i][0] - x;
22            int end = q[i][0];
23
24            while (right < logs.length && logs[right][1] <= end) {
25                map.put(logs[right][0],
26                    map.getOrDefault(logs[right][0], 0) + 1);
27                right++;
28            }
29
30            while (left < right && logs[left][1] < start) {
31                int id = logs[left][0];
32
33                map.put(id, map.get(id) - 1);
34
35                if (map.get(id) == 0) {
36                    map.remove(id);
37                }
38
39                left++;
40            }
41
42            ans[q[i][1]] = n - map.size();
43        }
44
45        return ans;
46    }
47}
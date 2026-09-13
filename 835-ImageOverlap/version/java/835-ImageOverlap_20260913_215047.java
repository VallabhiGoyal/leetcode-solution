// Last updated: 9/13/2026, 9:50:47 PM
1class Solution {
2    public int largestOverlap(int[][] img1, int[][] img2) {
3        int n = img1.length;
4        List<int[]> ones1 = new ArrayList<>();
5        List<int[]> ones2 = new ArrayList<>();
6
7        for (int i = 0; i < n; i++) {
8            for (int j = 0; j < n; j++) {
9                if (img1[i][j] == 1) ones1.add(new int[]{i, j});
10                if (img2[i][j] == 1) ones2.add(new int[]{i, j});
11            }
12        }
13
14        Map<String, Integer> shiftCount = new HashMap<>();
15        int ans = 0;
16
17        for (int[] p1 : ones1) {
18            for (int[] p2 : ones2) {
19                String key = (p1[0] - p2[0]) + "," + (p1[1] - p2[1]);
20                int updated = shiftCount.merge(key, 1, Integer::sum);
21                ans = Math.max(ans, updated);
22            }
23        }
24
25        return ans;
26    }
27}
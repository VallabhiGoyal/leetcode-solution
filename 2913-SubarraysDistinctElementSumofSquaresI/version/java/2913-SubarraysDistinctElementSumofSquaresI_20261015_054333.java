// Last updated: 10/15/2026, 5:43:33 AM
1class Solution {
2    public int sumCounts(List<Integer> nums) {
3        int n = nums.size();
4        int answer = 0;
5
6        for (int i = 0; i < n; i++) {
7            boolean[] seen = new boolean[101];
8            int distinct = 0;
9
10            for (int j = i; j < n; j++) {
11                int num = nums.get(j);
12
13                if (!seen[num]) {
14                    seen[num] = true;
15                    distinct++;
16                }
17
18                answer += distinct * distinct;
19            }
20        }
21
22        return answer;
23    }
24}
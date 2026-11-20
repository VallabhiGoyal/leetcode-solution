// Last updated: 11/20/2026, 6:56:44 PM
1class Solution {
2    public int maxSelectedElements(int[] nums) {
3        Arrays.sort(nums);
4
5        Map<Integer, Integer> dp = new HashMap<>();
6
7        int ans = 0;
8
9        for (int num : nums) {
10            int one = dp.getOrDefault(num, 0);
11            int two = dp.getOrDefault(num - 1, 0);
12
13            dp.put(num, Math.max(dp.getOrDefault(num, 0), two + 1));
14            dp.put(num + 1, Math.max(dp.getOrDefault(num + 1, 0), one + 1));
15
16            ans = Math.max(ans, Math.max(dp.get(num), dp.get(num + 1)));
17        }
18
19        return ans;
20    }
21}
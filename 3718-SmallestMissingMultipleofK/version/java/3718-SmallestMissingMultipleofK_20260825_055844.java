// Last updated: 8/25/2026, 5:58:44 AM
1class Solution {
2    public int missingMultiple(int[] nums, int k) {
3
4        Set<Integer> hash = new HashSet<>();
5
6        for(int num : nums) {
7            hash.add(num);
8        }
9
10        int multiple = k;
11
12        while(hash.contains(multiple)) {
13
14            multiple = multiple + k;
15
16        }
17
18        return multiple;
19    }
20}
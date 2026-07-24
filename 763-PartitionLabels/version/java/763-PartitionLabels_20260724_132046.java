// Last updated: 7/24/2026, 1:20:46 PM
1class Solution {
2    public List<Integer> partitionLabels(String s) {
3        int[] lastOccurrence = new int[26];
4        for (int i = 0; i < s.length(); i++) {
5            lastOccurrence[s.charAt(i) - 'a'] = i;
6        }
7
8        List<Integer> partitions = new ArrayList<>();
9        int start = 0, end = 0;
10
11        for (int i = 0; i < s.length(); i++) {
12            end = Math.max(end, lastOccurrence[s.charAt(i) - 'a']);
13            if (i == end) {
14                partitions.add(end - start + 1);
15                start = i + 1;
16            }
17        }
18
19        return partitions;
20    }
21}
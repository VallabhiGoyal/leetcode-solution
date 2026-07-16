// Last updated: 7/16/2026, 8:10:18 AM
1class Solution {
2    public List<Integer> findAnagrams(String s, String p) {
3        List<Integer> ans = new ArrayList<>();
4
5        int m = s.length();
6        int n = p.length();
7
8        int[] freq = new int[26];
9        Set<Integer> set = new HashSet<>();
10
11        for(int i = 0; i<n; i++){
12            freq[p.charAt(i) - 'a']++;
13            set.add(p.charAt(i) - 'a');
14        }
15
16        int i = 0;
17        int j = 0;
18        int count = n;
19
20        while (j < m) {
21            if (freq[s.charAt(j) - 'a'] > 0) {
22                count--;
23            }
24            freq[s.charAt(j) - 'a']--;
25            j++;
26
27            if (count == 0) {
28                ans.add(i);
29            }
30
31            if (j - i == n) {
32                if (freq[s.charAt(i) - 'a'] >= 0) {
33                    count++;
34                }
35                freq[s.charAt(i) - 'a']++;
36                i++;
37            }
38        }
39
40        return ans;
41    }
42}
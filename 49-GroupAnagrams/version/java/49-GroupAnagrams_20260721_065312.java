// Last updated: 7/21/2026, 6:53:12 AM
1class Solution {
2    public List<List<String>> groupAnagrams(String[] strs) {
3        int n = strs.length;
4
5        Map<String, List<String>> map = new HashMap<>();
6
7        for(int i = 0; i<n; i++){
8            String curr = strs[i];
9            char[] ch = curr.toCharArray();
10            Arrays.sort(ch);
11            map.computeIfAbsent(new String(ch), k -> new ArrayList<>()).add(curr);
12        }
13
14        List<List<String>> ans = new ArrayList<>();
15        for(List<String> values : map.values()){
16            ans.add(values);
17        }
18
19        return ans;
20    }
21}
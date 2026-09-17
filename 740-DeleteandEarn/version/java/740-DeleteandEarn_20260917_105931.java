// Last updated: 9/17/2026, 10:59:31 AM
1class Solution {
2    public int numTilePossibilities(String tiles) {
3        int n = tiles.length();
4
5        Set<String> set = new HashSet<>();
6
7        for (int i = 0; i < n; i++) {
8            boolean[] visited = new boolean[n];
9            visited[i] = true;
10
11            StringBuilder curr = new StringBuilder();
12            curr.append(tiles.charAt(i));
13
14            helper(tiles, set, curr, visited);
15        }
16
17        return set.size();
18    }
19
20    public void helper(String tiles, Set<String> set,
21                       StringBuilder curr, boolean[] visited) {
22        set.add(curr.toString());
23
24        for (int i = 0; i < tiles.length(); i++) {
25            if (!visited[i]) {
26                visited[i] = true;
27                curr.append(tiles.charAt(i));
28
29                helper(tiles, set, curr, visited);
30
31                curr.deleteCharAt(curr.length() - 1);
32                visited[i] = false;
33            }
34        }
35    }
36}
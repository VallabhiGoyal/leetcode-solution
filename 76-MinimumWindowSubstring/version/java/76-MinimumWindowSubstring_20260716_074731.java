// Last updated: 7/16/2026, 7:47:31 AM
1class Solution {
2    public String minWindow(String s, String t) {
3        int m = s.length();
4        int n = t.length();
5        if(n>m) return "";
6
7        Map<Character, Integer> tmap = new HashMap<>();
8        for(int i = 0; i<n; i++){
9            tmap.put(t.charAt(i), tmap.getOrDefault(t.charAt(i), 0) + 1);
10        }
11
12        int i = 0;
13        int count = tmap.size();
14
15
16        int left = -1;
17        int right = -1;
18        int minLen = Integer.MAX_VALUE;
19
20        for(int j = 0; j<m; j++){
21            char ch = s.charAt(j);
22            if(tmap.containsKey(ch)){
23                tmap.put(ch, tmap.get(ch)-1);
24                if(tmap.get(ch) == 0) count--;
25            }
26
27            if(count == 0){
28                while(!tmap.containsKey(s.charAt(i)) || tmap.get(s.charAt(i)) < 0){
29                    char ch2 = s.charAt(i);
30                    if(tmap.containsKey(ch2)){
31                        tmap.put(ch2, tmap.get(ch2) + 1);
32                    }
33                    i++;
34                }
35                if(minLen > j-i+1){
36                    left = i;
37                    right = j;
38                    minLen = j-i+1;
39                }
40                char start = s.charAt(i);
41                if(tmap.containsKey(start)){
42                    tmap.put(start, tmap.get(start) + 1);
43                }
44                count++;
45                i++;
46            }
47        }
48        if(left == -1 || right == -1) return "";
49        return s.substring(left, right+1);
50    }
51}
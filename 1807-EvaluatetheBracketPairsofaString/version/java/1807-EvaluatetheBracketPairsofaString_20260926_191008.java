// Last updated: 9/26/2026, 7:10:08 PM
1class Solution {
2    public String evaluate(String s, List<List<String>> knowledge) {
3        
4        Map<String, String> map = new HashMap<>();
5        
6        for (List<String> pair : knowledge) {
7            map.put(pair.get(0), pair.get(1));
8        }
9
10        StringBuilder ans = new StringBuilder();
11
12        for (int i = 0; i < s.length(); i++) {
13            
14            if (s.charAt(i) == '(') {
15                int j = i + 1;
16
17                while (s.charAt(j) != ')') {
18                    j++;
19                }
20
21                String key = s.substring(i + 1, j);
22
23                if (map.containsKey(key)) {
24                    ans.append(map.get(key));
25                } else {
26                    ans.append("?");
27                }
28
29                i = j;
30            } else {
31                ans.append(s.charAt(i));
32            }
33        }
34
35        return ans.toString();
36    }
37}
// Last updated: 8/26/2026, 9:59:43 AM
1class Solution {
2    public String shortestBeautifulSubstring(String s, int k) {
3        int n = s.length();
4
5        List<Integer> list = new ArrayList<>();
6
7        int count = 0;
8        int i = 0;
9        int len = n + 1;
10
11        for (int j = 0; j < n; j++) {
12            int ch = s.charAt(j) - '0';
13            if (ch == 1) count++;
14
15            while (i < j && count > k) {
16                int temp = s.charAt(i) - '0';
17                if (temp == 1) count--;
18                i++;
19            }
20
21            while (i < j && s.charAt(i) == '0') {
22                i++;
23            }
24
25            if (count == k) {
26                if (len > j - i + 1) {
27                    len = j - i + 1;
28                    list.clear();
29                    list.add(i);
30                } else if (len == j - i + 1) {
31                    list.add(i);
32                }
33            }
34        }
35
36        if(list.isEmpty()) return "";
37
38        String newS = s.substring(list.get(0), list.get(0) + len);
39
40        for (i = 1; i < list.size(); i++) {
41            String temp = s.substring(list.get(i), list.get(i) + len);
42
43            if (newS.compareTo(temp) > 0) {
44                newS = temp;
45            }
46        }
47
48        return newS;
49    }
50}
// Last updated: 7/18/2026, 8:11:13 PM
1class Solution {
2    public String rearrangeString(String s, char x, char y) {
3        StringBuilder t = new StringBuilder();
4
5        if(s.indexOf(x) == -1 || s.indexOf(y) == -1) return s;
6        
7        int countY = 0;
8        int countX = 0;
9
10        int n = s.length();
11        for(int i = 0; i<n; i++){
12            char curr = s.charAt(i);
13            if(curr == y) countY++;
14            else if(curr == x) countX++;
15            else t.append(curr);
16        }
17
18        for(int i = 0; i<countX; i++){
19            t.append(x);
20        }
21
22        StringBuilder temp = new StringBuilder();
23        for(int i = 0; i<countY; i++){
24            temp.append(y);
25        }
26
27        return temp.append(t).toString();
28    }
29}
// Last updated: 7/28/2026, 9:44:13 AM
1class Solution {
2    public int repeatedStringMatch(String a, String b) {
3        int n1 = a.length();
4        int n2 = b.length();
5
6        boolean[] charInA = new boolean[26];
7
8        for (char c : a.toCharArray()) {
9            charInA[c - 'a'] = true;
10        }
11
12        for (char c : b.toCharArray()) {
13            if (!charInA[c - 'a']) {
14                return -1;
15            }
16        }
17
18        StringBuilder sb = new StringBuilder(a);
19        int count = 1;
20        while(sb.length() < n2){
21            sb.append(a);
22            count++;
23        }
24
25        if(sb.toString().contains(b)) return count;
26        sb.append(a);
27        if(sb.toString().contains(b)) return count+1;
28
29        return -1;
30    }
31}
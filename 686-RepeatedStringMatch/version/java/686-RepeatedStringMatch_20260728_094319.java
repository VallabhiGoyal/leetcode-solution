// Last updated: 7/28/2026, 9:43:19 AM
1class Solution {
2    public int repeatedStringMatch(String a, String b) {
3        int n1 = a.length();
4        int n2 = b.length();
5
6        StringBuilder sb = new StringBuilder(a);
7        int count = 1;
8        while(sb.length() < n2){
9            sb.append(a);
10            count++;
11        }
12
13        if(sb.toString().contains(b)) return count;
14        sb.append(a);
15        if(sb.toString().contains(b)) return count+1;
16
17        return -1;
18    }
19}
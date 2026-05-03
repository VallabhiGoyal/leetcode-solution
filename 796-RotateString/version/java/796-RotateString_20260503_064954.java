// Last updated: 5/3/2026, 6:49:54 AM
1class Solution {
2    public boolean rotateString(String s, String goal) {
3        int n = s.length();
4        if (n != goal.length()) return false;
5        if(s.equals(goal)) return true;
6
7        int k  = 1;
8        while(k<n){
9            String st1 = s.substring(0,k);
10            String st2 = s.substring(k,n);
11            
12            String rotated = st2 + st1;
13
14            if(rotated.equals(goal)) return true;
15            k++;
16        }
17
18        return false;
19    }
20}
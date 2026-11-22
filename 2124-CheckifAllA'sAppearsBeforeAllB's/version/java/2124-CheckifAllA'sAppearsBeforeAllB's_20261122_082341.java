// Last updated: 11/22/2026, 8:23:41 AM
1class Solution {
2    public boolean checkString(String s) {
3        int n = s.length();
4        
5        boolean a = true;
6        boolean b = false;
7
8        for(int i = 0; i<n; i++){
9            char ch = s.charAt(i);
10            if(ch == 'a' && !b) continue;
11            if(ch == 'b') b = true;
12            if(ch == 'a' && b) return false;
13        }
14
15        return true;
16    }
17}
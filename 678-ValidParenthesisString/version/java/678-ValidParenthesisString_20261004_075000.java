// Last updated: 10/4/2026, 7:50:00 AM
1class Solution {
2    public boolean checkValidString(String s) {
3        int n = s.length();
4
5        int min = 0;
6        int max = 0;
7
8        for(int i = 0; i<n; i++){
9            char ch = s.charAt(i);
10            if(ch == '('){
11                min++;
12                max++;
13            }
14            else if(ch == ')'){
15                if(min > 0) min--;
16                max--;
17                if(max < 0) return false;
18            }else{
19                if(min > 0) min--;
20                max++;
21            }
22        }
23
24        return min == 0;
25    }
26}
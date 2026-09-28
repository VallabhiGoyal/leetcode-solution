// Last updated: 9/28/2026, 5:37:49 AM
1class Solution {
2    public int maxDepth(String s) {
3        int count = 0;
4        int max = 0;
5
6        for(char c:s.toCharArray()){
7            if(c == '('){
8                count++;
9                max = Math.max(max, count);
10            }else if(c ==')'){
11                count--;
12            }
13        }
14
15        return max;
16    }
17}
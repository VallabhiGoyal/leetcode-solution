// Last updated: 9/28/2026, 5:36:42 AM
1class Solution {
2    public int maxDepth(String s) {
3        int n = s.length();
4
5        Stack<Character> stack = new Stack<>();
6
7        int len = 0;
8
9        for(int i = 0; i<n; i++){
10            char ch = s.charAt(i);
11
12            if(ch == '(') stack.push('(');
13
14            else if(ch == ')'){
15                len = Math.max(len, stack.size());
16                stack.pop();
17            }
18        }
19
20        return len;
21    }
22}
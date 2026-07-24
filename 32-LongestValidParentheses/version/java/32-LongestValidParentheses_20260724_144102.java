// Last updated: 7/24/2026, 2:41:02 PM
1class Solution {
2    public int longestValidParentheses(String s) {
3        int n = s.length();
4
5        Stack<Integer> stack = new Stack<>();
6        stack.push(-1);
7
8        int maxLen = 0;
9
10        for(int i = 0; i<n; i++){
11            char ch = s.charAt(i);
12
13            if(ch == '('){
14                stack.push(i);
15            }else{
16                stack.pop();
17
18                if(stack.isEmpty()){
19                    stack.push(i);
20                }else{
21                    maxLen = Math.max(maxLen, i - stack.peek());
22                }
23            }
24
25        }
26
27        return maxLen;
28    }
29}
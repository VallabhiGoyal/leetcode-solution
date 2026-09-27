// Last updated: 9/27/2026, 10:58:02 PM
1class Solution {
2    public String reverseParentheses(String s) {
3        Stack<Character> stack = new Stack<>();
4
5        for(char ch : s.toCharArray()) {
6            if(ch == ')') {
7                StringBuilder temp = new StringBuilder();
8
9                while(stack.peek() != '(') {
10                    temp.append(stack.pop());
11                }
12
13                stack.pop();
14
15                for(int i = 0; i < temp.length(); i++) {
16                    stack.push(temp.charAt(i));
17                }
18            } else {
19                stack.push(ch);
20            }
21        }
22
23        StringBuilder ans = new StringBuilder();
24
25        while(!stack.isEmpty()) {
26            ans.append(stack.pop());
27        }
28
29        return ans.reverse().toString();
30    }
31}
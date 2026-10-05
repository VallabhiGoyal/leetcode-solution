// Last updated: 10/5/2026, 12:14:23 PM
1class Solution {
2    public int scoreOfParentheses(String s) {
3        int n = s.length();
4
5        int ans = 0;
6
7        Stack<Integer> stack = new Stack<>();
8
9        int i = 0; 
10        while(i < n){
11            char ch = s.charAt(i);
12
13            if(ch == '('){
14                stack.push(0);
15            }else{
16                if(stack.peek() == 0){
17                    stack.pop();
18                    stack.push(1);
19                }else{
20                    int temp = 0;
21                    while(!stack.isEmpty() && stack.peek() != 0){
22                        temp += stack.pop();
23                    }
24                    stack.pop();
25                    stack.push(temp*2);
26                }
27            }
28
29            i++;
30        }
31
32        while(!stack.isEmpty()){
33            ans += stack.pop();
34        }
35
36        return ans;
37    }
38}
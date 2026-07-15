// Last updated: 7/15/2026, 6:19:28 AM
1class Solution {
2    public boolean isValid(String s) {
3        Stack<Character> stack = new Stack<>();
4
5        for(char ch : s.toCharArray()){
6            if(ch == '(' || ch =='{' || ch=='['){
7                stack.push(ch);
8            }else{
9                if(stack.isEmpty()) return false;
10                char top = stack.pop();
11                if(ch ==')' && top != '(') return false;
12                else if(ch =='}' &&  top != '{') return false;
13                else if(ch ==']' &&  top != '[') return false;
14            }
15        }
16
17        return stack.isEmpty();
18    }
19}
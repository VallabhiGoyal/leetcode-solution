// Last updated: 10/6/2026, 6:41:28 AM
1class Solution {
2    public int minAddToMakeValid(String s) {
3        Stack<Character> stack = new Stack<>();
4
5        int count = 0;
6        for(char ch : s.toCharArray()){
7           if(ch==')'){
8                if(!stack.isEmpty() && stack.peek() == '('){
9                    stack.pop();
10                }else{
11                    count++;
12                }
13           }else{
14            stack.push(ch);
15           } 
16        }
17
18        return count + stack.size();
19    }
20}
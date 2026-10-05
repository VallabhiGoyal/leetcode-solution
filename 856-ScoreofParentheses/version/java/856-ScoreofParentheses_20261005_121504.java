// Last updated: 10/5/2026, 12:15:04 PM
1class Solution {
2    public int scoreOfParentheses(String s) {
3        int count = 0;
4        int score = 0;
5        
6        for(int i =0;i<s.length();i++){
7            if(s.charAt(i)=='('){
8                count++;
9            }else{
10                count--;
11                if(s.charAt(i-1)=='('){
12                    score+= 1<<count;
13                }
14            }
15        }
16        return score;
17    }
18}
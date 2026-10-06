// Last updated: 10/6/2026, 6:42:27 AM
1class Solution {
2    public int minAddToMakeValid(String s) {
3        Stack<Character> stack = new Stack<>();
4
5        int count = 0;
6        int ans = 0;
7        for(char ch : s.toCharArray()){
8           if(ch==')'){
9                if(count > 0){
10                    count--;
11                }else{
12                    ans++;
13                }
14           }else{
15                count++;
16           } 
17        }
18
19        return count + ans;
20    }
21}
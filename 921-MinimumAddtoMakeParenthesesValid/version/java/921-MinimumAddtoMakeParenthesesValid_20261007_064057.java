// Last updated: 10/7/2026, 6:40:57 AM
1class Solution {
2    public int minAddToMakeValid(String s) {
3        int count = 0;
4        int ans = 0;
5        for(char ch : s.toCharArray()){
6           if(ch==')'){
7                if(count > 0){
8                    count--;
9                }else{
10                    ans++;
11                }
12           }else{
13                count++;
14           } 
15        }
16
17        return count + ans;
18    }
19}
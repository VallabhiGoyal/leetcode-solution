// Last updated: 7/26/2026, 7:08:16 AM
1class Solution {
2    public String longestPalindrome(String s) {
3        int n = s.length();
4        if(n <= 1) return s;
5
6        int maxLen = 0;
7        String ans = new String();
8        for(int i = 0; i<n; i++){
9
10            //odd length
11            int left = i;
12            int right = i;
13            while(left>=0 && right<n && s.charAt(left) == s.charAt(right)){
14                left--;
15                right++;
16            }
17            int len = right - left - 1;
18            if(len > maxLen){
19                maxLen = len;
20                ans = s.substring(left+1, right);
21            }
22
23            //even length
24            left = i;
25            right = i + 1;
26            while(left>=0 && right<n && s.charAt(left) == s.charAt(right)){
27                left--;
28                right++;
29            }
30            
31            len = right - left - 1;
32            if(len > maxLen){
33                maxLen = len;
34                ans = s.substring(left+1, right);
35            }
36        }
37
38        return ans;
39    }
40}
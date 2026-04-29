// Last updated: 4/29/2026, 6:28:25 AM
1class Solution {
2    public int longestPalindrome(String s) {
3        int n = s.length();
4
5        int[] freq = new int[128];
6
7        for(int i = 0; i<n; i++){
8            int ch = s.charAt(i) - 'A';
9            freq[ch]++;
10        }
11
12        int len = 0;
13        int odd = 0;
14
15        for(int i = 0; i<128; i++){
16            if(freq[i] % 2 == 0) len += freq[i];
17            else{
18                len += freq[i]-1;
19                odd = 1;
20            }
21        }
22
23        if(odd == 1) return ++len;
24        return len;
25    }
26}
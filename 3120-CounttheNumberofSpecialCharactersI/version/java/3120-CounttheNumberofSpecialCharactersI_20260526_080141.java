// Last updated: 5/26/2026, 8:01:41 AM
1class Solution {
2    public int numberOfSpecialChars(String word) {
3        int n = word.length();
4
5        int count = 0;
6
7        int[] small = new int[26];
8        int[] big = new int[26];
9
10        for(int i = 0; i<n; i++){
11            char ch = word.charAt(i);
12            if(ch >= 'a' && ch <= 'z'){
13                if(small[ch - 'a'] == 1) continue;
14                small[ch - 'a']++;
15                if(small[ch - 'a'] == big[ch - 'a']) count++;
16            }else{
17                if(big[ch - 'A'] == 1) continue; 
18                big[ch - 'A']++;
19                if(small[ch - 'A'] == big[ch - 'A']) count++;
20            }
21        }
22
23        return count;
24    }
25}
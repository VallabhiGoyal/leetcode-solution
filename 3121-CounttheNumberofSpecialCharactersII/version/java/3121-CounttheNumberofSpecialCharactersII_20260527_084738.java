// Last updated: 5/27/2026, 8:47:38 AM
1class Solution {
2    public int numberOfSpecialChars(String word) {
3        int n = word.length();
4
5        int[] lower = new int[26];
6        int[] upper = new int[26];
7
8        Arrays.fill(lower, -1);
9        Arrays.fill(upper, -1);
10        
11        for(int i = 0; i<n; i++){
12            char ch = word.charAt(i);
13            if(ch >= 'a' && ch <= 'z'){
14                lower[ch - 'a'] = i;
15            }else{
16                if(upper[ch - 'A'] == -1){
17                    upper[ch - 'A'] = i;
18                }
19            }
20        }
21
22        int count = 0;
23
24        for(int i = 0; i<26; i++){
25            if(lower[i] != -1 && upper[i] != -1 && lower[i] < upper[i]){
26                count++;
27            }
28        }
29
30        return count;
31    }
32}
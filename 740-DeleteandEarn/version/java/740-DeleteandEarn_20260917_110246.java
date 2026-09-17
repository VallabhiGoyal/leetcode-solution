// Last updated: 9/17/2026, 11:02:46 AM
1class Solution {
2
3    public int numTilePossibilities(String tiles) {
4        int[] freq = new int[26];
5
6        for (char ch : tiles.toCharArray()) {
7            freq[ch - 'A']++;
8        }
9
10        return backtrack(freq);
11    }
12
13    private int backtrack(int[] freq) {
14        int count = 0;
15
16        for (int i = 0; i < 26; i++) {
17
18            if (freq[i] == 0)
19                continue;
20        
21            freq[i]--;
22            count++;
23            count += backtrack(freq);
24            
25            freq[i]++;
26        }
27
28        return count;
29    }
30}
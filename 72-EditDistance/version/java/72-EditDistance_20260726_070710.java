// Last updated: 7/26/2026, 7:07:10 AM
1class Solution {
2    public int minDistance(String word1, String word2) {
3        int m = word1.length();
4        int n = word2.length();
5
6        if(m == 0) return n;
7        if(n == 0) return m;
8
9        int[] t = new int[n+1];
10
11        for(int j = 0; j<n+1; j++){
12            t[j] = j;
13        }
14        
15        for(int i = 1; i<m+1; i++){
16            int prevDia = t[0];  
17            t[0] = i;
18            for(int j = 1; j<n+1; j++){
19                int temp = t[j];
20                if(word1.charAt(i-1) != word2.charAt(j-1)){
21                    int best = Math.min(t[j], t[j-1]);
22                    best = Math.min(best, prevDia);
23                    t[j] = 1 + best;
24                }else{
25                    t[j] = prevDia;
26                }
27                prevDia = temp;
28            }
29        }
30
31        return t[n];
32    }
33}
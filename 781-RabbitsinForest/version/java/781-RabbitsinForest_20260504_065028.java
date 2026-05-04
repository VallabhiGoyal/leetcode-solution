// Last updated: 5/4/2026, 6:50:28 AM
1class Solution {
2    public int numRabbits(int[] answers) {
3        int n = answers.length;
4
5        int[] freq = new int[1001];
6
7        for(int i = 0; i<n; i++){
8            freq[answers[i]]++;  
9        }
10
11        int count = 0;
12        for(int i = 0; i<1001; i++){
13            if(freq[i] == 0) continue;
14            int size = i+1;
15            int groups = (freq[i] + i)/(i+1);
16            count += size*groups;
17        }
18
19        return count;
20    }
21}
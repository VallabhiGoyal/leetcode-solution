// Last updated: 5/20/2026, 5:51:26 AM
1class Solution {
2    public int[] findThePrefixCommonArray(int[] A, int[] B) {
3        int n = A.length;
4
5        int[] freq = new int[n+1];
6
7        int[] C = new int[n];
8        if(A[0] == B[0]) C[0] = 1;
9        else{
10            freq[A[0]]++;
11            freq[B[0]]++;
12        }
13
14        for(int i = 1; i<n; i++){
15            C[i] = C[i-1];
16            if(A[i] == B[i]) C[i]++;
17            else{
18                freq[A[i]]++;
19                freq[B[i]]++;
20
21                if(freq[A[i]] == 2) C[i]++;
22                if(freq[B[i]] == 2) C[i]++;
23            }
24        }
25
26        return C;
27    }
28}
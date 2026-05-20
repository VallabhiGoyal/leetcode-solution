// Last updated: 5/20/2026, 5:49:36 AM
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
15            if(A[i] == B[i]) C[i] = C[i-1] + 1;
16            else{
17                C[i] = C[i-1];
18
19                freq[A[i]]++;
20                freq[B[i]]++;
21
22                if(freq[A[i]] == 2) C[i]++;
23                if(freq[B[i]] == 2) C[i]++;
24            }
25        }
26
27        return C;
28    }
29}
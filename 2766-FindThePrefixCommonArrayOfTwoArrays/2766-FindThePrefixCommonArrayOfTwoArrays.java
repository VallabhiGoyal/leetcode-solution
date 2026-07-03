// Last updated: 7/3/2026, 11:36:57 AM
class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;

        int[] freq = new int[n+1];

        int[] C = new int[n];
        if(A[0] == B[0]) C[0] = 1;
        else{
            freq[A[0]]++;
            freq[B[0]]++;
        }

        for(int i = 1; i<n; i++){
            C[i] = C[i-1];
            if(A[i] == B[i]) C[i]++;
            else{
                freq[A[i]]++;
                freq[B[i]]++;

                if(freq[A[i]] == 2) C[i]++;
                if(freq[B[i]] == 2) C[i]++;
            }
        }

        return C;
    }
}
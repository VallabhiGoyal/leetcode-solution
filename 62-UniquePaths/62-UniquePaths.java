// Last updated: 4/24/2026, 10:36:35 AM
class Solution {
    public int uniquePaths(int m, int n) {
        int[] t = new int[n];

        for(int i = 0; i<n; i++){
            t[i] = 1;
        }

        for(int i = 1; i<m; i++){
            for(int j = 1; j<n; j++){
                t[j] += t[j-1];
            }
        }

        return t[n-1];
    }
}
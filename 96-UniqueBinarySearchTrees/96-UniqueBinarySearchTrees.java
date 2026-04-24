// Last updated: 4/24/2026, 10:36:09 AM
class Solution {
    public int numTrees(int n) {
        if(n == 1) return 1;

        long[] ans = new long[n+1];
        ans[0] = 1;
        ans[1] = 1;
        for(int i = 2; i<n+1; i++){
            for(int j = i; j>0; j--){
                ans[i] += ans[j-1]*ans[i-j];
            }
        }

        return (int)ans[n];
    }
}
// Last updated: 4/24/2026, 10:32:13 AM
class Solution {
    public int tribonacci(int n) {
        if(n<=1) return n;
        if(n == 2) return 1;
        int t0 = 0;
        int t1 = 1;
        int t2 = 1;

        for(int i = 3; i<=n; i++){
            int curr = t0 + t1 + t2;
            t0 = t1;
            t1 = t2;
            t2 = curr;
        }

        return t2;
    }
}
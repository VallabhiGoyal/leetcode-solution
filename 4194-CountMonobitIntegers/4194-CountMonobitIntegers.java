// Last updated: 4/24/2026, 10:29:48 AM
class Solution {
    public int countMonobit(int n) {
        if(n == 0) return 1;

        int k = 1;
        while(Math.pow(2,k) - 1 <= n){
            k++;
        }

        return k;
    }
}
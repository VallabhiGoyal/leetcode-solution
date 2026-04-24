// Last updated: 4/24/2026, 10:34:53 AM
class Solution {
    public boolean isPowerOfTwo(int n) {
        if(n<=0) return false;

        return (n & (n-1)) == 0;
    }
}
// Last updated: 4/24/2026, 10:34:28 AM
class Solution {
    public boolean isPowerOfThree(int n) {
        if(n <= 0) return false;
        while(n%3 == 0){
            n /= 3;
        }
        return n == 1;
    }
}
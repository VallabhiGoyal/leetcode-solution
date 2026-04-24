// Last updated: 4/24/2026, 10:34:23 AM
class Solution {
    public boolean isPowerOfFour(int n) {
        if(n <= 0) return false;
        while(n%4==0){
            n/=4;
        }
        return n==1;
    }
}
// Last updated: 4/24/2026, 10:29:55 AM
class Solution {
    public int mirrorDistance(int n) {
        return Math.abs(n - reverse(n));
    }

    public int reverse(int n){
        int rev = 0;

        while(n>0){
            int digit = n%10;
            rev = rev*10 + digit;
            n /= 10;
        }

        return rev;
    }
}
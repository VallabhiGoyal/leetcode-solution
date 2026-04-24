// Last updated: 4/24/2026, 10:30:09 AM
class Solution {
    public int largestPrime(int n) {
        int sum = 0;
        int ans = 0; 

        for (int i = 2; i <= n; i++) {
            if (isPrime(i)) {
                sum += i;

                if (sum > n) break; 

                if (isPrime(sum)) {
                    ans = sum;
                }
            }
        }

        return ans;
    }

    boolean isPrime(int n) {
    if (n <= 1) return false;          
    if (n == 2 || n == 3) return true; 
    if (n % 2 == 0) return false;
    for (int i = 3; i * i <= n; i += 2) {
        if (n % i == 0) return false;
    }

    return true;
}
}
// Last updated: 7/3/2026, 11:34:50 AM
class Solution {
    public int sumOfPrimesInRange(int n) {
        int rev = reverse(n);

        int start = Math.min(n, rev);
        int end = Math.max(n, rev);

        int ans = 0;
        for(int i = start; i<=end; i++){
            if(isPrime(i)) ans += i;
        }

        return ans;
    }

    private boolean isPrime(int n){
        if(n <= 1) return false;
        if(n == 2) return true;
        if(n % 2 == 0) return false;

        for(int i = 3; i*i<=n; i+=2){
            if(n % i == 0) return false;
        }

        return true;
    }

    private int reverse(int n){
        int ans = 0;

        while(n > 0){
            int remain = n % 10;
            ans = ans * 10 + remain;
            n /= 10;
        }

        return ans;
    }
}
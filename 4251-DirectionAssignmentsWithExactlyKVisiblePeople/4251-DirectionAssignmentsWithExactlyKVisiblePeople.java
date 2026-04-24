// Last updated: 4/24/2026, 10:29:31 AM
class Solution {
    static final int MOD = 1000000007;
    public static long[] fact;
    
    public int countVisiblePeople(int n, int pos, int k) {
        int left = pos;
        int right = n - pos - 1;

        factorial(n);
        long ans = 0;

        for(int i = 0; i <= k; i++){
            int j = k - i;

            if(i <= left && j <= right){
                ans = (ans + (nCr(left, i) * nCr(right, j)) % MOD) % MOD;
            }
        }

        return (int)((ans * 2) % MOD);
    }

    public void factorial(int n){
        fact = new long[n+1];
        fact[0] = 1;

        for(int i = 1; i <= n; i++){
            fact[i] = (fact[i-1] * i) % MOD;
        }
    }

    public long nCr(int n, int r){
        if(r > n || r < 0) return 0;
        return (fact[n] * inv(fact[n-r]) % MOD * inv(fact[r]) % MOD) % MOD;
    }

    public long inv(long x){
        return power(x, MOD - 2);
    }

    public long power(long x, int y){
        long res = 1;
        x %= MOD;

        while(y > 0){
            if((y & 1) == 1) res = (res * x) % MOD;
            x = (x * x) % MOD;
            y >>= 1;
        }
        return res;
    }
}
// Last updated: 5/3/2026, 11:06:46 AM
1class Solution {
2    public int sumOfPrimesInRange(int n) {
3        int rev = reverse(n);
4
5        int start = Math.min(n, rev);
6        int end = Math.max(n, rev);
7
8        int ans = 0;
9        for(int i = start; i<=end; i++){
10            if(isPrime(i)) ans += i;
11        }
12
13        return ans;
14    }
15
16    private boolean isPrime(int n){
17        if(n <= 1) return false;
18        if(n == 2) return true;
19        if(n % 2 == 0) return false;
20
21        for(int i = 3; i*i<=n; i+=2){
22            if(n % i == 0) return false;
23        }
24
25        return true;
26    }
27
28    private int reverse(int n){
29        int ans = 0;
30
31        while(n > 0){
32            int remain = n % 10;
33            ans = ans * 10 + remain;
34            n /= 10;
35        }
36
37        return ans;
38    }
39}
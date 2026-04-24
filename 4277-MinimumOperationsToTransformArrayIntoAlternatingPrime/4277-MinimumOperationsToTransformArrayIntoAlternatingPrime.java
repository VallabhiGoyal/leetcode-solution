// Last updated: 4/24/2026, 10:29:14 AM
class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;

        int op = 0;
        for(int i = 0; i<n; i++){
            int curr = nums[i];
            if(i%2 == 0){
                while(!isPrime(curr)){
                    curr++;
                    op++;
                }
            }else{
                while(isPrime(curr)){
                    curr++;
                    op++;
                }
            }
        }

        return op;
        
    }

    public boolean isPrime(int n) {
        if (n <= 1) return false;
        if (n == 2) return true;

        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}
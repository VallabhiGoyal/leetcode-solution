// Last updated: 4/24/2026, 10:30:53 AM
class Solution {
    public int diagonalPrime(int[][] nums) {
        int n = nums.length;
        int max = 0;
        for(int i = 0; i<n; i++){
            for(int j = 0; j<n; j++){
                if(i == j && isPrime(nums[i][j])){
                    max = Math.max(max, nums[i][j]);
                }

                if(i+j == n-1 && isPrime(nums[i][j])){
                    max = Math.max(max, nums[i][j]);
                }
            }
        }

        return max;
    }

    private boolean isPrime(int n){
        if(n == 1) return false;
        if(n == 2 || n == 3) return true;
        if(n%2==0) return false;
        for(int i = 3; i*i<=n; i = i + 2){
            if(n%i == 0) return false;
        }
        return true;
    }
}
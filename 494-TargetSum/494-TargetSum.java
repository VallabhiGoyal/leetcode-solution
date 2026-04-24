// Last updated: 4/24/2026, 10:33:49 AM
class Solution {
    public static int[][] t;
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;

        int totalSum = 0;
        for(int i = 0; i<n; i++){
            totalSum += nums[i];
        }

        if(Math.abs(target) > totalSum || (target + totalSum)%2!=0) return 0;
        int diff = (totalSum + target)/2;

        return helper(nums, diff);
    }

    public int helper(int[] arr, int sum){
        int n = arr.length;

        t = new int[n+1][sum + 1];

        for(int j = 0; j<sum+1; j++){
            t[0][j] = 0;
        }

        for(int i = 0; i<n+1; i++){
            t[i][0] = 1;
        }

        for(int i = 1; i<n+1; i++){
            for(int j = 0; j<sum+1; j++){
                if(arr[i-1] == 0){
                    t[i][j] = 2 * t[i-1][j];
                }else if(arr[i-1] <= j){
                    t[i][j] = t[i-1][j - arr[i-1]] + t[i-1][j];
                }else{
                    t[i][j] = t[i-1][j];
                }
            }
        }

        return t[n][sum];
    }
}
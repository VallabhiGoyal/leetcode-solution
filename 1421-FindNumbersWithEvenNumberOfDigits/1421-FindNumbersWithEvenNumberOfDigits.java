// Last updated: 4/24/2026, 10:32:00 AM
class Solution {
    public int findNumbers(int[] nums) {
        int n = nums.length;

        int count = 0;
        for(int i = 0; i<n; i++){
            int di = digits(nums[i]);
            if(di % 2 == 0) count++;
        }

        return count;
    }

    public int digits(int n){
        if(n==0) return 1;
        int count = 0;
        while(n>0){
            n /= 10;
            count++;
        }
        return count;
    }
}
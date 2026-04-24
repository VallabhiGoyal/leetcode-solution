// Last updated: 4/24/2026, 10:31:54 AM
class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int n = nums.length;
        if(n==0) return new int[0];

        int MAX = 100;
        int[] freq = new int[MAX+1];

        for(int v : nums) freq[v]++;

        for(int i = 1; i<MAX; i++){
            freq[i] += freq[i-1];
        }

        int[] res = new int[n];
        for(int i = 0; i<n; i++){
            int v = nums[i];
            res[i] = (v==0)?0:freq[v-1];
        }

        return res;
    }
}
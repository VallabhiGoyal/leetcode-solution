// Last updated: 4/24/2026, 10:33:09 AM
class Solution {
    public int deleteAndEarn(int[] nums) {
        int n = nums.length;

        int max = nums[0];
        for(int i = 0; i<n; i++){
            max = Math.max(nums[i], max);
        }
        
        int m = max;
        int[] points = new int[m+1];
        for(int i = 0; i<n; i++){
            points[nums[i]] += nums[i];
        }

        int t1 = points[0];
        int t2 = Math.max(points[0], points[1]);

        for(int i = 2; i<m+1; i++){
            int curr = Math.max(points[i] + t1, t2);
            t1 = t2;
            t2 = curr;
        }

        return t2;
    }
}
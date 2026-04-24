// Last updated: 4/24/2026, 10:30:00 AM
class Solution {
    public long minIncrease(int[] nums) {
        int n = nums.length;

        int[] cost = new int[n];
        for (int i = 1; i < n - 1; i++) {
            cost[i] = Math.max(0, Math.max(nums[i - 1], nums[i + 1]) - nums[i] + 1);
        }

        //n is odd
        if (n % 2 == 1) {
            long ans = 0;
            for (int i = 1; i < n - 1; i += 2) {
                ans += cost[i];
            }
            return ans;
        }

        //odd left
        long[] left = new long[n];
        for (int i = 1; i < n - 1; i++) {
            if (i % 2 == 1) {
                left[i] = cost[i];
                if (i - 2 >= 1) left[i] += left[i - 2];
            } else {
                left[i] = left[i - 1];
            }
        }

        //even right
        long[] right = new long[n];
        for (int i = n - 2; i >= 1; i--) {
            if (i % 2 == 0) {
                right[i] = cost[i];
                if (i + 2 <= n - 2) right[i] += right[i + 2];
            } else {
                right[i] = right[i + 1];
            }
        }

        long ans = Long.MAX_VALUE;

        for (int i = 1; i < n - 1; i++) {
            long leftCost = (i - 1 >= 1) ? left[i - 1] : 0;
            long rightCost = (i + 1 <= n - 2) ? right[i + 1] : 0;
            ans = Math.min(ans, leftCost + rightCost);
        }

        return ans;
    }
}
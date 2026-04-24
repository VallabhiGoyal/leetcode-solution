// Last updated: 4/24/2026, 10:30:07 AM
class Solution {
    public int minimumDistance(int[] nums) {
        int n = nums.length;
        int min_sum = Integer.MAX_VALUE;
        boolean[] seen = new boolean[n + 1]; // nums[i] in [1..n]

        for (int i = 0; i < n; i++) {
            int val = nums[i];
            if (seen[val]) continue;          // already processed this value
            seen[val] = true;

            // collect all indices where this value appears
            List<Integer> indices = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                if (nums[j] == val) indices.add(j);
            }

            if (indices.size() < 3) continue;

            // slide window of size 3 over indices
            for (int p = 0; p + 2 < indices.size(); p++) {
                int a = indices.get(p);
                int c = indices.get(p + 2);
                int dist = 2 * (c - a); // |a-b|+|b-c|+|c-a| = 2*(c-a)
                if (dist < min_sum) min_sum = dist;
            }
        }

        return (min_sum == Integer.MAX_VALUE) ? -1 : min_sum;
    }
}

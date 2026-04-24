// Last updated: 4/24/2026, 10:30:31 AM
class Solution {
    public int[] minBitwiseArray(List<Integer> nums) {
        int n = nums.size();
        int[] ans = new int[n];

        for(int i = 0; i<n; i++){
            int x = nums.get(i);

            if(x == 2){
                ans[i] = -1;
                continue;
            }

            int y = x;
            int bit = 0;

            while((y & 1) == 1){
                y >>= 1;
                bit++;
            }

            ans[i] = (y << bit) | ((1 << (bit - 1)) - 1);
        }

        return ans;
    }
}
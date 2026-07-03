// Last updated: 7/3/2026, 11:34:56 AM
class Solution {
    public int[] minCost(int[] nums, int[][] queries) {
        int m = nums.length;
        
        //closest
        int[] closest = new int[m];
        for(int i = 0; i<m; i++){
            if(i == 0) closest[i] = 1;
            else if(i == m-1) closest[i] = m-2;
            else{
                int left = Math.abs(nums[i-1] - nums[i]);
                int right = Math.abs(nums[i] - nums[i+1]);

                if(left <= right) closest[i] = i-1;
                else closest[i] = i + 1;
            }
        }

        //forward path sum
        long[] forward = new long[m];
        for(int i = 0; i<m-1; i++){
            if(closest[i] == i + 1){
                forward[i+1] = forward[i] + 1;
            }else{
                forward[i+1] = forward[i] + nums[i+1] - nums[i];
            }
        }

        //backward path sum
        long[] back = new long[m];
        for(int i = m-1; i>0; i--){
            if(closest[i] == i-1){
                back[i-1] = back[i] + 1;
            }else{
                back[i-1] = back[i] + nums[i] - nums[i-1];
            }
        }

        //ans 
        int n = queries.length;
        int[] ans = new int[n];
        
        for(int i = 0; i<n; i++){
            int x = queries[i][0];
            int y = queries[i][1];

            if(x < y){
                ans[i] = (int)(forward[y] - forward[x]);
            }else{
                ans[i] = (int)(back[y] - back[x]);
            }
        }

        return ans;
    }
}
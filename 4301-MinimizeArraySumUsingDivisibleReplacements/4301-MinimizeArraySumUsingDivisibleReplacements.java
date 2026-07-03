// Last updated: 7/3/2026, 11:34:48 AM
class Solution {
    public long minArraySum(int[] nums) {
        int n = nums.length;

        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i<n; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        long sum = 0;
        for(int i = 0; i<n; i++){
            int curr = nums[i];

            for(int j = 1; j*j <= curr; j++){
                if(curr % j == 0){
                    if(map.containsKey(j)){
                        nums[i] = Math.min(nums[i], j);
                    }

                    int temp = curr/j;
                    if(map.containsKey(temp)){
                        nums[i] = Math.min(nums[i], temp);
                    }
                }
            }

            sum += nums[i];
        }

        return sum;
    }
}
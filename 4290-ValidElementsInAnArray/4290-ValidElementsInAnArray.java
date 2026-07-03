// Last updated: 7/3/2026, 11:34:57 AM
class Solution {
    public List<Integer> findValidElements(int[] nums) {
        int n = nums.length;

        int[] prefix = new int[n];
        prefix[0] = nums[0];
        for(int i = 1; i<n; i++){
            prefix[i] = Math.max(prefix[i-1], nums[i]);
        }

        int[] suffix = new int[n];
        suffix[n-1] = nums[n-1];
        for(int i = n-2; i>=0; i--){
            suffix[i] = Math.max(suffix[i+1], nums[i]);
        }

        List<Integer> list = new ArrayList<>();
        for(int i = 0; i<n; i++){
            if(i == 0 || i == n-1){
                list.add(nums[i]);
            }else if(prefix[i-1] < nums[i] || suffix[i+1] < nums[i]) list.add(nums[i]);
        }

        return list;
    }
}
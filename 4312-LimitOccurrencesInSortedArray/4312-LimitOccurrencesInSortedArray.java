// Last updated: 7/3/2026, 11:34:45 AM
class Solution {
    public int[] limitOccurrences(int[] nums, int k) {
        int n = nums.length;

        List<Integer> list = new ArrayList<>();

        for(int i = 0; i<n; i++){
            int count = 0;
            int j = i;
            while(j<n && nums[i] == nums[j]){

                if(count < k){
                    list.add(nums[i]);
                    count++;
                }
                j++;
            }

            i = j-1;
        }

        int size = list.size();
        int[] ans = new int[size];

        for(int i = 0; i<size; i++){
            ans[i] = list.get(i);
        }

        return ans;
    }
}
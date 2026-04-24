// Last updated: 4/24/2026, 10:30:02 AM
class Solution {
    public int countElements(int[] nums, int k) {
        if(k==0) return nums.length;
        Arrays.sort(nums);
        int count_num = 0;
        int i = 0;
        while(i<nums.length){
            int val = nums[i];
            int j = i;
            while(j<nums.length && nums[j] == val) j++;
            int greater = nums.length-j;
            if(greater>=k){
                count_num += (j-i);
            }
            i=j;
        }
        return count_num;
    }
}
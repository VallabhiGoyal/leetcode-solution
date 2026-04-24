// Last updated: 4/24/2026, 10:30:49 AM
class Solution {
    public int[] getSubarrayBeauty(int[] nums, int k, int x) {
        int n = nums.length;
        int size = n-k+1;

        int[] arr = new int[size];
        int[] freq = new int[51];

        int idx = 0;
        for(int i = 0; i<n; i++){
            if(nums[i] < 0){
                freq[Math.abs(nums[i])]++;
            }

            if (i >= k && nums[i - k] < 0) {
                freq[-nums[i - k]]--;
            }

            if(i>=k-1){
                int count = 0;
                int beauty = 0;
                for(int j = 50; j>=1; j--){
                    count += freq[j];
                    if(count>=x){
                        beauty = -j;
                        break;
                    }
                }
                arr[idx++] = beauty;
            }
        }
        return arr;
    }

}
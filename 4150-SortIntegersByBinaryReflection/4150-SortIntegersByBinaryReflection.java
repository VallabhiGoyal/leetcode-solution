// Last updated: 4/24/2026, 10:29:59 AM
class Solution {
    public int[] sortByReflection(int[] nums) {

        int n = nums.length;
        int[][] arr = new int[n][2];
        for(int i = 0; i<n; i++){
            arr[i][0] = nums[i];
            arr[i][1] = reverseBinary(nums[i]);
        }
        Arrays.sort(arr, (a, b) -> {
            if (a[1] != b[1]) {
                return Integer.compare(a[1], b[1]);
            }
            return Integer.compare(a[0], b[0]);
        });

        for(int i = 0; i<n; i++){
            nums[i] = arr[i][0];
        }
        return nums;
    }

    public int reverseBinary(int num){
        int res = 0;
        while (num > 0) {
            res = (res << 1) | (num & 1); 
            num >>= 1;                    
        }
        return res;
    }
}
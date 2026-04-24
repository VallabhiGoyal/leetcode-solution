// Last updated: 4/24/2026, 10:33:40 AM
class Solution {
    public int singleNonDuplicate(int[] arr) {
        int n = arr.length;
        
        int ans = 0;
        for(int i = 0; i<n; i++){
            ans = ans ^ arr[i];
        }

        return ans;
    }
}
// Last updated: 7/30/2026, 12:22:01 PM
1class Solution {
2    public int[] searchRange(int[] nums, int target) {
3        int n = nums.length;
4
5        int[] ans = {-1, -1};
6        ans[0] = helper(nums, 0, n-1, target, true, -1);
7        ans[1] = helper(nums, 0, n-1, target, false, -1);
8
9        return ans;
10    }
11
12    public int helper(int[] nums, int low, int high, int target, boolean firstSearch, int ans){
13        if(low > high) return ans;
14
15        int mid = low + (high - low)/2;
16
17        if(nums[mid] == target){
18            ans = mid;
19            if(firstSearch){
20                return helper(nums, low, mid - 1, target, firstSearch, ans);
21            }else{
22                return helper(nums, mid + 1, high, target, firstSearch, ans);
23            }
24        }else if(nums[mid] > target){
25            return helper(nums, low, mid - 1, target, firstSearch, ans);
26        }else{
27            return helper(nums, mid + 1, high, target, firstSearch, ans);
28        }
29    }
30}
// Last updated: 7/27/2026, 5:43:06 AM
1
2
3
4class Solution {
5    public int[] searchRange(int[] nums, int target) {
6        int[] ans = {-1,-1};
7        int start = search(nums, target, true);
8        int end = search(nums, target, false);
9
10        ans[0] = start;
11        ans[1] = end;
12        
13        return ans;
14    }
15    public int search(int[] nums, int target, boolean firstSearch){
16        int ans = -1;
17        int start = 0;
18        int end = nums.length - 1;
19        
20        while(start<=end){
21            int mid = start + (end-start)/2;
22            if(target<nums[mid]){
23                end = mid - 1;    
24            }else if(target > nums[mid]){
25                start = mid + 1;
26            }else{
27                ans = mid;
28                if(firstSearch == true){
29                    end = mid -1;
30                }else{
31                    start = mid +1;
32                }
33            }
34        }
35        return ans;
36    }
37}
// Last updated: 5/13/2026, 5:49:33 AM
1class Solution {
2    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
3        int m = nums1.length;
4        int n = nums2.length;
5
6        int[] ans = new int[m];
7        for(int i = 0; i<m; i++){
8            ans[i] = -1;
9        }
10
11        for(int i = 0; i<m; i++){
12            int j = 0; 
13            while(j<n){
14                if(nums1[i] == nums2[j]){
15                    for(int k = j+1; k<n; k++){
16                        if(nums2[k] > nums1[i]){
17                            ans[i] = nums2[k];
18                            break;
19                        }
20                    }
21                    break;
22                }
23                j++;
24            }
25        }
26
27        return ans;
28    }
29}
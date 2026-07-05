// Last updated: 7/5/2026, 9:15:22 AM
1class Solution {
2    public void nextPermutation(int[] nums) {
3        int n = nums.length;
4
5        int idx = -1;
6
7        for(int i = n-2; i>=0; i--){
8            if(nums[i] < nums[i+1]){
9                idx = i;
10                break;
11            }
12        }
13
14        if(idx == -1){
15            reverse(nums, 0, n-1);
16            return;
17        }
18
19        for(int i = n-1; i > idx; i--){
20            if(nums[i] > nums[idx]){
21                swap(nums, i, idx);
22                break;
23            }
24        }
25
26        reverse(nums, idx+1, n-1);
27    }
28
29    public static void reverse(int[] arr, int start, int end) {
30        while (start < end) {
31            swap(arr, start, end);
32            start++;
33            end--;
34        }
35    }
36
37    public static void swap(int[] arr, int i, int j){
38        int temp = arr[i];
39        arr[i] = arr[j];
40        arr[j] = temp;
41    }
42}
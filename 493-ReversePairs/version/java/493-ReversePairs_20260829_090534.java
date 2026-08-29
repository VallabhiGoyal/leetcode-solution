// Last updated: 8/29/2026, 9:05:34 AM
1class Solution {
2    int count = 0;
3    public int reversePairs(int[] nums) {
4        int n = nums.length;
5
6        divide(nums, 0, n-1);
7
8        return count;
9    }
10
11    public void conquer(int[] nums, int low, int mid, int high){
12        int[] merged = new int[high - low + 1];
13
14        int i = low;
15        int j = mid+1;
16        int x = 0;
17
18        while(i <= mid){
19            while(j <= high && nums[i] > 2L * nums[j]){
20                j++;
21            }
22
23            count += j - (mid+1);
24            i++;
25        }
26
27        i = low;
28        j = mid + 1;
29
30        while (i <= mid && j <= high) {
31            if (nums[i] <= nums[j]) {
32                merged[x++] = nums[i++];
33            } else {
34                merged[x++] = nums[j++];
35            }
36        }
37
38        while(i <= mid){
39            merged[x++] = nums[i++];
40        }
41
42        while(j <= high){
43            merged[x++] = nums[j++];
44        }
45
46        for(i = 0, j = low; i<merged.length; i++, j++){
47            nums[j] = merged[i];
48        }
49    }
50
51    public void divide(int[] nums, int low, int high){
52        if(low >= high) return;
53
54        int mid = low + (high - low)/2;
55
56        divide(nums, low, mid);
57        divide(nums, mid+1, high);
58        conquer(nums, low, mid, high);
59    }
60}
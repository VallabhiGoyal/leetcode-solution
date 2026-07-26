// Last updated: 7/26/2026, 7:00:09 AM
1class Solution {
2    public int maximumProduct(int[] arr) {
3        int n = arr.length;
4
5        int min1 = Integer.MAX_VALUE;
6        int min2 = Integer.MAX_VALUE;
7
8        int max =  Integer.MIN_VALUE;
9        int max1 = Integer.MIN_VALUE;
10        int max2 = Integer.MIN_VALUE;
11
12        for(int i = 0; i<n; i++){
13
14            if(min1>arr[i]){
15                min2 = min1;
16                min1= arr[i];
17            }else if(min2>arr[i]) min2 = arr[i];
18
19            if(max<arr[i]){
20                max2 = max1;
21                max1 = max;
22                max = arr[i];
23            }else if(max1<arr[i]){
24                max2 = max1;
25                max1 = arr[i];
26            }else if(max2<arr[i]){
27                max2 = arr[i];
28            }
29        }
30
31        return Math.max(min1*min2*max, max*max1*max2);
32
33    }
34}
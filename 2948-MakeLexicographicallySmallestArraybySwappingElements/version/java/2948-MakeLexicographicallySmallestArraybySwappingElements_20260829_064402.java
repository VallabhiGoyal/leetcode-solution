// Last updated: 8/29/2026, 6:44:02 AM
1class Solution {
2    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
3        int n = nums.length;
4
5        int[][] arr = new int[n][2];
6        for(int i = 0; i<n; i++){
7            arr[i][0] = nums[i];
8            arr[i][1] = i;
9        }
10
11        Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));
12
13        int i = 0;
14
15        while(i < n){
16            int j = i;
17
18            while(j + 1 < n && arr[j+1][0] - arr[j][0] <= limit){
19                j++;
20            }
21
22            List<Integer> list = new ArrayList<>();
23
24            for(int k = i; k <= j; k++){
25                list.add(arr[k][1]);
26            }
27
28            Collections.sort(list);
29
30            int size = list.size();
31
32            for(int k = 0; k<size; k++){
33                nums[list.get(k)] = arr[i+k][0];
34            }
35
36            i = j + 1;
37        }
38
39        return nums;
40    }
41}
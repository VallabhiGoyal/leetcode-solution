// Last updated: 11/5/2026, 3:22:49 PM
1class Solution {
2    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
3        int m = arr1.length;
4        int n = arr2.length;
5
6        int ans = 0;
7
8        for(int i = 0; i<m; i++){
9            boolean flag = true;
10            for(int j = 0; j<n; j++){
11                if(Math.abs(arr1[i] - arr2[j]) <= d){
12                    flag = false;
13                    break;
14                }
15            }
16            if(flag) ans++;
17        } 
18
19        return ans;
20    }
21}
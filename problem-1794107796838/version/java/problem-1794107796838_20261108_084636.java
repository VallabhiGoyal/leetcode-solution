// Last updated: 11/8/2026, 8:46:36 AM
1class Solution {
2    public int countSuffix(int[] nums, int[] target) {
3        int n = nums.length;
4
5        int l = n;
6        for(int i = 0; i<n; i++){
7            if(nums[i] != target[i]){
8                l = i;
9                break;
10            }
11        }
12
13        int temp = -1;
14        for(int i = 0; i<n-1; i++){
15            if(target[i] < target[i+1]){
16                temp = i;
17            }
18        }
19        int left = temp + 1;
20        int right = Math.min(l, n-1);
21
22        Map<Integer, Integer> map = new HashMap<>();
23        int nonZero = 0;
24
25        boolean[] valid = new boolean[n+1];
26        valid[n] = true;
27        
28        for(int i = n-1; i>=0; i--){
29            
30            int x = map.getOrDefault(nums[i], 0) + 1;
31            if(x == 1) nonZero++;
32            else if(x == 0) nonZero--;
33            map.put(nums[i], x);
34
35            int y = map.getOrDefault(target[i], 0) - 1;
36            if(y == -1) nonZero++;
37            else if(y == 0) nonZero--;
38            map.put(target[i], y);
39
40            valid[i] = (nonZero == 0);
41        }
42
43        int ans = 0;
44        for(int i = left; i <= right; i++){
45            if(valid[i]) ans++;
46        }
47
48        return ans;
49    }
50}
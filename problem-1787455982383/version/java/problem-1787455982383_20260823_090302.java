// Last updated: 8/23/2026, 9:03:02 AM
1class Solution {
2    public int longestSubarray(int[] nums, int k) {
3        int n = nums.length;
4
5        Map<Integer, Integer> map = new HashMap<>();
6
7        int len = 0;
8        
9        int j = 0;
10        for(int i = 0; i<n; i++){
11            addPrimeFactors(nums[i], map);
12    
13            while(map.size() > k){
14                removePrimeFactors(nums[j], map);
15                j++;
16            }
17
18            len = Math.max(len, i-j+1);
19        }
20
21        return len;
22    }
23
24    public void removePrimeFactors(int n, Map<Integer, Integer> map){
25        if(n%2 == 0){
26            map.merge(2, -1, Integer::sum);
27            while(n%2 == 0){
28                n/=2;
29            }
30            if(map.get(2) == 0) map.remove(2);
31        }
32
33        for(int i = 3; i*i<=n; i+=2){
34            if(n%i == 0){
35                map.merge(i, -1, Integer::sum);
36                while(n%i == 0){
37                    n/=i;
38                }
39
40                if(map.get(i) == 0) map.remove(i);
41            }
42        }
43
44        if(n > 1){
45            map.merge(n, -1, Integer::sum);
46            if(map.get(n) == 0) map.remove(n);
47        }
48    }
49
50    public void addPrimeFactors(int n, Map<Integer, Integer> map){
51        if(n%2 == 0){
52            map.merge(2, 1, Integer::sum);
53            while(n%2 == 0){
54                n/=2;
55            }
56        }
57        
58        for(int i = 3; i*i <= n; i+=2){
59            if(n%i == 0){
60                map.merge(i, 1, Integer::sum);
61                while(n%i == 0){
62                    n/=i;
63                }
64            }
65        }
66
67        if(n > 1){
68            map.merge(n, 1, Integer::sum);
69        }
70    }
71}
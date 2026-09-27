// Last updated: 9/27/2026, 8:28:42 AM
1class Solution {
2    public int maxEqualAdjacentPairs(int[] nums) {
3        int n = nums.length;
4
5        Map<List<Integer>, Integer> map1 = new HashMap<>();
6        Map<Integer, Integer> map2 = new HashMap<>();
7        int base = 0;
8        
9        for(int i = 1; i < n; i++){
10            if(nums[i] != nums[i-1]){
11                List<Integer> temp1 = Arrays.asList(nums[i], nums[i-1]);
12                List<Integer> temp2 = Arrays.asList(nums[i-1], nums[i]);
13                
14                map1.put(temp1, map1.getOrDefault(temp1, 0) + 1);
15                map1.put(temp2, map1.getOrDefault(temp2, 0) + 1);
16            }else{
17                map2.merge(nums[i], 1, Integer::sum);
18                base++;
19            }
20        }
21
22        int max = base;
23        for(List<Integer> key : map1.keySet()){
24            max = Math.max(max, map1.get(key) + base);
25        }
26
27        return max;
28    }
29}
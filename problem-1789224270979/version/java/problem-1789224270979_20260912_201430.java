// Last updated: 9/12/2026, 8:14:30 PM
1class Solution {
2    public int countSpecialIntegers(int[] nums) {
3        int n = nums.length;
4
5        Map<Integer, List<Integer>> map = new HashMap<>();
6        for(int i = 0; i<n; i++){
7            map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
8        }
9
10        int count = 0;
11        for(int key : map.keySet()){
12            if(map.get(key).size() >= 3){
13                int size = map.get(key).size();
14                int temp = map.get(key).get(1) - map.get(key).get(0);
15
16                boolean flag = true;
17                for(int i = 2; i<size; i++){
18                    if(map.get(key).get(i) - map.get(key).get(i-1) != temp){
19                        flag = false;
20                        break;
21                    }
22                }
23
24                if(flag) count++;
25            }
26        }
27
28
29        return count;
30    }
31}
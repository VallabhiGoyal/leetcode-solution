// Last updated: 9/13/2026, 9:04:09 AM
1class Solution {
2    public long shadowPairs(int[] nums) {
3        int n = nums.length;
4
5        long count = 0;
6        List<Integer> stack = new ArrayList<>();
7
8        for(int i = 0; i < n; i++){
9            while(!stack.isEmpty() && stack.get(stack.size()-1) > nums[i]){
10                stack.remove(stack.size()-1);
11            }
12
13            int low = 0;
14            int high = stack.size();
15
16            while(low < high){
17                int mid = low + (high - low)/2;
18
19                if(stack.get(mid) < nums[i]){
20                    low = mid + 1;
21                }else{
22                    high = mid;
23                }
24            }
25
26            count += low;
27            stack.add(nums[i]);
28        }
29
30        return count;
31    }
32}
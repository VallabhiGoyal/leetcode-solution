// Last updated: 8/23/2026, 8:29:56 AM
1class Solution {
2    public List<List<Integer>> findDisappearedNumbers(int[] nums, int lower, int upper) {
3        int n = nums.length;
4
5        int len = upper - lower + 1;
6        int[] temp = new int[len];
7
8        for(int i = 0; i<n; i++){
9            if(nums[i] >= lower && nums[i] <= upper){
10                temp[nums[i] - lower]++;
11            }
12        }
13
14        List<List<Integer>> list = new ArrayList<>();
15
16        for(int i = 0; i<len; i++){
17            if(temp[i] != 0) continue;
18
19            List<Integer> subList = new ArrayList<>();
20            subList.add(i+lower);
21            while(i < len && temp[i] == 0){
22                i++;
23            }
24            i--;
25            subList.add(i+lower);
26
27            list.add(subList);
28        }
29
30        return list;
31    }
32}
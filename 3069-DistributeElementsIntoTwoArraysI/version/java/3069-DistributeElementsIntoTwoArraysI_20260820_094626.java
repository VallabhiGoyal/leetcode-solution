// Last updated: 8/20/2026, 9:46:26 AM
1class Solution {
2    public int[] resultArray(int[] nums) {
3        int n = nums.length;
4
5        List<Integer> temp1 = new ArrayList<>();
6        temp1.add(nums[0]);
7
8        List<Integer> temp2 = new ArrayList<>();
9        temp2.add(nums[1]);
10
11        for(int i = 2; i<n; i++){
12            if(temp1.get(temp1.size()-1) >= temp2.get(temp2.size()-1)){
13                temp1.add(nums[i]);
14            }else{
15                temp2.add(nums[i]);
16            }
17        }
18
19        int[] ans = new int[n];
20
21        int size = temp1.size();
22        int i = 0; 
23        while(i < size){
24            ans[i] = temp1.get(i++);
25        }
26
27        size = temp2.size();
28        int j = 0;
29        while(j < size){
30            ans[i++] = temp2.get(j++);
31        }
32
33        return ans;
34    }
35}
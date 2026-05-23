// Last updated: 5/23/2026, 8:38:19 PM
1class Solution {
2    public int minimumSwaps(int[] nums) {
3        int n = nums.length;
4
5        int countZero = 0;
6
7        for(int i = 0; i<n; i++){
8            if(nums[i] == 0) countZero++;
9        }
10
11        if(countZero == n) return 0;
12
13        int i = 0; 
14        int j = n-1;
15        int count = 0;
16
17        while(j>=0 && nums[j] == 0) j--;
18
19        while(i<j){
20            if(nums[i] != 0){
21                i++;
22                continue;
23            }
24
25            while(i<j && nums[j] == 0) j--;
26
27            int temp = nums[i];
28            nums[i] = nums[j];
29            nums[j] = temp;
30            i++;
31            j--;
32            count++;
33            
34            while(i<j && nums[j] == 0) j--;            
35        }
36
37        return count;
38    }
39}
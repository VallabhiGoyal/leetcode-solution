// Last updated: 7/16/2026, 7:47:56 AM
1class Solution {
2    public int[] maxSlidingWindow(int[] nums, int k) {
3        int n = nums.length;
4        if(n == 1 || k == 1) return nums;
5
6        //step 1 make the result window
7        int size = n - k + 1;
8        int[] result = new int[size];
9        int idx  =  0;
10
11        //step 2 use a dequeu to track the curr max
12        Deque<Integer> dq = new ArrayDeque<>(); //stores index
13
14        //step 3 create, expand, shrink window
15       
16
17        for(int j = 0; j<n; j++){
18            //elements outside the window
19            while(!dq.isEmpty() && dq.peekFirst() < j - k + 1){
20                dq.pollFirst();
21            }
22
23            //before inserting new element remove extra one
24            while(!dq.isEmpty() && nums[j] > nums[dq.peekLast()]){
25                dq.pollLast();
26            }
27
28            //add new element
29            dq.addLast(j);
30
31            //record result
32            if(j>=k-1){
33                result[idx++] = nums[dq.peekFirst()];
34            }
35        }
36
37        return result;
38    }
39}
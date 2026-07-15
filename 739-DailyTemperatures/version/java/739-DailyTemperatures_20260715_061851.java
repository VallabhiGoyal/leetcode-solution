// Last updated: 7/15/2026, 6:18:51 AM
1class Solution {
2    public int[] dailyTemperatures(int[] temperatures) {
3        int n = temperatures.length;
4
5        int[] ans = new int[n];
6
7        Stack<Integer> stack = new Stack<>();
8        stack.push(0);
9
10        int i = 1;
11        while(i<n){
12            while(!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]){
13                int currIdx = stack.pop();
14                ans[currIdx] = i - currIdx;
15            }
16
17            stack.push(i);
18            i++;
19        }
20
21        return ans;
22    }
23}
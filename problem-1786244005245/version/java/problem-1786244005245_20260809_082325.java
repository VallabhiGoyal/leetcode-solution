// Last updated: 8/9/2026, 8:23:25 AM
1class Solution {
2    public long weightedSum(int[] parent, int[] nums) {
3        int n = parent.length;
4
5        Map<Integer, List<Integer>> map = new HashMap<>();
6
7        for(int i = 1; i<n; i++){
8            map.computeIfAbsent(parent[i], k -> new ArrayList<>()).add(i);
9        }
10        
11        int[] h = new int[n];
12        h[0] = 1;
13
14        Stack<Integer> stack = new Stack<>();
15        stack.push(0);
16
17        while(!stack.isEmpty()){
18            int curr = stack.pop();
19            
20            if(!map.containsKey(curr)){
21                continue;
22            }
23            List<Integer> list = map.get(curr);
24            int size = list.size();
25            
26            for(int i = 0; i < size; i++){
27                stack.push(list.get(i));
28                h[list.get(i)] = h[curr]+1;
29            }
30        }
31
32        int maxHeight = 0;
33        for(int i = 0; i<n; i++){
34            maxHeight = Math.max(maxHeight, h[i]);
35        }
36
37        long ans = 0;
38        for(int i = 0; i<n; i++){
39            ans += ((long)nums[i] * (long)(maxHeight - h[i] + 1));
40        }
41
42        return ans;
43    }
44    
45}
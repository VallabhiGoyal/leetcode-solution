// Last updated: 8/7/2026, 11:31:55 AM
1class Solution {
2    public String getPermutation(int n, int k) {
3        int[] ans = new int[n];
4
5        List<Integer> list = new ArrayList<>();
6        for(int i = 1; i <= n; i++){
7            list.add(i);
8        }
9
10        int pos = 0;
11        int total = fact(list.size()-1);
12        k--;
13
14        while(!list.isEmpty()){
15            int idx = k/total;
16
17            ans[pos++] = list.get(idx);
18            list.remove(idx);
19
20            k = k % total;
21            if(list.size() > 1){
22                total /= list.size();
23            }
24        }
25
26        StringBuilder sb = new StringBuilder();
27        for(int i = 0; i<n; i++){
28            sb.append(ans[i]);
29        }
30
31        return sb.toString();
32    }
33
34    public int fact(int n){
35        int ans = 1;
36        for(int i = 1; i<=n; i++){
37            ans *= i;
38        }
39
40        return ans;
41    }
42}
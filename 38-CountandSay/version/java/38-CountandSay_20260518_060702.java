// Last updated: 5/18/2026, 6:07:02 AM
1class Solution {
2    public String countAndSay(int n) {
3        if(n == 1) return "1";
4        StringBuilder ans = new StringBuilder("1");
5
6        for(int i = 2; i<=n; i++){
7            String curr = ans.toString();
8
9            StringBuilder sb = new StringBuilder();
10
11            int len = curr.length();
12            for(int j = 0; j<len; j++){
13                char ch = curr.charAt(j);
14
15                int k = j;
16                int count = 0;
17                while(k<len && ch == curr.charAt(k)){
18                    k++;
19                    count++;
20                }
21                j = k-1;
22
23                sb.append(count);
24                sb.append(ch);
25            }
26
27            ans = sb;
28        }
29
30        return ans.toString();
31    }
32}
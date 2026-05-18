// Last updated: 5/18/2026, 6:09:58 AM
1class Solution {
2    public String countAndSay(int n) {
3        if(n == 1) return "1";
4        
5        String curr = "1";
6
7        for(int i = 2; i<=n; i++){
8            StringBuilder sb = new StringBuilder();
9
10            int len = curr.length();
11
12            for(int j = 0; j<len; j++){
13                char ch = curr.charAt(j);
14
15                int count = 1;
16                while(j+1<len && ch == curr.charAt(j+1)){
17                    j++;
18                    count++;
19                }
20
21                sb.append(count);
22                sb.append(ch);
23            }
24
25            curr = sb.toString();
26        }
27
28        return curr;
29    }
30}
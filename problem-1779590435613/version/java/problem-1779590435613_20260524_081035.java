// Last updated: 5/24/2026, 8:10:35 AM
1class Solution {
2    public int passwordStrength(String password) {
3        int n = password.length();
4
5        Set<Character> set = new HashSet<>();
6
7        int ans = 0;
8        for(int i = 0; i<n; i++){
9            char curr = password.charAt(i);
10            if(set.contains(curr)) continue;
11
12            set.add(curr);
13            if(curr >= 'a' && curr <= 'z') ans+=1;
14            else if(curr >='A' && curr <= 'Z') ans+=2;
15            else if(curr >= '0' && curr <= '9') ans+=3;
16            else ans += 5;
17        }
18
19        return ans;
20    }
21}
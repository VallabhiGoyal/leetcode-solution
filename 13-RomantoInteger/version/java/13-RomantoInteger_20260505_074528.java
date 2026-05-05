// Last updated: 5/5/2026, 7:45:28 AM
1class Solution {
2    public int romanToInt(String s) {
3        int n = s.length();
4
5        Map<Character, Integer> map = new HashMap<>();
6
7        map.put('I', 1);
8        map.put('V', 5);
9        map.put('X', 10);
10        map.put('L', 50);
11        map.put('C', 100);
12        map.put('D', 500);
13        map.put('M', 1000);
14
15        int ans = 0;
16        for(int i = 0; i<n; i++){
17            int curr = map.get(s.charAt(i));
18
19            if(i+1<n && curr < map.get(s.charAt(i+1))){
20                ans -= curr;
21            }else{
22                ans += curr;
23            }
24        }
25
26        return ans;
27    }
28}
// Last updated: 7/12/2026, 8:09:58 AM
1class Solution {
2    public int secondsBetweenTimes(String startTime, String endTime) {
3        int h1 = Integer.parseInt(startTime.substring(0, 2));
4        int m1 = Integer.parseInt(startTime.substring(3, 5));
5        int s1 = Integer.parseInt(startTime.substring(6, 8));
6
7        int h2 = Integer.parseInt(endTime.substring(0, 2));
8        int m2 = Integer.parseInt(endTime.substring(3, 5));
9        int s2 = Integer.parseInt(endTime.substring(6, 8));
10
11        int ans = 0;
12        if(s2 >= s1) ans = s2-s1;
13        else{
14            ans = 60 + s2 - s1;
15            m2 = m2 - 1;
16        }
17
18        if(m2 >= m1) ans += (m2 - m1)*60;
19        else{
20            ans += (60 + m2 - m1)*60;
21            h2 = h2-1;
22        }
23
24        ans += (h2 - h1)*3600;
25        
26        return ans;
27    }
28}
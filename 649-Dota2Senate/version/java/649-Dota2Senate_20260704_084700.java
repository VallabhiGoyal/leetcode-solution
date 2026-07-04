// Last updated: 7/4/2026, 8:47:00 AM
1class Solution {
2    public String predictPartyVictory(String senate) {
3        int n = senate.length();
4
5        if(n == 1) return senate.charAt(0) == 'R' ? "Radiant" : "Dire";
6
7        Queue<Integer> radiant = new LinkedList<>();
8        Queue<Integer> dire = new LinkedList<>();
9        
10        for(int i = 0; i<n; i++){
11            char ch = senate.charAt(i);
12            if(ch == 'R') radiant.add(i);
13            else dire.add(i);
14        }
15
16        while(!radiant.isEmpty() && !dire.isEmpty()){
17            int r = radiant.poll();
18            int d = dire.poll();
19            if (r < d) {
20                radiant.offer(r + n);
21            } else {
22                dire.offer(d + n);
23            }
24        }
25
26        return radiant.isEmpty() ? "Dire" : "Radiant";
27    }
28}
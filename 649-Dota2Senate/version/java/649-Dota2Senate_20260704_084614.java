// Last updated: 7/4/2026, 8:46:14 AM
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
17            if(radiant.peek() < dire.peek()){
18                dire.remove();
19                int curr = radiant.poll();
20                radiant.add(curr + n);
21            }else{
22                radiant.remove();
23                int curr = dire.poll();
24                dire.add(curr + n);
25            }
26        }
27
28        return radiant.isEmpty() ? "Dire" : "Radiant";
29    }
30}
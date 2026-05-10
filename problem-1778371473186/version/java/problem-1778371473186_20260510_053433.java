// Last updated: 5/10/2026, 5:34:33 AM
1class Solution {
2    public int[] scoreValidator(String[] events) {
3        int n = events.length;
4
5        int score = 0;
6        int counter = 0;
7
8        for(int i = 0; i<n; i++){
9            String s = events[i];
10            if(s.equals("0")) continue;
11            else if(s.equals("1")) score+=1;
12            else if(s.equals("2")) score+=2;
13            else if(s.equals("3")) score+=3;
14            else if(s.equals("4")) score+=4;
15            else if(s.equals("5")) score+=5;
16            else if(s.equals("6")) score+=6;
17            else if(s.equals("W")) counter++;
18            else if(s.equals("WD")) score++;
19            else score++;
20
21            if(counter >= 10) break;
22        }
23
24        return new int[]{score, counter};
25    }
26}
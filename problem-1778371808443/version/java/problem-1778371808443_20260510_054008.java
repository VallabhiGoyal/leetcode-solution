// Last updated: 5/10/2026, 5:40:08 AM
1class Solution {
2    public int[] scoreValidator(String[] events) {
3        int n = events.length;
4
5        int score = 0;
6        int counter = 0;
7
8        for(int i = 0; i<n; i++){
9            String s = events[i];
10            if(Character.isDigit(events[i].charAt(0))){
11                score += events[i].charAt(0) - '0';
12            }else if(events[i].equals("W")) counter++;
13            else score++;
14
15            if(counter >= 10) break;
16        }
17
18        return new int[]{score, counter};
19    }
20}
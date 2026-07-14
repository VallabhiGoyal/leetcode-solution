// Last updated: 7/14/2026, 6:48:36 AM
1class Solution {
2    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
3        int[] month = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
4
5        int aliceStart = getDay(arriveAlice, month);
6        int aliceEnd = getDay(leaveAlice, month);
7        int bobStart = getDay(arriveBob, month);
8        int bobEnd = getDay(leaveBob, month);
9
10        int start = Math.max(aliceStart, bobStart);
11        int end = Math.min(aliceEnd, bobEnd);
12
13        return Math.max(0, end - start + 1);
14    }
15
16    private int getDay(String date, int[] month) {
17        int m = Integer.parseInt(date.substring(0, 2));
18        int d = Integer.parseInt(date.substring(3, 5));
19
20        int days = d;
21        for (int i = 1; i < m; i++) {
22            days += month[i];
23        }
24
25        return days;
26    }
27}
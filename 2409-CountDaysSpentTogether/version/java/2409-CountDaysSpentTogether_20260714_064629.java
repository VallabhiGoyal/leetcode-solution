// Last updated: 7/14/2026, 6:46:29 AM
1class Solution {
2    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
3        int[] month = new int[13];
4
5        month[1] = 31;
6        month[2] = 28;
7        month[3] = 31;
8        month[4] = 30;
9        month[5] = 31;
10        month[6] = 30;
11        month[7] = 31;
12        month[8] = 31;
13        month[9] = 30;
14        month[10] = 31;
15        month[11] = 30;
16        month[12] = 31;
17
18        // Alice arrive
19        int arriveMonthAlice = Integer.parseInt(arriveAlice.substring(0, 2));
20        int arriveDayAlice = Integer.parseInt(arriveAlice.substring(3, 5));
21
22        // Alice leave
23        int leaveMonthAlice = Integer.parseInt(leaveAlice.substring(0, 2));
24        int leaveDayAlice = Integer.parseInt(leaveAlice.substring(3, 5));
25
26        // Bob arrive
27        int arriveMonthBob = Integer.parseInt(arriveBob.substring(0, 2));
28        int arriveDayBob = Integer.parseInt(arriveBob.substring(3, 5));
29
30        // Bob leave
31        int leaveMonthBob = Integer.parseInt(leaveBob.substring(0, 2));
32        int leaveDayBob = Integer.parseInt(leaveBob.substring(3, 5));
33
34        // No overlap
35        if (arriveMonthAlice > leaveMonthBob ||
36            (arriveMonthAlice == leaveMonthBob && arriveDayAlice > leaveDayBob) ||
37            arriveMonthBob > leaveMonthAlice ||
38            (arriveMonthBob == leaveMonthAlice && arriveDayBob > leaveDayAlice))
39            return 0;
40
41        int maxArriveMonth = Math.max(arriveMonthAlice, arriveMonthBob);
42        int maxArriveDay;
43
44        if (arriveMonthAlice > arriveMonthBob)
45            maxArriveDay = arriveDayAlice;
46        else if (arriveMonthBob > arriveMonthAlice)
47            maxArriveDay = arriveDayBob;
48        else
49            maxArriveDay = Math.max(arriveDayAlice, arriveDayBob);
50
51        int minLeaveMonth = Math.min(leaveMonthAlice, leaveMonthBob);
52        int minLeaveDay;
53
54        if (leaveMonthAlice < leaveMonthBob)
55            minLeaveDay = leaveDayAlice;
56        else if (leaveMonthBob < leaveMonthAlice)
57            minLeaveDay = leaveDayBob;
58        else
59            minLeaveDay = Math.min(leaveDayAlice, leaveDayBob);
60
61        int count = 0;
62
63        if (maxArriveMonth == minLeaveMonth) {
64            return minLeaveDay - maxArriveDay + 1;
65        } else {
66            count = month[maxArriveMonth] - maxArriveDay + 1;
67            maxArriveMonth++;
68
69            for (int i = maxArriveMonth; i < minLeaveMonth; i++) {
70                count += month[i];
71            }
72
73            count += minLeaveDay;
74        }
75
76        return count;
77    }
78}
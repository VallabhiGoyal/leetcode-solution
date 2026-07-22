// Last updated: 7/22/2026, 10:20:38 AM
1class Solution {
2    public int maxActiveSectionsAfterTrade(String s) {
3        s = "1" + s + "1";
4
5        int n = s.length();
6
7        List<int[]> list = new ArrayList<>();
8
9        for (int i = 0; i < n; i++) {
10            int curr = s.charAt(i) - '0';
11            int[] temp = new int[2];
12            temp[0] = curr;
13            int count = 0;
14            while (i < n && s.charAt(i) - '0' == curr) {
15                i++;
16                count++;
17            }
18
19            temp[1] = count;
20            i--;
21            list.add(temp);
22        }
23
24        int totalOnes = 0;
25
26        for(int i = 0; i<n; i++){
27            if(s.charAt(i) == '1') totalOnes++;
28        }
29
30        int ans = totalOnes;
31
32        int size = list.size();
33
34        for (int i = 1; i < size - 1; i++) {
35            if (list.get(i)[0] == 1 &&
36                list.get(i - 1)[0] == 0 &&
37                list.get(i + 1)[0] == 0) {
38
39                int oneLen = list.get(i)[1];
40                int leftZero = list.get(i - 1)[1];
41                int rightZero = list.get(i + 1)[1];
42
43                int gain = leftZero + oneLen + rightZero;
44                ans = Math.max(ans, totalOnes - oneLen + gain);
45            }
46        }
47
48        ans -= 2;
49
50        return ans;
51    }
52}
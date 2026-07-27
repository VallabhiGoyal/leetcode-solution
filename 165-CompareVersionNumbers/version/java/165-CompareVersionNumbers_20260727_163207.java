// Last updated: 7/27/2026, 4:32:07 PM
1class Solution {
2    public int compareVersion(String version1, String version2) {
3        int n1 = version1.length();
4        int n2 = version2.length();
5
6        int start1 = 0;
7        int start2 = 0;
8
9        int end1 = 0;
10        int end2 = 0;
11
12        while(end1 < n1 && end2 < n2){
13            while(end1 < n1 && version1.charAt(end1) != '.') end1++;
14            while(end2 < n2 && version2.charAt(end2) != '.') end2++;
15
16            int temp1 = Integer.parseInt(version1.substring(start1, end1));
17
18            int temp2 = Integer.parseInt(version2.substring(start2, end2));
19
20            start1 = ++end1;
21            start2 = ++end2;
22
23            if(temp1 > temp2) return 1;
24            else if(temp2 > temp1) return -1;
25        }
26
27        while(end1 < n1){
28            while(end1 < n1 && version1.charAt(end1) != '.') end1++;
29
30            int temp1 = Integer.parseInt(version1.substring(start1, end1));
31
32            start1 = ++end1;
33
34            if(temp1 > 0) return 1;
35        }
36
37        while(end2 < n2){
38            while(end2 < n2 && version2.charAt(end2) != '.') end2++;
39
40            int temp1 = Integer.parseInt(version2.substring(start2, end2));
41
42            start2 = ++end2;
43
44            if(temp1 > 0) return -1;
45        }
46
47        return 0;
48    }
49}
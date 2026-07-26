// Last updated: 7/26/2026, 8:16:59 AM
1class Solution {
2    public List<List<Integer>> aggregateTimeSeries(int[][] series1, int[][] series2) {
3        int n = series1.length;
4        int m = series2.length;
5
6        List<List<Integer>> ans = new ArrayList<>();
7        
8        int i = 0;
9        int j = 0;
10
11        while(i < n && j < m){
12            int[] curr1 = series1[i];
13            int[] curr2 = series2[j];
14
15            List<Integer> temp = new ArrayList<>();
16            if(curr1[0] == curr2[0]){
17                temp.add(curr1[0]);
18                temp.add(curr1[1] + curr2[1]);
19                i++;
20                j++;
21            }else if(curr1[0] < curr2[0]){
22                temp.add(curr1[0]);
23                temp.add(curr1[1] + curr2[1]);
24                i++;
25            }else{
26                temp.add(curr2[0]);
27                temp.add(curr1[1] + curr2[1]);
28                j++;
29            }
30
31            ans.add(temp);
32        }
33
34        while(i < n){
35            List<Integer> temp = new ArrayList<>();
36            temp.add(series1[i][0]);
37            temp.add(series1[i][1]);
38            ans.add(temp);
39            i++;
40        }
41
42        while(j < m){
43            List<Integer> temp = new ArrayList<>();
44            temp.add(series2[j][0]);
45            temp.add(series2[j][1]);
46            ans.add(temp);
47            j++;
48        }
49
50        return ans;
51    }
52}
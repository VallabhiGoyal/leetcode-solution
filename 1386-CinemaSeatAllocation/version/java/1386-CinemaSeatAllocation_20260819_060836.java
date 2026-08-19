// Last updated: 8/19/2026, 6:08:36 AM
1class Solution {
2    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
3        int m = reservedSeats.length;
4
5        Map<Integer, List<Integer>> map = new HashMap<>();
6
7        for(int i = 0; i < m; i++){
8            int row = reservedSeats[i][0];
9            int col = reservedSeats[i][1];
10
11            if(col == 1 || col == 10) continue;
12            map.computeIfAbsent(row, k -> new ArrayList<>()).add(col);    
13        }
14
15        int count = 0;
16        for(int key : map.keySet()){
17            List<Integer> list = map.get(key);
18            boolean[] inValid = new boolean[3];
19
20            int size = list.size();
21            for(int i = 0; i < size; i++){
22                int curr = list.get(i);
23
24                if(curr == 2 || curr == 3 || curr == 4 || curr == 5){
25                    inValid[0] = true;
26                }
27                if(curr == 4 || curr == 5 || curr == 6 || curr == 7){
28                    inValid[1] = true;
29                }
30                if(curr == 6 || curr == 7 || curr == 8 || curr == 9){
31                    inValid[2] = true;
32                }
33            }
34            if(inValid[0] && inValid[2] && inValid[1]){
35                count+=2;
36            }else if(inValid[0] || inValid[1] || inValid[2]) count++;    
37        }
38        return n*2 - count; 
39    }
40}
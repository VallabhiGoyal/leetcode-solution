// Last updated: 10/27/2026, 5:46:49 AM
1class Solution {
2    public String[] createGrid(int m, int n) {
3        String[] grid = new String[m];
4
5        StringBuilder sb = new StringBuilder();
6        int j = 0;
7        while(j<n){
8            sb.append('.');
9            j++;
10        }
11        grid[0] = sb.toString();
12
13        StringBuilder sb2 = new StringBuilder();
14        j = 1;
15        while(j<n){
16            sb2.append('#');
17            j++;
18        }
19        sb2.append('.');
20        
21        for(int i = 1; i<m; i++){
22            grid[i] = sb2.toString();
23        }
24
25        return grid;
26    }
27}
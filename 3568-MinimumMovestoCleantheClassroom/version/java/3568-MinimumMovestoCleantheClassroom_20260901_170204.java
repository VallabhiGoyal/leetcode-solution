// Last updated: 9/1/2026, 5:02:04 PM
1class Solution {
2    public int minMoves(String[] classroom, int energy) {
3        int m = classroom.length;
4        int n = classroom[0].length();
5
6        int sr = -1, sc = -1;
7        int lampCount = 0;
8
9        for (int i = 0; i < m; i++) {
10            for (int j = 0; j < n; j++) {
11                char ch = classroom[i].charAt(j);
12
13                if (ch == 'S') {
14                    sr = i;
15                    sc = j;
16                } else if (ch == 'L') {
17                    lampCount++;
18                }
19            }
20        }
21
22        if (lampCount == 0) {
23            return 0;
24        }
25
26        int fullMask = (1 << lampCount) - 1;
27
28        int[][] lampId = new int[m][n];
29        for (int i = 0; i < m; i++) {
30            Arrays.fill(lampId[i], -1);
31        }
32
33        int id = 0;
34
35        for (int i = 0; i < m; i++) {
36            for (int j = 0; j < n; j++) {
37                if (classroom[i].charAt(j) == 'L') {
38                    lampId[i][j] = id++;
39                }
40            }
41        }
42
43        Queue<int[]> q = new ArrayDeque<>();
44
45        q.offer(new int[]{sr, sc, energy, 0});
46
47        boolean[][][][] visited = new boolean[m][n][energy + 1][1 << lampCount];
48
49        visited[sr][sc][energy][0] = true;
50
51        int[][] directions = {
52            {-1, 0},
53            {1, 0},
54            {0, -1},
55            {0, 1}
56        };
57
58        int moves = 0;
59
60        while (!q.isEmpty()) {
61            int size = q.size();
62
63            while (size-- > 0) {
64                int[] curr = q.poll();
65
66                int r = curr[0];
67                int c = curr[1];
68                int currEnergy = curr[2];
69                int mask = curr[3];
70
71                if (mask == fullMask) {
72                    return moves;
73                }
74
75                for (int[] dir : directions) {
76                    int nr = r + dir[0];
77                    int nc = c + dir[1];
78
79                    if (nr < 0 || nr >= m || nc < 0 || nc >= n) {
80                        continue;
81                    }
82
83                    char ch = classroom[nr].charAt(nc);
84
85                    if (ch == 'X') {
86                        continue;
87                    }
88
89                    if (currEnergy == 0) {
90                        continue;
91                    }
92
93                    int newEnergy = currEnergy - 1;
94                    int newMask = mask;
95
96                    if (ch == 'R') {
97                        newEnergy = energy;
98                    }
99
100                    if (ch == 'L') {
101                        int lamp = lampId[nr][nc];
102                        newMask |= (1 << lamp);
103                    }
104
105                    if (!visited[nr][nc][newEnergy][newMask]) {
106                        visited[nr][nc][newEnergy][newMask] = true;
107
108                        q.offer(new int[]{
109                            nr,
110                            nc,
111                            newEnergy,
112                            newMask
113                        });
114                    }
115                }
116            }
117
118            moves++;
119        }
120
121        return -1;
122    }
123}
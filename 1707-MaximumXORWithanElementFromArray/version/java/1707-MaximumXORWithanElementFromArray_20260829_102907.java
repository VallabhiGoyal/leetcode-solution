// Last updated: 8/29/2026, 10:29:07 AM
1class Solution {
2    public int[] maximizeXor(int[] nums, int[][] queries) {
3        int n = nums.length;
4        int m = queries.length;
5
6        Arrays.sort(nums);
7        
8        int[][] newQueries = new int[m][3];
9        for(int i = 0; i<m; i++){
10            newQueries[i][0] = queries[i][0];
11            newQueries[i][1] = queries[i][1];
12            newQueries[i][2] = i;
13        }
14
15        Arrays.sort(newQueries, (a, b) -> Integer.compare(a[1], b[1]));
16
17        int[] ans = new int[m];
18
19        int idx = 0;
20        Node root = new Node();
21
22        for(int i = 0; i<m; i++){
23            int max = newQueries[i][1];
24            while(idx < n && nums[idx] <= max){
25                insert(root, nums[idx++]);
26            }
27            if(idx == 0){
28                ans[newQueries[i][2]] = -1;
29            }else{
30                ans[newQueries[i][2]] = getMaxXor(root, newQueries[i][0]);
31            }
32        }
33
34        return ans;
35    }
36
37    public int getMaxXor(Node root, int num){
38        int xor = 0;
39
40        for(int i = 30; i>=0; i--){
41            int bit = (num >> i) & 1;
42            if(bit == 0){
43                if(root.right != null){
44                    root = root.right;
45                    xor = (xor << 1) | 1;
46                }else{
47                    root = root.left;
48                    xor <<= 1;
49                }
50            }else{
51                if(root.left != null){
52                    root = root.left;
53                    xor = (xor << 1) | 1;
54                }else{
55                    root = root.right;
56                    xor <<= 1;
57                }
58            }
59        }
60
61        return xor;
62    }
63
64    public void insert(Node root, int num){
65        for(int i = 30; i>=0; i--){
66            int bit = (num >> i) & 1;
67            if(bit == 0){
68                if(root.left == null){
69                    root.left = new Node();
70                }
71
72                root = root.left;
73            }else{
74                if(root.right == null){
75                    root.right = new Node();
76                }
77
78                root = root.right;
79            }
80        }
81    }
82
83    class Node{
84        Node left;
85        Node right;
86    }
87}
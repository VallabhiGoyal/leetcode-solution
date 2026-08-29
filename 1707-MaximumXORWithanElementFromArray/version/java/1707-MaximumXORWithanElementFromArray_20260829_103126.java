// Last updated: 8/29/2026, 10:31:26 AM
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
18        for(int i = 0; i<m; i++){
19            ans[i] = -1;
20        }
21
22        int idx = 0;
23        Node root = new Node();
24
25        for(int i = 0; i<m; i++){
26            int max = newQueries[i][1];
27            while(idx < n && nums[idx] <= max){
28                insert(root, nums[idx++]);
29            }
30            if(idx > 0){
31                ans[newQueries[i][2]] = getMaxXor(root, newQueries[i][0]);
32            }
33        }
34
35        return ans;
36    }
37
38    public int getMaxXor(Node root, int num){
39        int xor = 0;
40
41        for(int i = 30; i>=0; i--){
42            int bit = (num >> i) & 1;
43            if(bit == 0){
44                if(root.right != null){
45                    root = root.right;
46                    xor = (xor << 1) | 1;
47                }else{
48                    root = root.left;
49                    xor <<= 1;
50                }
51            }else{
52                if(root.left != null){
53                    root = root.left;
54                    xor = (xor << 1) | 1;
55                }else{
56                    root = root.right;
57                    xor <<= 1;
58                }
59            }
60        }
61
62        return xor;
63    }
64
65    public void insert(Node root, int num){
66        for(int i = 30; i>=0; i--){
67            int bit = (num >> i) & 1;
68            if(bit == 0){
69                if(root.left == null){
70                    root.left = new Node();
71                }
72
73                root = root.left;
74            }else{
75                if(root.right == null){
76                    root.right = new Node();
77                }
78
79                root = root.right;
80            }
81        }
82    }
83
84    class Node{
85        Node left;
86        Node right;
87    }
88}
// Last updated: 7/28/2026, 10:48:14 AM
1class Solution {
2    public int findMaximumXOR(int[] nums) {
3        int n = nums.length;
4
5        Node root = new Node();
6        
7        for(int i = 0; i<n; i++){
8            int curr = nums[i];
9
10            Node temp = root;
11
12            for(int j = 31; j >= 0; j--){
13                int currBit = ((curr >> j) & 1);
14
15                if(currBit == 0){
16                    if(temp.left == null){
17                        temp.left = new Node();
18                    }
19                    temp = temp.left;
20                }else{
21                    if(temp.right == null){
22                        temp.right = new Node();
23                    }
24                    temp = temp.right;
25                }
26            }
27        }
28
29        int max = 0;
30
31        for(int i = 0; i<n; i++){
32            int curr = nums[i];
33            Node temp = root;
34            int currXor = 0;
35
36            for(int j = 31; j >= 0; j--){
37                int currBit = ((curr >> j) & 1);    
38
39                if(currBit == 0){
40                    if(temp.right != null){
41                        temp = temp.right;
42                        currXor |= (1 << j);
43                    }else{
44                        temp = temp.left;
45                    }
46                    
47                }else{
48                    if(temp.left != null){
49                        temp = temp.left;
50                        currXor |= (1 << j);
51                    }else{
52                        temp = temp.right;
53                    }
54                }
55            }
56
57            max = Math.max(max, currXor);
58        }
59
60        return max;
61    }
62
63    class Node{
64        Node left;
65        Node right;
66    }
67}
// Last updated: 7/18/2026, 9:27:27 PM
1class Solution {
2    public int minAdjacentSwaps(int[] nums, int a, int b) {
3        int n = nums.length;
4
5        int MOD = 1000000007;
6        
7        int countA = 0;
8        int countB = 0;
9
10        for(int i = 0; i<n; i++){
11            if(nums[i] < a){
12                nums[i] = 0;
13                countA++;
14            }else if(nums[i] >= a && nums[i] <= b){
15                nums[i] = 1;
16                countB++;
17            }else{
18                nums[i] = 2;
19            }
20        }
21
22        int nextA = 0;
23        int nextB = countA;
24        int nextC = countA + countB;
25        
26        int[] target = new int[n];
27    
28        for(int i = 0; i<n; i++){
29            if(nums[i] == 0){
30                target[i] = nextA++;
31            }else if(nums[i] == 1){
32                target[i] = nextB++;
33            }else{
34                target[i] = nextC++;
35            }
36        }
37
38        long count = mergeSort(target, 0, n-1) % MOD;
39
40        return (int)count;
41    }
42
43    public long mergeSort(int[] target, int l, int r){
44        if(l >= r) return 0;
45
46        int mid = l + (r - l)/2;
47
48        long count = 0;
49
50        count += mergeSort(target, l, mid);
51        count += mergeSort(target, mid + 1, r);
52        count += merge(target, l, r);
53        
54        return count;
55    }
56
57    public long merge(int[] target, int l, int r){
58        int mid = l + (r - l)/2;
59
60        int[] temp = new int[r - l + 1];
61
62        int i = l;
63        int j = mid + 1;
64        int k = 0;
65
66        long count = 0;
67
68        while(i <= mid && j <= r){
69            if(target[i] <= target[j]){
70                temp[k] = target[i];
71                k++;
72                i++;
73            }else{
74                count += mid - i + 1;
75                temp[k] = target[j];
76                k++;
77                j++;
78            }
79        }
80
81        while(i <= mid){
82            temp[k++] = target[i++];
83        }
84
85        while(j <= r){
86            temp[k++] = target[j++];
87        }
88
89        k = 0;
90        for(i = l; i <= r; i++){
91            target[i] = temp[k++];
92        }
93
94        return count;
95    }
96    
97}
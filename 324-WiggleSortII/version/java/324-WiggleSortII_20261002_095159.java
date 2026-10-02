// Last updated: 10/2/2026, 9:51:59 AM
1class Solution {
2    public void wiggleSort(int[] nums) {
3        int n = nums.length;
4
5        int median = quickSelect(nums, 0, n-1, n/2);
6
7        int i = 0; 
8        int j = n-1;
9
10        int currIdx = 0;
11        while (currIdx <= j) {
12            int mappedCurr = (1 + 2 * currIdx) % (n | 1);
13
14            if (nums[mappedCurr] > median) {
15                int mappedLow = (1 + 2 * i) % (n | 1);
16                swap(nums, mappedLow, mappedCurr);
17                i++;
18                currIdx++;
19            } else if (nums[mappedCurr] < median) {
20                int mappedHigh = (1 + 2 * j) % (n | 1);
21                swap(nums, mappedCurr, mappedHigh);
22                j--;
23            } else {
24                currIdx++;
25            }
26        }
27    }
28
29    public int quickSelect(int[] nums, int low, int high, int k){
30        if(low > high) return -1;
31
32        int part = partition(nums, low, high);
33
34        if(part == k){
35            return nums[part];
36        }else if(part < k){
37            return quickSelect(nums, part + 1, high, k);
38        }else{
39            return quickSelect(nums, low, part - 1, k);
40        }
41    }
42
43    public int partition(int[] nums, int low, int high){
44        int pivot = nums[high];
45
46        int i = low - 1;
47
48        for(int j = low; j < high; j++){
49            if(nums[j] < pivot){
50                i++;
51                swap(nums, i, j);
52            }
53        }
54
55        swap(nums, i + 1, high);
56
57        return i+1;
58    }
59
60    public void swap(int[] nums, int i, int j){
61        int temp = nums[i];
62        nums[i] = nums[j];
63        nums[j] = temp;
64    }
65}
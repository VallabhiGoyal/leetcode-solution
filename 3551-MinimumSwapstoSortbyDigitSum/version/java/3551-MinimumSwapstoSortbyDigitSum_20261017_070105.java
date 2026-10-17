// Last updated: 10/17/2026, 7:01:05 AM
1class Solution {
2    public int minSwaps(int[] nums) {
3        int n = nums.length;
4        int[][] arr = new int[n][2];
5
6        for(int i = 0; i<n; i++){
7            arr[i][0] = digiSum(nums[i]);
8            arr[i][1] = i;
9        }
10
11        Arrays.sort(arr, (a, b) -> {
12            if(a[0] != b[0]) return a[0] - b[0];
13            else return nums[a[1]] - nums[b[1]];
14        });
15
16        boolean[] visited = new boolean[n];
17        int count = 0;
18
19        for (int i = 0; i < n; i++) {
20            if (visited[i] || arr[i][1] == i) {
21                continue;
22            }
23
24            int cycleSize = 0;
25            int j = i;
26
27            while (!visited[j]) {
28                visited[j] = true;
29                j = arr[j][1];
30                cycleSize++;
31            }
32
33            if (cycleSize > 1) {
34                count += cycleSize - 1;
35            }
36        }
37
38        return count;
39    }
40
41    public int digiSum(int n){
42        int temp = n;
43
44        int sum = 0;
45        while(temp != 0){
46            int rem = temp % 10;
47            sum += rem;
48            temp /= 10;
49        }
50
51        return sum;
52    }
53}
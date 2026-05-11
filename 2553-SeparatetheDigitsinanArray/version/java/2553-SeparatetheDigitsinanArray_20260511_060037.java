// Last updated: 5/11/2026, 6:00:37 AM
1class Solution {
2    public int[] separateDigits(int[] nums) {
3        int n = nums.length;
4
5        List<Integer> list = new ArrayList<>();
6
7        for(int i = n-1; i>=0; i--){
8            int curr = nums[i];
9            while(curr > 0){
10                int remain = curr % 10;
11                list.add(0, remain);
12                curr /= 10;
13            }
14        }
15
16        int size = list.size();
17        int[] answer = new int[size];
18
19        for(int i = 0; i<size; i++){
20            answer[i] = list.get(i);
21        }
22
23        return answer;
24    }
25}
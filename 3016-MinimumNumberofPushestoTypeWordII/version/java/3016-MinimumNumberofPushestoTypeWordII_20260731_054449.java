// Last updated: 7/31/2026, 5:44:49 AM
1class Solution {
2    public int minimumPushes(String word) {
3        int n = word.length();
4
5        int[] freq = new int[26];
6
7        for(int i = 0; i < n; i++){
8            freq[word.charAt(i) - 'a']++;
9        }
10
11        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
12
13        for(int i = 0; i < 26; i++){
14            if(freq[i] > 0) pq.add(freq[i]);
15        }
16
17        int ans = 0;
18        int currClick = 1;
19        while(!pq.isEmpty()){
20            int count = 0;
21
22            while(!pq.isEmpty() && count != 8){
23                ans = ans + currClick*pq.poll();
24                count++;
25            }
26
27            currClick++;
28        }
29
30        return ans;
31    }
32}
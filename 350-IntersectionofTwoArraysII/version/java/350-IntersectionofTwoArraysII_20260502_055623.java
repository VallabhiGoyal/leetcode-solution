// Last updated: 5/2/2026, 5:56:23 AM
1class Solution {
2    public int[] intersect(int[] nums1, int[] nums2) {
3        int m = nums1.length;
4        int n = nums2.length;
5
6        int[] freq = new int[1001];
7
8        for(int i = 0; i<m; i++){
9            freq[nums1[i]]++;
10        }
11
12        List<Integer> list = new ArrayList<>();
13        for(int i = 0; i<n; i++){
14            if(freq[nums2[i]] > 0){
15                list.add(nums2[i]);
16                freq[nums2[i]]--;
17            }
18        }
19
20        int size = list.size();
21        int[] ans = new int[size];
22
23        int idx = 0;
24        for(int i = 0; i<size; i++){
25            ans[i] = list.get(idx++);
26        }
27
28        return ans;
29    }
30}
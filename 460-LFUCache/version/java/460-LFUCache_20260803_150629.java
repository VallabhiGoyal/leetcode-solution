// Last updated: 8/3/2026, 3:06:29 PM
1class LFUCache {
2    Map<Integer, int[]> map;                
3    Map<Integer, LinkedHashSet<Integer>> freq; 
4    int size;
5    int minFreq;
6
7    public LFUCache(int capacity) {
8        map = new HashMap<>();
9        freq = new HashMap<>();
10        size = capacity;
11        minFreq = 0;
12    }
13
14    public int get(int key) {
15        if (!map.containsKey(key)) {
16            return -1;
17        }
18
19        int[] curr = map.get(key);
20        int value = curr[0];
21        int f = curr[1];
22
23        freq.get(f).remove(key);
24        if (freq.get(f).isEmpty()) {
25            freq.remove(f);
26            if (minFreq == f) {
27                minFreq++;
28            }
29        }
30
31        curr[1]++;
32        freq.computeIfAbsent(curr[1], k -> new LinkedHashSet<>()).add(key);
33
34        return value;
35    }
36
37    public void put(int key, int value) {
38        if (size == 0) return;
39
40        if (map.containsKey(key)) {
41            map.get(key)[0] = value;
42            get(key); 
43            return;
44        }
45
46        if (map.size() >= size) {
47            int removeKey = freq.get(minFreq).iterator().next();
48            freq.get(minFreq).remove(removeKey);
49            if (freq.get(minFreq).isEmpty()) {
50                freq.remove(minFreq);
51            }
52            map.remove(removeKey);
53        }
54
55        map.put(key, new int[]{value, 1});
56        freq.computeIfAbsent(1, k -> new LinkedHashSet<>()).add(key);
57        minFreq = 1;
58    }
59}
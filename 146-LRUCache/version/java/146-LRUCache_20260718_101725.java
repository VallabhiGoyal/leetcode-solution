// Last updated: 7/18/2026, 10:17:25 AM
1class LRUCache {
2    Map<Integer, Integer> map;
3    Integer limit;
4
5    Deque<Integer> dq;
6
7    public LRUCache(int capacity) {
8        map = new HashMap<>(capacity);
9        dq = new ArrayDeque<>();
10        limit = capacity;
11    }
12    
13    public int get(int key) {
14        if(map.containsKey(key)){
15            dq.remove(key);
16            dq.offerLast(key);
17            return map.get(key);
18        }
19        return -1;
20    }
21    
22    public void put(int key, int value) {
23        if(map.containsKey(key)){
24            dq.remove(key);
25        }else if(map.size() == limit){
26            int curr = dq.pollFirst();
27            map.remove(curr);
28        }
29
30        map.put(key, value);
31        dq.offerLast(key);
32    }
33}
34
35/**
36 * Your LRUCache object will be instantiated and called as such:
37 * LRUCache obj = new LRUCache(capacity);
38 * int param_1 = obj.get(key);
39 * obj.put(key,value);
40 */
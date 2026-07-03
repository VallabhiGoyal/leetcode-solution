// Last updated: 7/3/2026, 11:35:37 AM
class Solution {
    public long finishTime(int n, int[][] edges, int[] baseTime) {
        Map<Integer, List<Integer>> map = new HashMap<>();

        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];

            map.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
        }

        return helper(0, map, baseTime);
    }

    public long helper(int node, Map<Integer, List<Integer>> map, int[] baseTime){
        if(!map.containsKey(node)) return baseTime[node];
        
        List<Integer> list = map.get(node);        

        long max = Long.MIN_VALUE;
        long min = Long.MAX_VALUE;
        
        int len = list.size();
        for(int i = 0; i<len; i++){
            long child = helper(list.get(i), map, baseTime);

            max = Math.max(max, child);
            min = Math.min(min, child);
        }

        return max + (max - min) + baseTime[node];
    }
}
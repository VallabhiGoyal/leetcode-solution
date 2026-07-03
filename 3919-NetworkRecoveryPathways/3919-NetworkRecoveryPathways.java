// Last updated: 7/3/2026, 11:36:27 AM
class Solution {
    public int findMaxPathScore(int[][] edges, boolean[] online, long k) {
        Map<Integer, List<Node>> map = new HashMap<>();
        int maxEdgeWt = 0;

        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];

            if(!online[u] || !online[v]) continue;
            maxEdgeWt = Math.max(maxEdgeWt, wt);
            map.computeIfAbsent(u, t -> new ArrayList<>()).add(new Node(v, wt));
        }

        int start = 0;
        int end = maxEdgeWt;

        while(start <= end){
            int mid = start + (end - start)/2;

            if(check(mid, map, k, online.length - 1)){
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }

        return end;
    }

    private boolean check(int minEdge, Map<Integer, List<Node>> map, long k, int dest){

        long[] indegree = new long[dest+1];

        for(int i = 0; i<=dest; i++){
            List<Node> nodes = map.getOrDefault(i, new ArrayList<>());

            for(Node node : nodes){
                if(node.wt < minEdge) continue;
                indegree[node.v]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();

        for(int i = 0; i <= dest; i++){
            if(indegree[i] == 0) queue.add(i);
        }

        long[] dist = new long[dest + 1];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[0] = 0;
        

        while(!queue.isEmpty()){
            int curr = queue.poll();

            List<Node> nodes = map.getOrDefault(curr, new ArrayList<>());

            for(Node edge : nodes){
                if(edge.wt < minEdge) continue;

                if(dist[curr] != Long.MAX_VALUE && dist[curr] + edge.wt < dist[edge.v]){
                    dist[edge.v] = dist[curr] + edge.wt;
                }

                indegree[edge.v]--;

                if(indegree[edge.v] == 0) queue.add(edge.v);
            }
        }

        return dist[dest] <= k;
    }

    public class Node{
        int v;
        int wt;

        Node(int v, int wt){
            this.v = v;
            this.wt = wt;
        }
    }
}
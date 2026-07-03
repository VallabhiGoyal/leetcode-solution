// Last updated: 7/3/2026, 11:35:06 AM
class Solution {
    public int evenSumSubgraphs(int[] nums, int[][] edges) {
        int totalNodes = nums.length;
        int totalEdges = edges.length;

        List<Integer>[] adj = new ArrayList[totalNodes];
        for(int i = 0; i<totalNodes; i++){
            adj[i] = new ArrayList<>();
        }
        
        for(int i = 0; i<totalEdges; i++){
            int u = edges[i][0];
            int v = edges[i][1];

            List<Integer> list1 = adj[u];
            list1.add(v);

            List<Integer> list2 = adj[v];
            list2.add(u);
        }

        int totalSubset = 1 << totalNodes;
        int count  = 0;

        for(int mask = 0; mask < totalSubset; mask++){
            if(mask == 0) continue;

            int sum = 0;
            for(int i = 0; i<totalNodes; i++){
                if((mask & (1<<i)) != 0){
                    sum += nums[i];
                }
            }
            if(sum % 2 != 0) continue;

            int start = -1;
            for(int i = 0; i<totalNodes; i++){
                if((mask & (1 << i)) != 0){
                    start = i;
                    break;
                }
            }

            boolean[] visited = new boolean[totalNodes];
            Stack<Integer> stack = new Stack<>();
            stack.push(start);
            visited[start] = true;

            int visitedCount = 0;
            
            while(!stack.isEmpty()){
                int u = stack.pop();
                visitedCount++;

                for(int v : adj[u]){
                    if((mask & (1<<v)) != 0 && !visited[v]){
                        visited[v] = true;
                        stack.push(v);
                    }
                }
            }

            int size = Integer.bitCount(mask);

            if(visitedCount == size) count++;
            
        }

        return count;
    }
}
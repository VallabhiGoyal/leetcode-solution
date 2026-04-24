// Last updated: 4/24/2026, 10:32:56 AM
class Solution {

    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        
        List<Integer> list = new ArrayList<>();
        int[] state = new int[n];

        for(int i = 0; i<n; i++){
            if(dfs(i, graph, state)){
                list.add(i);
            }
        }

        return list;
    }

    private boolean dfs(int node, int[][] graph,int state[]){
        if(state[node] != 0){
            return state[node] == 2;
        }

        state[node] = 1;

        for(int neighbour : graph[node]){
            if(!dfs(neighbour, graph, state)){
                return false;
            }
        }
        
        state[node] = 2;
        return true;
    }
}
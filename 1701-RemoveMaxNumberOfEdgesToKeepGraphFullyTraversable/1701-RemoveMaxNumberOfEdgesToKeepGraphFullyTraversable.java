// Last updated: 4/24/2026, 10:31:38 AM
class Solution {

    public int maxNumEdgesToRemove(int n, int[][] edges) {
        DSU dsuAlice = new DSU(n);
        DSU dsuBob = new DSU(n);

        int count = 0;

        for(int i = 0; i<edges.length; i++){
            int type = edges[i][0];
            int u = edges[i][1];
            int v = edges[i][2];

            if(type == 3){
                boolean a = dsuAlice.union(u, v);
                boolean b = dsuBob.union(u, v);
                if (!a && !b) count++;
            }
        }

        for(int e[] : edges){
            int type = e[0];
            int u = e[1];
            int v = e[2];
            if(type == 1){
                if(!dsuAlice.union(u, v)) count++;
            }else if(type == 2){
                if(!dsuBob.union(u, v)) count++;
            }
        }

        int countParentA = 0;
        int countParentB = 0;
        for(int i = 1; i<n+1; i++){
            if(dsuAlice.find(i) == i){
                countParentA++;
            }
            if(dsuBob.find(i) == i){
                countParentB++;
            }
        }
        if(countParentA != 1 || countParentB != 1) return -1;
        

        return count;
    }

    public class DSU {
        int parent[];
        int rank[];

        public DSU(int n){
            parent = new int[n+1];
            rank = new int[n+1];

            for(int i = 0; i<n+1; i++){
                parent[i] = i;
                rank[i] = 1;
            }
        }

        public int find(int x){
            if(parent[x] != x){
                parent[x] = find(parent[x]);
            }

            return parent[x];
        }

        public boolean union(int a, int b){

            int pa = find(a);
            int pb = find(b);

            if(pa == pb) return false;

            if(rank[pa] < rank[pb]){
                parent[pa] = pb;
            }else if(rank[pb] < rank[pa]){
                parent[pb] = pa;
            }else{
                parent[pb] = pa;
                rank[pa]++;
            }

            return true;
        }
    }
}
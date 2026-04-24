// Last updated: 4/24/2026, 10:30:37 AM
class Solution {
    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        long[][] dist = new long[26][26];

        long max = (long)1e15;
        for(int i = 0; i<26; i++){
            for(int j = 0; j<26; j++){
                if(i!=j){
                    dist[i][j] = max;
                }
            }
            dist[i][i] = 0;
        }

        
        int n = original.length;

        for(int i = 0; i<n; i++){
            int org = original[i] - 'a';
            int chg = changed[i] - 'a';

            dist[org][chg] = Math.min(dist[org][chg], cost[i]);
        }

        //floyd - warshal
        for(int k = 0; k<26; k++){   //intermediate
            for(int i = 0; i<26; i++){ //source
                for(int j = 0; j<26; j++){ //dest
                    if(dist[i][k] == max || dist[k][j] == max) continue;
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }
        //final mincost

        int m = source.length();
        long minCost = 0;

        for(int i = 0; i<m; i++){
            int org = source.charAt(i) - 'a';
            int chg = target.charAt(i) - 'a';
            if(org == chg) continue;
            if(dist[org][chg] == max) return -1;
            minCost += dist[org][chg];
        }

        return minCost;
    }
}
// Last updated: 4/24/2026, 10:30:18 AM
class Solution {
    public long minMoves(int[] balance) {
        
        int[] distance = balance;

        int n = distance.length;
        long total = 0;
        int negIdx = -1;

        for (int i = 0; i < n; i++) {
            total += distance[i];
            if (distance[i] < 0) {
                negIdx = i;
            }
        }

        if (total < 0) return -1;

        if (negIdx == -1) return 0;

        long moves = 0;
        long need = -distance[negIdx];

        int dist = 1;
        while (need > 0) {

            int left = (negIdx - dist + n) % n;
            int right = (negIdx + dist) % n;

            if (distance[left] > 0) {
                long take = Math.min(distance[left], need);
                distance[left] -= take;
                need -= take;
                moves += take * dist;
            }

            if (distance[right] > 0 && need > 0) {
                long take = Math.min(distance[right], need);
                distance[right] -= take;
                need -= take;
                moves += take * dist;
            }

            dist++;
        }

        return moves;
    }
}

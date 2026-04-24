// Last updated: 4/24/2026, 10:30:03 AM
class Solution {
    public long minCost(String s, int[] cost) {
        int n = s.length();
        Map<Character, Long> map = new HashMap<>();
        long totalCost =0;
        for(int i= 0; i<n; i++){
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0L) + cost[i]);
            totalCost += cost[i];
        }

        if(map.size() <= 1) return 0;
        long minCost = -1;

        for(char ch : map.keySet()){
            long value = map.get(ch);
            long currCost = totalCost - value;
            if(minCost == -1) minCost = currCost;
            else minCost = Math.min(minCost, currCost);
        }

        return minCost;
    }
}
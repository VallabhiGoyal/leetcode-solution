// Last updated: 7/3/2026, 11:37:13 AM
class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int n = spells.length;
        int m = potions.length;

        Arrays.sort(potions);

        int[] pairs = new int[n];

        for(int i = 0; i<n; i++){
            int start = 0;
            int end = m-1;
            int ans = m;

            while(start <= end){
                int mid = start + (end - start)/2;

                if(1L * spells[i] * potions[mid] >= success){
                    end = mid - 1;
                    ans = mid;
                }else{
                    start = mid + 1;
                }

                pairs[i] = m - ans;
            }
        }

        return pairs;
    }
}
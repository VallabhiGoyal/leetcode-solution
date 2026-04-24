// Last updated: 4/24/2026, 10:31:49 AM
import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> list = new ArrayList<>();
        int max = candies[0];
        for(int i=0; i<candies.length; i++){
            max = Math.max(max, candies[i]);
        }

        for(int i = 0; i<candies.length; i++){
            list.add(candies[i]+extraCandies>=max);
        }

        return list;
    }
}
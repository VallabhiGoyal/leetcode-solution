// Last updated: 4/24/2026, 10:29:25 AM
import java.util.*;

class Solution {
    public int longestBalanced(String s) {
        int n = s.length();

        int totalZero = 0, totalOne = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '0') totalZero++;
            else totalOne++;
        }

        int ans = 0;

        Map<Integer, ArrayList<Integer>> map = new HashMap<>();
        map.put(0, new ArrayList<>());
        map.get(0).add(-1);

        int prefix = 0;

        for (int i = 0; i < n; i++) {

            prefix += (s.charAt(i) == '1' ? 1 : -1);

            if (map.containsKey(prefix)) {
                ans = Math.max(ans, i - map.get(prefix).get(0));
            }

            if (map.containsKey(prefix - 2)) {
                for (int idx : map.get(prefix - 2)) {
                    int len = i - idx;

                    int onesInSub = (len + 2) / 2;
                    int zerosInSub = len - onesInSub;

                    if (totalZero > zerosInSub) {
                        ans = Math.max(ans, len);
                        break;
                    }
                }
            }

            if (map.containsKey(prefix + 2)) {
                for (int idx : map.get(prefix + 2)) {
                    int len = i - idx;

                    int zerosInSub = (len + 2) / 2;
                    int onesInSub = len - zerosInSub;

                    if (totalOne > onesInSub) {
                        ans = Math.max(ans, len);
                        break;
                    }
                }
            }

            map.putIfAbsent(prefix, new ArrayList<>());
            map.get(prefix).add(i);
        }

        return ans;
    }
}
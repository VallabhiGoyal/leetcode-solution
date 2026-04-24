// Last updated: 4/24/2026, 10:31:47 AM
class Solution {
    public boolean hasAllCodes(String s, int k) {

        if (s.length() < k) return false;

        int total = 1 << k;
        boolean[] seen = new boolean[total];

        int mask = total - 1;
        int curr = 0;
        int count = 0;

        for (int i = 0; i < s.length(); i++) {

            curr = ((curr << 1) & mask) | (s.charAt(i) - '0');

            if (i >= k - 1 && !seen[curr]) {
                seen[curr] = true;
                count++;

                if (count == total) return true;
            }
        }

        return false;
    }
}

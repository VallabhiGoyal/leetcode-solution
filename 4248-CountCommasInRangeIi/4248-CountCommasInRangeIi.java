// Last updated: 4/24/2026, 10:29:32 AM
class Solution {
    public long countCommas(long n) {
        long temp = n;
        long count = 0;

        long start = 1000;
        int commas = 1;

        while (start <= temp) {
            long end = start * 1000 - 1;
            long upper = Math.min(temp, end);

            count += (upper - start + 1) * commas;

            start *= 1000;
            commas++;
        }

        return count;
    }
}
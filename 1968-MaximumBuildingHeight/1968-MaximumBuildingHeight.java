// Last updated: 7/3/2026, 11:37:35 AM
class Solution {
    public int maxBuilding(int n, int[][] restrictions) {
        int m = restrictions.length;

        if (m == 0) return n - 1;

        int[][] arr = new int[m + 2][2];

        arr[0][0] = 1;
        arr[0][1] = 0;

        for (int i = 0; i < m; i++) {
            arr[i + 1] = restrictions[i];
        }

        arr[m + 1][0] = n;
        arr[m + 1][1] = n - 1;

        Arrays.sort(arr, (a, b) -> a[0] - b[0]);

        m = arr.length;

        for (int i = 0; i < m - 1; i++) {
            int h1 = arr[i][1];
            int h2 = arr[i + 1][1];

            int j = arr[i][0];
            int k = arr[i + 1][0];

            arr[i + 1][1] = Math.min(h2, h1 + k - j);
        }

        for (int i = m - 1; i > 0; i--) {
            int h1 = arr[i][1];
            int h2 = arr[i - 1][1];

            int j = arr[i][0];
            int k = arr[i - 1][0];

            arr[i - 1][1] = Math.min(h2, h1 + j - k);
        }

        int maxPeak = 0;

        for (int i = 0; i < m - 1; i++) {
            int h1 = arr[i][1];
            int h2 = arr[i + 1][1];

            int j = arr[i][0];
            int k = arr[i + 1][0];

            maxPeak = Math.max(maxPeak, (h1 + h2 + k - j) / 2);
        }

        return maxPeak;
    }
}
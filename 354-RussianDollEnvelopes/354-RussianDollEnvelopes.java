// Last updated: 4/24/2026, 10:34:18 AM
class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        int n = envelopes.length;

        Arrays.sort(envelopes, (a,b) -> {
            if(a[0] != b[0]) return a[0] - b[0];
            else return b[1] - a[1];
        });

        int[] dp = new int[n];
        int size = 0;

        for(int i = 0; i<n; i++){
            int h = envelopes[i][1];

            int j = binarySearch(dp, 0, size, h);

            dp[j] = h;
            if(j == size) size++;
        }

        return size;
    }

    public int binarySearch(int[] dp, int left, int right, int h){
        while(left < right){
            int mid = left + (right - left) / 2;

            if(dp[mid] < h){
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

}
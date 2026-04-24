// Last updated: 4/24/2026, 10:35:35 AM
class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;

        int[] temp = new int[n];

        for(int i = 0; i<n; i++){
            if(i-1>=0 && ratings[i] > ratings[i-1]){
                temp[i] = temp[i-1]+1;
            }else{
                temp[i] = 1;
            }
        }

        for(int i = n-1; i>=0; i--){
            if(i<n-1 && ratings[i] > ratings[i+1]){
                if(temp[i+1] >= temp[i]) temp[i] = temp[i+1]+1;
            }
        }

        int ans = 0;
        for(int i = 0; i<n; i++){
            ans += temp[i];
        }

        return ans;
    }
}
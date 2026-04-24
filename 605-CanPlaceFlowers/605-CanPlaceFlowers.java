// Last updated: 4/24/2026, 10:33:32 AM
class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int size = flowerbed.length;

        if(n==0) return true;
        if(size == 1){
            if(flowerbed[0] == 0 && n == 1) return true;
            return false;
        }

        if(flowerbed[0] == 0 && flowerbed[1] == 0){
            flowerbed[0] = 1;
            n--;
            if(n <= 0) return true;
        }

        for(int i = 1; i<size-1; i++){
            if(flowerbed[i]  == 0 && flowerbed[i-1] == 0 && flowerbed[i+1] == 0){
                flowerbed[i] = 1;
                n--;
                if(n <= 0) return true;
            }
        }
        if(flowerbed[size-1] == 0 && flowerbed[size-2] == 0) n--;
        return n <= 0;
    }
}
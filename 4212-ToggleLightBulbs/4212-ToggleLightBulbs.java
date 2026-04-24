// Last updated: 4/24/2026, 10:29:46 AM
class Solution {
    public List<Integer> toggleLightBulbs(List<Integer> bulbs) {
        List<Integer> list = new ArrayList<>();

        int[] count = new int[101];
        for(int i = 0; i<bulbs.size(); i++){
            count[bulbs.get(i)]++;
        }

        for(int i = 1; i<101; i++){
            if(count[i]%2!=0){
                list.add(i);
            }
        }

        return list;
    }
}
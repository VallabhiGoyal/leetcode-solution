// Last updated: 4/24/2026, 10:32:07 AM
class Solution {
    public int longestSubsequence(int[] arr, int difference) {
        int n = arr.length;

        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i<n; i++){
            int diff = arr[i] - difference;
            if(map.containsKey(diff)){
                map.put(arr[i], map.get(diff) + 1);
            }else{
                map.put(arr[i], 1);
            }
        }

        int max = 1;
        for(int value : map.values()){
            if(max < value) max = value;
        }

        return max;
    }
}
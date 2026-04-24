// Last updated: 4/24/2026, 10:32:08 AM
class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        int n = arr.length;

        Map<Integer, Integer> fmap = new HashMap<>();

        for(int i = 0; i<n; i++){
            fmap.put(arr[i], fmap.getOrDefault(arr[i], 0) + 1);
        }

        Set<Integer> set = new HashSet<>();
        for(int value : fmap.values()){
            if(!set.add(value)) return false;
        }

        return true;
    }
}